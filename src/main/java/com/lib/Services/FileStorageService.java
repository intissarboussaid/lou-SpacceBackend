package com.lib.Services;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.lib.models.Admin;
import com.lib.models.ProductsPhoto;
import com.lib.models.FileDB;
import com.lib.models.Product;
import com.lib.repository.AdminRepository;
import com.lib.repository.FileDBRepository;
import com.lib.repository.ProductRepository;
import com.lib.repository.ProductsPhotoRepository;

@Service
public class FileStorageService {
	@Autowired
	  private ProductsPhotoRepository productsPhotoRepository;
	@Autowired
	  private ProductRepository productRepository;
	@Autowired
	  private FileDBRepository fileDBRepository;
	@Autowired
	  private AdminRepository adminRepository;
	
	  public FileDB store2(long idAdmin,MultipartFile file) throws IOException {
		    Admin ad1=adminRepository.findByidAdmin(idAdmin);	
		    
		    String fileName = StringUtils.cleanPath(file.getOriginalFilename());		  
		    System.out.println( "fileName: "+ fileName);
	        System.out.println("test fil name of image "+fileName);
		    FileDB FileDB = new FileDB();
		   // FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes(),ad1);
		    System.out.println("test File DB of image "+FileDB);
		    //ad1.setFiles(FileDB);
		    return fileDBRepository.save(FileDB);
		  }

	
	public Set<ProductsPhoto> SaveProductsPhoto (long idproduct,MultipartFile file) throws IOException {
		    Product P= productRepository.findByIdProduct(idproduct);	
		    ProductsPhoto FileDB=new  ProductsPhoto();
		    String fileName = StringUtils.cleanPath(file.getOriginalFilename());		  
		    System.out.println( "fileName: "+ fileName);
	        System.out.println("test fil name of image "+fileName);
		    FileDB.setName(fileName);
		    FileDB.setType( file.getContentType());
		    FileDB.setData(file.getBytes());
		    FileDB.setProduct(P);
		    System.out.println("test File DB of image "+FileDB);
		    //ad1.setFiles(FileDB);
		    return (Set<ProductsPhoto>) productsPhotoRepository.save(FileDB);
		     
		  }
		 

	  public FileDB store(MultipartFile file) throws IOException {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	  
	    System.out.println( "fileName: "+ fileName);
        System.out.println("test fil name of image "+fileName);
	    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
	    System.out.println("test File DB of image "+FileDB);
	    return fileDBRepository.save(FileDB);
	  }

	  public FileDB getFile(long id) {
	    return fileDBRepository.findById(id).get();
	  }
	
	 
	  
	  public Stream<FileDB> getAllFiles() {
	    return fileDBRepository.findAll().stream();
	  }
	  
	  public List<FileDB> getAllFilesByName(String name) {
		    return fileDBRepository.findByname(name);
		  }
}
