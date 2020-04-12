package com.vr.springmvc.boot;

import com.vr.springmvc.ProductRepository;
import com.vr.springmvc.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

  private ProductRepository productRepository;

  @Autowired
  public void setProductRepository(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public void run(String... args) throws Exception {


    Product pro = new Product();
    pro.setName("Apple Airpods");
    pro.setDescription("Portable wireless earphones");
    pro.setCategory("Music");
    pro.setType("Wireless");
    pro.setPrice(159.99);

    productRepository.save(pro);

    Product pro2 = new Product();
    pro2.setName("Beats Pro");
    pro2.setDescription("Portable wired headphones");
    pro2.setCategory("Music");
    pro2.setType("Wired");
    pro2.setPrice(299.99);

    productRepository.save(pro2);



  }
}
