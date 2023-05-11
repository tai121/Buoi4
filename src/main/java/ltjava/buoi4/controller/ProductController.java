package ltjava.buoi4.controller;

import ltjava.buoi4.model.Product;
import ltjava.buoi4.survice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService service;
    @RequestMapping("/products")
    public String Home(Model model){
        List<Product> productList = service.findAll();
        model.addAttribute("Products",productList);
        return "products/index";
    }
}
