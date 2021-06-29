package com.te.productmangment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.productmangment.bean.Products;
import com.te.productmangment.dao.ProductDAO;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDAO dao;
	@Override
	public boolean addProduct(Products products) {
		return dao.addProduct(products);
	}
	@Override
	public Products getProductsinfo(int id) {
		if (id <= 0) {
			return null;
		}
		return dao.getProductsinfo(id);
	}
	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		return dao.deleteProduct(id);
	}
	@Override
	public boolean updateRecord(Products products) {
		// TODO Auto-generated method stub
		return dao.updateRecord(products);
	}
	@Override
	public List<Products> getAllproducts() {
		// TODO Auto-generated method stub
		return dao.getAllproducts();
	}
	@Override
	public Products getUpdateId(Integer id) {
		// TODO Auto-generated method stub
		return dao.getUpdateId(id);
	}

}
