package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.dao.ProductDao;
import pl.coderslab.entities.Category;
import pl.coderslab.entities.Product;
import pl.coderslab.repositories.ProductRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
    private final CategoryDao categoryDao;
    private final ProductDao productDao;
    private final ProductRepository productRepository;


    public CategoryController(CategoryDao categoryDao, ProductDao productDao, ProductRepository productRepository) {
        this.categoryDao = categoryDao;
        this.productDao = productDao;

        this.productRepository = productRepository;
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id) {
        model.addAttribute("category", categoryDao.findById(id));
        return "category/editCat";
    }

    @PostMapping("/update/{id}")
    public String updating(@Valid Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "category/editFail";
        }
        categoryDao.editCat(category);
        return "category/editSuccessful";
    }

    @GetMapping("/addCategory")
    public String addCat(Model model) {
        model.addAttribute("category", new Category());
        return "category/addCategory";
    }

    @PostMapping("/addCategory")
    public String addCatResult(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category/categoryFail";
        }
        categoryDao.addCategory(category);
        return "category/categoryAdded";
    }

    @GetMapping("/categories")
    public String showCategories(Model model) {
        model.addAttribute("categories", categoryDao.categoryList());
        return "category/showCategories";
    }

    @GetMapping("delete/{id}")
    public String deleting(@PathVariable Long id) {
        List<Product> productByCategory = productRepository.findProductByCategory(id);
        for (Product product : productByCategory) {
            productDao.delete(product);
        }
        categoryDao.delete(categoryDao.findById(id));
        return "category/deleted";
    }

}
