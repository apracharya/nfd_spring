package com.teamfilm.nfd.service.category;

import com.teamfilm.nfd.exception.AlreadyExistsException;
import com.teamfilm.nfd.exception.NotFoundException;
import com.teamfilm.nfd.persistence.category.CategoryEntity;
import com.teamfilm.nfd.persistence.category.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryServiceImplementation implements CategoryService{


    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImplementation(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryModel createCategory(CategoryModel category) {
        CategoryEntity entity = category.toEntity();
        if( ! categoryRepository.existsById(entity.getCategoryId())) {
            CategoryEntity created = categoryRepository.save(entity);
            return CategoryModel.fromEntity(created);
        } else {
            throw new AlreadyExistsException("Category already exists");
        }
    }

    @Override
    public CategoryModel updateCategory(CategoryModel category, int categoryId) {
        CategoryEntity categ = categoryRepository.findById(categoryId)
                .orElseThrow(NotFoundException::new);
        categ.setCategoryTitle(category.getCategoryTitle());
        categ.setCategoryDescription(category.getCategoryDescription());
        CategoryEntity updated = categoryRepository.save(categ);
        return CategoryModel.fromEntity(updated);
    }

    @Override
    public Optional<CategoryModel> readCategory(int categoryId) {
//        CategoryEntity category = categoryRepository.findById(categoryId)
//                .orElseThrow(NotFoundException::new);
//        return modelMapper.map(category, CategoryModel.class);
        return categoryRepository.findById(categoryId)
                .map(CategoryModel::fromEntity);
    }

    @Override
    public List<CategoryModel> readAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryModel::fromEntity)
                .toList();

    }

    @Override
    public void deleteCategory(int categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
