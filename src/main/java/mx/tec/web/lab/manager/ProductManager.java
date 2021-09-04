/*
 * ProductManager
 * Version 1.0
 * August 14, 2021 
 * Copyright 2021 Tecnologico de Monterrey
 */
package mx.tec.web.lab.manager;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mx.tec.web.lab.controller.ProductController;
import mx.tec.web.lab.dao.ProductDAO;
import mx.tec.web.lab.vo.ProductVO;


/**
 * The Product Manager with all the available business operations for the products
 * @author Enrique Sanchez
 * @version 1.0
 */
@Service
public class ProductManager {
	/**
	 * Reference to the Product DAO
	 */
	@Resource
	private ProductDAO productDAO;
	
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	/**
	 * Retrieve all the products
	 * @return List of products
	 */
	public List<ProductVO> getProducts() {
		log.info("Get all products.");
		return productDAO.findAll();
	}

	/**
	 * Retrieve an specific product based on a given product id
	 * @param id Product id
	 * @return Optional containing a product if the product was found or empty otherwise
	 */
	public Optional<ProductVO> getProduct(final long id) {
		log.info("Get a product based on id: {}", id);
		return productDAO.findById(id);
	}

	/**
	 * Retrieve an specific product based on a given product id
	 * @param pattern Pattern to search
	 * @return Optional containing a product if the product was found or empty otherwise
	 */
	public List<ProductVO> getProducts(final String pattern) {
		log.info("Get all product that match the pattern: {}", pattern);
		return productDAO.findByNameLike(pattern);
	}
	
	/**
	 * Add a new Product to the product list based on a given product
	 * @param newProduct Product to add
	 * @return An Optional containing the new product
	 */
	public ProductVO addProduct(final ProductVO newProduct) {
		log.info("Add a Product object to the database: {}", newProduct);
		return productDAO.insert(newProduct);
	}
	
	/**
	 * Delete the product based on a given product
	 * @param existingProduct The product to delete
	 */
	public void deleteProduct(final ProductVO existingProduct) {
		log.info("Delete an existing product from the database: {}", existingProduct);
		productDAO.remove(existingProduct);
	}
	
	/**
	 * Update an existing product based on a given modified product and a product id
	 * @param id The product id for the original product
	 * @param modifiedProduct The product new version
	 */
	public void updateProduct(final long id, final ProductVO modifiedProduct) {
		log.info("Update a Product object of id: {}, with modified Product: {}", id, modifiedProduct);
		final Optional<ProductVO> existingProduct = getProduct(id);
		
		if (existingProduct.isPresent()) {
			productDAO.update(modifiedProduct);
		}
	}		
}
