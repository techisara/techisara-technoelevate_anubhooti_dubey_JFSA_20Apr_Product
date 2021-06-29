package com.te.productmangment.dao;

import java.util.List;


import com.te.productmangment.bean.Products;

public interface ProductDAO {
	public boolean addProduct(Products product);
	

	public Products getProductsinfo(int id);

	public boolean deleteProduct(int id);


	public boolean updateRecord(Products products);

	public List<Products> getAllproducts();
	
	public Products getUpdateId(Integer id);

}
