package com.arrizaqu.test.myecommerce.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arrizaqu.test.myecommerce.entity.Product;
import com.arrizaqu.test.myecommerce.repository.ProductRepo;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;

	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

}
