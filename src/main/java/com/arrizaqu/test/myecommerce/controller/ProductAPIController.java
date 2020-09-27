package com.arrizaqu.test.myecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arrizaqu.test.myecommerce.entity.Product;
import com.arrizaqu.test.myecommerce.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductAPIController {

	@Autowired
	private ProductService productService;
	//show all products
	@GetMapping
	public List<Product> index() {
		List<Product> products = this.productService.findAll();
		return products;
	}
}
