package com.tranhieu.demobackend.services.impl;

import com.tranhieu.demobackend.entities.Category;
import com.tranhieu.demobackend.exceptions.ResourceNotFoundException;
import com.tranhieu.demobackend.payloads.CategoryDto;
import com.tranhieu.demobackend.repositories.CategoryRepo;
import com.tranhieu.demobackend.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat = this.modelMapper.map(categoryDto, Category.class);
        Category addedCategory= this.categoryRepo.save(cat);
        return this.modelMapper.map(addedCategory,CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category cat =this.categoryRepo.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category","categoryId",categoryId));
        cat.setCategoryTitle(categoryDto.getCategoryTitle());
        cat.setCategoryDescription(categoryDto.getCategoryDescription());
        Category updateCat=this.categoryRepo.save(cat);
        return this.modelMapper.map(updateCat,CategoryDto.class);

    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
        this.categoryRepo.delete(cat);
    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category"," category id",categoryId));
        return this.modelMapper.map(cat,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getCategoryAll() {
        List<Category> categories = this.categoryRepo.findAll();
        List<CategoryDto> categories1=categories.stream().map((category)-> this.modelMapper.map(category,CategoryDto.class)).collect(Collectors.toList());
        return categories1;
    }
}
