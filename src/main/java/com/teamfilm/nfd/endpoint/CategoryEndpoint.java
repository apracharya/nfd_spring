package com.teamfilm.nfd.endpoint;

import com.teamfilm.nfd.exception.AlreadyExistsException;
import com.teamfilm.nfd.exception.NotFoundException;
import com.teamfilm.nfd.request.category.CategoryPostRequest;
import com.teamfilm.nfd.request.category.CategoryPutRequest;
import com.teamfilm.nfd.request.category.CategoryRequestMapper;
import com.teamfilm.nfd.response.ErrorResponse;
import com.teamfilm.nfd.response.Response;
import com.teamfilm.nfd.response.category.CategoryGetResponse;
import com.teamfilm.nfd.response.category.CategoryPostResponse;
import com.teamfilm.nfd.response.category.CategoryPutResponse;
import com.teamfilm.nfd.response.category.CategoryResponseMapper;
import com.teamfilm.nfd.service.category.CategoryModel;
import com.teamfilm.nfd.service.category.CategoryService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/category")
public class CategoryEndpoint {
    private final CategoryService categoryService;

    public CategoryEndpoint(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping("/create")
    public ResponseEntity<Response> createCategory(@Valid @RequestBody CategoryPostRequest category) {
        try {
            CategoryModel model = CategoryRequestMapper.toModel(category);
            CategoryModel created = categoryService.createCategory(model);
            CategoryPostResponse response = CategoryResponseMapper.toPostResponse(created);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (AlreadyExistsException e) {
            ErrorResponse response = new ErrorResponse("Category Already Exists");
            System.out.println("NO!");
            return new ResponseEntity<>(response, HttpStatus.PRECONDITION_FAILED);
        } catch (Exception e) {
            System.out.println("NOPE!!");
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.PRECONDITION_FAILED);
        }
    }

    @GetMapping("/read")
    public ResponseEntity<List<CategoryModel>> readAllFilms() {
        try {
            return new ResponseEntity<>(categoryService.readAllCategories(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
        }
    }


    @GetMapping("/read/{id}")
    public ResponseEntity<Response> readFilm(@PathVariable("id") int categoryId) {
        try {
            CategoryGetResponse response = categoryService.readCategory(categoryId)
                    .map(CategoryResponseMapper::toGetResponse)
                    .orElseThrow(NotFoundException::new);
            return ResponseEntity.ok(response);
        } catch(NotFoundException e) {
            log.warn("category not found");
            Response response = new ErrorResponse("Category not found!");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch(Exception e) {
            log.warn(e.getMessage());
            Response response = new ErrorResponse(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateCategory(@Valid @RequestBody CategoryPutRequest request, @PathVariable("id") int categoryId) {
        try {
            CategoryModel model = CategoryRequestMapper.toModel(request);
            CategoryPutResponse response = CategoryResponseMapper.toPutResponse(categoryService.updateCategory(model, categoryId));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(new ErrorResponse("category not found"), HttpStatus.PRECONDITION_FAILED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.PRECONDITION_FAILED);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable("id") int categoryId) {
        categoryService.deleteCategory(categoryId);

    }
}
