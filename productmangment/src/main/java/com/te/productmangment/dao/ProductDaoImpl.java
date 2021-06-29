package com.te.productmangment.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import com.te.productmangment.bean.Products;
@Repository
public class ProductDaoImpl implements ProductDAO{

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean addProduct(Products product) {
		boolean isInserted = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			manager.persist(product);
			transaction.commit();
			isInserted = true;
		} catch (Exception e) {
			transaction.rollback();
			System.out.println("roll back");
			e.printStackTrace();
		}

		return isInserted;
	}

	@Override
	public Products getProductsinfo(int id) {
		EntityManager manager = factory.createEntityManager();
		Products product = manager.find(Products.class, id);
		manager.close();
		factory.close();
		return product;
		
	}

	@Override
	public boolean deleteProduct(int id) {
		boolean isDeleted = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Products product = manager.find(Products.class, id);
			manager.remove(product);
			transaction.commit();
			isDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}

		return isDeleted;
	}

	@Override
	public boolean updateRecord(Products products) {
		boolean isUpdated = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Products actualInfo = manager.find(Products.class, products.getPid());

			if (products.getPname() != null && products.getPname()!= "") {
				actualInfo.setPname(products.getPname());
			}

			if (products.getMgDate() != null) {
				actualInfo.setMgDate(products.getMgDate());;
			}
			if (products.getExDate() != null) {
				actualInfo.setExDate(products.getExDate());;
			}
			if (products.getPrice() != null) {
				actualInfo.setPrice(products.getPrice());;
			}
			if (products.getQuantity() != null) {
				actualInfo.setQuantity(products.getQuantity());;
			}

			
			transaction.commit();
			isUpdated = true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

		return isUpdated;
	}

	@Override
	public List<Products> getAllproducts() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("from Products");
		ArrayList<Products> productsList = new ArrayList<Products>();
		try {
			productsList = (ArrayList<Products>) query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			productsList = null;
		}

		return productsList;
	}

	@Override
	public Products getUpdateId(Integer id) {
		EntityManager manager = factory.createEntityManager();
		Products product = manager.find(Products.class, id);
		manager.close();
		factory.close();
		return product;
	}

}
