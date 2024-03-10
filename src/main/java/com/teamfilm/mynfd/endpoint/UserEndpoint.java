package com.teamfilm.mynfd.endpoint;

import com.teamfilm.mynfd.exception.AlreadyExistsException;
import com.teamfilm.mynfd.exception.NotFoundException;
import com.teamfilm.mynfd.request.user.UserPostRequest;
import com.teamfilm.mynfd.request.user.UserPutRequest;
import com.teamfilm.mynfd.request.user.UserRequestMapper;
import com.teamfilm.mynfd.response.ErrorResponse;
import com.teamfilm.mynfd.response.Response;
import com.teamfilm.mynfd.response.user.UserGetResponse;
import com.teamfilm.mynfd.response.user.UserPostResponse;
import com.teamfilm.mynfd.response.user.UserPutResponse;
import com.teamfilm.mynfd.response.user.UserResponseMapper;
import com.teamfilm.mynfd.service.user.UserModel;
import com.teamfilm.mynfd.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserEndpoint {

    private final UserService userService;

    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/create")
    public ResponseEntity<Response> createFilm(@RequestBody UserPostRequest user) {
        try {
            UserModel model = UserRequestMapper.toModel(user);
            UserModel created = userService.createUser(model);
            UserPostResponse response = UserResponseMapper.toPostResponse(created);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (AlreadyExistsException e) {
            ErrorResponse response = new ErrorResponse("User Already Exists");
            return new ResponseEntity<>(response, HttpStatus.PRECONDITION_FAILED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.PRECONDITION_FAILED);
        }
    }

    @PostMapping("/login")
    public String authenticate(@RequestHeader("Authorization") String token){
        boolean isAuthorized = userService.authenticate(token);
        if(isAuthorized) {
            return "authenticated";
        } else {
            return "couldn't authenticate";
        }
    }

    @GetMapping("/read")
    public ResponseEntity<List<UserModel>> readAllFilms() {
        try {
            return new ResponseEntity<>(userService.readAllUsers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
        }
    }


    @GetMapping("/read/{id}")
    public ResponseEntity<Response> readFilm(@PathVariable("id") int userId) {
        try {
            UserGetResponse response = userService.readUser(userId)
                    .map(UserResponseMapper::toGetResponse)
                    .orElseThrow(NotFoundException::new);
            return ResponseEntity.ok(response);
        } catch(NotFoundException e) {
            log.warn("user not found");
            Response response = new ErrorResponse("User not found!");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch(Exception e) {
            log.warn(e.getMessage());
            Response response = new ErrorResponse(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateUser(@RequestBody UserPutRequest request, @PathVariable("id") int userId) {
        UserModel model = UserRequestMapper.toModel(request);
        UserPutResponse response = UserResponseMapper.toPutResponse(userService.updateUser(model, userId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }
}
