package com.te.productmangment.services;

import java.util.List;

import com.te.productmangment.bean.Products;

public interface ProductService {
	
	public boolean addProduct(Products products);
	
	public Products getProductsinfo(int id);

	public boolean deleteProduct(int id);


	public boolean updateRecord(Products products);

	public List<Products> getAllproducts();
	
	public Products getUpdateId(Integer id);

}
