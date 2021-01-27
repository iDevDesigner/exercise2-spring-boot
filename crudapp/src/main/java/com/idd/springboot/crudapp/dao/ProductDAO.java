package com.idd.springboot.crudapp.dao;

import java.util.List;

import com.idd.springboot.crudapp.entity.Product;

public interface ProductDAO {

	public List<Product> getProducts();

	public Product getProduct(int theId);

	public void deleteProduct(int theId);

}
