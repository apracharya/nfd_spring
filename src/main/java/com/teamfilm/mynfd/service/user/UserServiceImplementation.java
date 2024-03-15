package com.teamfilm.mynfd.service.user;

import com.teamfilm.mynfd.exception.AlreadyExistsException;
import com.teamfilm.mynfd.exception.NotFoundException;
import com.teamfilm.mynfd.exception.ResourceNotFoundException;
import com.teamfilm.mynfd.persistence.user.UserEntity;
import com.teamfilm.mynfd.persistence.user.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public UserServiceImplementation(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserModel createUser(UserModel user) {

        UserEntity entity = modelMapper.map(new UserModel(
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                this.passwordEncoder.encode(user.getPassword()),
                user.getRoles()
        ), UserEntity.class);

        if( ! userRepository.existsById(entity.getUsername())) {
            UserEntity created = userRepository.save(entity);
            return modelMapper.map(created, UserModel.class);
        } else {
            throw new AlreadyExistsException("User already exists");
        }
    }

    @Override
    public UserModel readUser(String username) {
        UserEntity entity = userRepository.findById(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "with id", username));
        return modelMapper.map(entity, UserModel.class);
    }

    @Override
    public List<UserModel> readAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserModel.class))
                .toList();
    }

    @Override
    public UserModel updateUser(UserModel userModel, String username) {
        UserEntity user = userRepository.findById(username)
                .orElseThrow(() -> new NotFoundException("User with username " + username + " not found"));
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setPassword(this.passwordEncoder.encode(userModel.getPassword()));
        user.setUsername(userModel.getUsername());
        UserEntity updated = userRepository.save(user);
        return modelMapper.map(updated, UserModel.class);
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    @Override
    public boolean authenticate(String token) {
        String[] split = token.split(" ");
        if(split[0].equals("Basic")) {
            byte[] bytePwd = Base64.getDecoder().decode(split[1]);
            String[] userPass = new String(bytePwd).split(":", 2);
            String username = userPass[0];
            String password = userPass[1];
            UserEntity entity = userRepository.findByUsername(username)
                    .orElseThrow(() -> new ResourceNotFoundException("User", "with username", username));
            if(entity != null) {
                String encodedPassword = entity.getPassword();
                boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
                if(isPwdRight) {
                    Optional<UserEntity> user = userRepository.findByUsernameAndPassword(username, encodedPassword);
                    return user.isPresent();
                }
            }
        }
        return false;
    }
}
