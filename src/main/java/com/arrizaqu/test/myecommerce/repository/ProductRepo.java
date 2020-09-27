package com.arrizaqu.test.myecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arrizaqu.test.myecommerce.entity.Product;

public interface ProductRepo extends JpaRepository<Product, String>{

}
