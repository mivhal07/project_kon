package pl.coderslab.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Dao.CategoryDao;
import pl.coderslab.Dao.ProductDao;
import pl.coderslab.Entities.Category;
import pl.coderslab.Entities.Product;

import javax.validation.Valid;
import java.util.Collection;

@Controller
public class ProductController {
    private final ProductDao productDao;
    private final CategoryDao categoryDao;

    public ProductController(ProductDao productDao, CategoryDao categoryDao) {
        this.productDao = productDao;
        this.categoryDao = categoryDao;
    }

    @GetMapping("/product/showAllProducts")
    public String showAll(Model model) {
        model.addAttribute("products", productDao.productList());
        return "product/showAllProducts";
    }

    @GetMapping("/product/showAllKuchenne")
    public String showAllKuchenne(Model model) {
        model.addAttribute("products", productDao.productListByKuchenne());
        return "product/showAllKuchenne";
    }

    @GetMapping("/product/showAllBiżuteria")
    public String showAllBiżuteria(Model model) {
        model.addAttribute("products", productDao.productListByBiżuteria());
        return "product/showAllBiżuteria";
    }

    @GetMapping("/product/showAllDonice")
    public String showAllDonice(Model model) {
        model.addAttribute("products", productDao.productListByDonice());
        return "product/showAllDonice";
    }

    @GetMapping("/admin/product/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryDao.categoryList());
        return "product/addProduct";
    }

    @PostMapping("/admin/product/add")
    public String resultAddProduct(@Valid Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            for (ObjectError allError : result.getAllErrors()) {
                System.out.println(allError);
            }

            model.addAttribute("categories", categoryDao.categoryList());
            return "product/addProduct";
        }
        productDao.addProduct(product);
        return "product/productAdded";
    }

    @GetMapping("/product/addToCart")
    @ResponseBody
    public String buyProduct(@PathVariable Long id, Product product) {
        Product productById = productDao.findProductById(id);
        productById.setQuantity(product.getQuantity() - 1);
        return "Zmniejszyłeś ilość produktu: " + productById;
    }

    @ModelAttribute("categories")
    public Collection<Category> categories() {
        return this.categoryDao.categoryList();
    }

}
