package com.vr.springmvc;

import com.vr.springmvc.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
//public interface ProductRepository extends CrudRepository<Product,String> {



}
