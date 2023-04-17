package com.tranhieu.demobackend.controllers;

import com.tranhieu.demobackend.payloads.ApiResponse;
import com.tranhieu.demobackend.payloads.CategoryDto;
import com.tranhieu.demobackend.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    // create
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createCategoryDto = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createCategoryDto, HttpStatus.CREATED);
    }

    // update
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable("categoryId") Integer cId){
        CategoryDto updateCategoryDto =this.categoryService.updateCategory(categoryDto,cId);
        return ResponseEntity.ok(updateCategoryDto);
    }


    // delete
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("categoryId") Integer cId){
        this.categoryService.deleteCategory(cId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Success",true),HttpStatus.OK);
    }

    //get
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        List<CategoryDto> categoryDto= this.categoryService.getCategoryAll();
        return ResponseEntity.ok(categoryDto);
    }
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getSingleCategory(@PathVariable Integer categoryId){
        CategoryDto categoryDto = this.categoryService.getCategoryById(categoryId);
        return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
        //return ResponseEntity.ok(this.categoryService.getCategoryById(categoryId));
    }
}
