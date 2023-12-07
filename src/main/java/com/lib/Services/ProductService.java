package com.lib.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.models.Admin;
import com.lib.models.Product;
import com.lib.repository.AdminRepository;
import com.lib.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private AdminRepository adminRepository;

	public Product AddNewProduct(long idAdmin,Product product) {
		 Admin admin = adminRepository.findByidAdmin(idAdmin);
		 System.out.println("Admin:  " +admin);
		 product.setAdmin(admin);
		 return productRepository.save(product);
	}

}
