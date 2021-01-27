package com.idd.springboot.crudapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idd.springboot.crudapp.dao.ProductDAO;
import com.idd.springboot.crudapp.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	@Transactional
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productDAO.getProducts();
	}

	@Override
	@Transactional
	public Product getProduct(int theId) {
		// TODO Auto-generated method stub
		return productDAO.getProduct(theId);
	}

	@Override
	@Transactional
	public void deleteProduct(int theId) {
		// TODO Auto-generated method stub
		productDAO.deleteProduct(theId);
	}

}
