package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.ProductDao;
import pl.coderslab.entities.Category;
import pl.coderslab.entities.Product;
import pl.coderslab.repositories.ProductRepository;

import javax.validation.Valid;

@Controller
public class ProductController {
    private final ProductDao productDao;
    private final CategoryDao categoryDao;
    private final ProductRepository productRepository;


    public ProductController(ProductDao productDao, CategoryDao categoryDao, ProductRepository productRepository) {
        this.productDao = productDao;
        this.categoryDao = categoryDao;
        this.productRepository = productRepository;

    }
    /*
    kategorie
    karta zakupów
     */

    @GetMapping("/product/showAllProducts")
    public String showAll(Model model) {
        model.addAttribute("products", productDao.productList());
        model.addAttribute("categories", categoryDao.categoryList());
        return "product/showAllProducts";
    }

    @GetMapping("/showAllByCat/{id}")
    public String showAllByCat(@PathVariable Long id, Model model) {
        model.addAttribute("productsByCat", productRepository.findProductByCategory(id));
        return "product/showAllFromCat";
    }

    @GetMapping("/admin/product/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryDao.categoryList());
        return "product/addProduct";
    }

    @PostMapping("/admin/product/add")
    public String resultAddProduct(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "product/addProductFail";
        }
        productDao.addProduct(product);
        return "product/productAdded";
    }


    @GetMapping("product/editProduct/{id}")
    public String editProduct(@PathVariable Long id, Model model){
        model.addAttribute("product", productDao.findProductById(id));
        model.addAttribute("categories", categoryDao.categoryList());
        return "product/editProduct";
    }

    @PostMapping("product/editProduct/{id}")
    public String updating(@Valid Product product, BindingResult result){
        if (result.hasErrors()){
            return "product/editFail";
        }
        productDao.editProduct(product);
        return "product/editGood";
    }

    @GetMapping("delete/{id}")
    public String deleting(@PathVariable Long id, Model model){
        productDao.delete(productDao.findProductById(id));
        return "product/deleted";
    }

}
