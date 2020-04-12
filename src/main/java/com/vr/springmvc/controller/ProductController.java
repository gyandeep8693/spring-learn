package com.vr.springmvc.controller;


import com.vr.springmvc.ProductRepository;
import com.vr.springmvc.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;


@Controller

public class ProductController {

  private ProductRepository productRepository;

  @Autowired
  public void setProductRepository(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @RequestMapping(path = "/")
  public String index(){

    return "index";
  }

  @RequestMapping(path = "/products/add", method = RequestMethod.GET)
  public String createProduct(Model model){

     model.addAttribute("product", new Product());
     return "edit";

  }

  @RequestMapping(path = "products", method = RequestMethod.POST)
  public String saveProduct(Product product){

    productRepository.save(product);
    return "redirect:/";

  }

  @RequestMapping(path="/products", method = RequestMethod.GET)
  public String getAllProducts(Model model){
    model.addAttribute("products",productRepository.findAll());
    return "products";
  }

  @RequestMapping(path="/products/edit/{id}", method = RequestMethod.GET)
  public String editProduct(Model model, @PathVariable(value = "id") String id){

    Optional<Product> byId = productRepository.findById(id);

    model.addAttribute("product",byId.get());


    return "edit";

  }

  @RequestMapping(path="/products/delete/{id}", method = RequestMethod.GET)
  public String deleteProduct(Model model, @PathVariable(value = "id") String id) {

    Optional<Product> byId = productRepository.findById(id);

    productRepository.delete(byId.get());

    return "redirect:/products";
  }

}
