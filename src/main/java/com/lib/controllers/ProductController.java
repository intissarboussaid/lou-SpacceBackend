package com.lib.controllers;

import java.io.IOException;
import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lib.Services.FileStorageService;
import com.lib.Services.ProductService;
import com.lib.models.Admin;
import com.lib.models.FileDB;
import com.lib.models.Product;
import com.lib.repository.AdminRepository;
import com.lib.repository.FileDBRepository;
import com.lib.repository.ProductRepository;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Product/")
public class ProductController {
	@Autowired
	private ProductService productService;

	@Autowired 
	ProductRepository  productRepository;
	@Autowired
	AdminRepository adminRepository;
	 @Autowired
	  private FileStorageService storageService;

	 @Autowired
	 FileDBRepository fileDBRepository;
	  
	  
	  @PutMapping("Update/{idproduct}")
	    public Product  GereProfil(@PathVariable(value = "idproduct")Long idproduct, @Validated @RequestBody Product productDetail) {
		  Product pro = productRepository.findByIdProduct(idproduct);
		  System.out.println(pro);
		  pro.setBrand(productDetail.getBrand());
		  pro.setRef(productDetail.getRef());
		  pro.setCollection(productDetail.getCollection());
		  pro.setColor(productDetail.getColor());
		  pro.setDetail(productDetail.getDetail());
		  pro.setProducDescription(productDetail.getProducDescription());
		  pro.setProductName(productDetail.getProductName());
		  pro.setProductActualPrice(productDetail.getProductActualPrice());
		  pro.setProductDiscountedPrice(productDetail.getProductDiscountedPrice());
		  pro.setSize(productDetail.getSize());
		  pro.setQuantite(productDetail.getQuantite());
		 /* if(productDetail.getRef()!=null) {
			  pro.setRef(productDetail.getRef()); 
		  }
		  if(productDetail.getRef()!=null) {
			  pro.setRef(productDetail.getRef());
		  }
		  System.out.println("get ref "+pro.getRef());
		 
		  if(productDetail.getDetail()!=null) {
			  pro.setDetail(productDetail.getDetail());
		  }
		 
		  
		  if(productDetail.getQuantite()!=0) {
			  pro.setQuantite(productDetail.getQuantite());
		  }
		
		  
		  if(productDetail.getBrand()!=null) {
			  pro.setBrand(productDetail.getBrand());
		  }
		  */
	    	 return productRepository.save(pro);
	    }	  
	  @GetMapping("AllProducts")
	  public List<Product> AfficherToutList_Product(){
		  return productRepository.findAll();
	  }
	  
	  @GetMapping("GetId/{idproduct}")
	  public Product getProductByIdProduct(@PathVariable(value = "idProduct")long id_Product){
		  return productRepository.findById(id_Product);
	  }
	  @GetMapping("GetProductByAdmin/{idAdmin}")
	  public List<Product> getProductByIdAdmint(@PathVariable(value = "idAdmin")long idAdmin){
		  
		  Admin admin = adminRepository.findById(idAdmin);
		  System.out.println("product "+productRepository.findByIdAdmin(admin));
		  return productRepository.findByIdAdmin(admin);
		  }
	  
	  @GetMapping("GetPrice/{price}")
	  public List<Product> GetProductName(@PathVariable(value = "price")float price){
		  return productRepository.findByPrice(price);
	  }
	  @GetMapping("GetProduct/{idproduct}")
	  public Product ById(@PathVariable(value = "idproduct")long idproduct){
		  return productRepository.findById(idproduct);
	  }
	  
	  @DeleteMapping("delete/{idProduct}")
	  public void DeleteProduct(@PathVariable(value = "idProduct")long id_Product) {
		  Product deco = productRepository.findByIdProduct(id_Product);
		  System.out.println("delete product winner ");
		  productRepository.delete(deco);
	  }
	  
	  public Product uploadFileProduct( long idProduct,@RequestParam("file") MultipartFile file) {
		  
		  Product product =new Product();
		    String message = "";
		    try {
		      FileDB files=storageService.store2(idProduct,file);
	          System.out.println("file Uploaded : "+files);
		      message = "Uploaded the file successfully: " + file.getOriginalFilename();
		    } catch (Exception e) {
		      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
		    }
		    return product;
		  }
	  
	/*  @PostMapping("addProduct/{idAdmin}")
	    public ResponseEntity<Product> addProduct(@PathVariable(value = "idAdmin")long idAdmin,@RequestParam("file") MultipartFile file) {
		   String productJson="";
		  
		  Admin admin = adminRepository.getByID(idAdmin);
		  
		  try {
	            ObjectMapper objectMapper = new ObjectMapper();
			  
	            Product product = objectMapper.readValue(productJson, Product.class);
			    Product product=new Product(); 
	            System.out.println("product :"+product);
	            product.setProductImage(file.getBytes());
	            product.setAdmin(admin);
	            System.out.println("product :"+product);
	         
	            Product savedProduct = productRepository.save(product);
	            
	            return ResponseEntity.ok(savedProduct);
	        } catch (IOException e) {
	            return ResponseEntity.badRequest().build();
	        }
	    }*/
	  
	   @PostMapping(value={"Add/{idAdmin}"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
		public Product AddProductWithPhoto(@Valid @PathVariable("idAdmin")long idAdmin, @RequestPart("product") Product product, @RequestPart("imageFile") MultipartFile[] file) {
           
		   
		  // productService.AddNewProduct(idAdmin, product);
			//return product;	
		   
		   try {
			   Set<FileDB>images =  uploadImage(file);
			   product.setImagesProduct(images);
			   return productService.AddNewProduct(idAdmin, product);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		     }
	  
	   public Set<FileDB> uploadImage(MultipartFile[] multipartfiles) throws IOException {
		   Set<FileDB> files = new HashSet<>();
		   for(MultipartFile file : multipartfiles) {
			   FileDB  fileDB = new FileDB(
			   file.getOriginalFilename(),
			   file.getContentType(),
			   file.getBytes());
			   files.add(fileDB);
		   }
		   return files;
		   
	   }
		 
	  
	
}
