package com.rikkei.ss08.controller;

import com.rikkei.ss08.model.Product;
import com.rikkei.ss08.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("products")
    public ModelAndView showProductList() {
        List<Product> productList = productService.getAllProducts();
        ModelAndView modelAndView = new ModelAndView("Bai2/product-list");
        modelAndView.addObject("products", productList);
        return modelAndView;
    }

    @GetMapping("products/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "Bai3/addProduct";
    }

    @PostMapping("products/add")
    public String submitForm(@ModelAttribute("product") Product product, Model model) {
        model.addAttribute("product", product);
        return "Bai3/view";
    }
}
