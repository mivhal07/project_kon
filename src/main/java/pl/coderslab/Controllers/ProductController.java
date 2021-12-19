package pl.coderslab.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.Dao.CategoryDao;
import pl.coderslab.Dao.OrderDao;
import pl.coderslab.Dao.ProductDao;
import pl.coderslab.Entities.Category;
import pl.coderslab.Entities.Product;
import pl.coderslab.Repositories.ProductRepository;

import javax.validation.Valid;

@Controller
public class ProductController {
    private final ProductDao productDao;
    private final CategoryDao categoryDao;
    private final OrderDao orderDao;
    private final ProductRepository productRepository;


    public ProductController(ProductDao productDao, CategoryDao categoryDao, OrderDao orderDao, ProductRepository productRepository) {
        this.productDao = productDao;
        this.categoryDao = categoryDao;
        this.orderDao = orderDao;
        this.productRepository = productRepository;

    }

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

    @GetMapping("/admin/addCategory")
    public String addCat(Model model) {
        model.addAttribute("category", new Category());
        return "product/addCategory";
    }

    @PostMapping("/admin/addCategory")
    public String addCatResult(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "product/categoryFail";
        }
        categoryDao.addCategory(category);
        return "product/categoryAdded";
    }

    //w tym miejscu kończę projekt, strasznie dużo czasu zabiera mi kombinowanie z tym koszykiem,
    //bo nic nie działa tak jak działało wcześniej
    @GetMapping("product/order/add/{id}")
    public String addToOrder(@PathVariable Long id) {
        Product productById = productDao.findProductById(id);
        System.out.println(productById.toString());
        orderDao.addProductToOrder(productById);
        return "cart/shopping";
    }

    @GetMapping("product/showCart")
    public String showCart() {


        return "cart/showCart";
    }

}
