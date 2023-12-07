package com.lib.controllers;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lib.Services.FileStorageService;
import com.lib.models.Admin;
import com.lib.models.FileDB;
import com.lib.models.ResponseFile;
import com.lib.models.ResponseMessage;
import com.lib.repository.AdminRepository;
import com.lib.repository.FileDBRepository;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/File/")
public class FileController {
	 
	  @Autowired
	  private FileStorageService storageService;
	  @Autowired
	  private AdminRepository adminRepository;
	  @Autowired
	  private FileDBRepository fileRepository;
	
//Upload Profil photo for Adimn
	  @PostMapping("upload/{idAdmin}")
	  public ResponseEntity<?> uploadFileByAdmin( @PathVariable(value = "idAdmin")long idAdmin,@RequestParam("file") MultipartFile file) {
		  
		  
	    String message = "";
	    try {
	      FileDB files=storageService.store2(idAdmin,file);
          System.out.println("file Uploaded : "+files);
	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }
	  
	  @PostMapping("upload")
	  public ResponseEntity<?> uploadFile1( @RequestParam("file") MultipartFile file) {
		  
		  
	    String message = "";
	    try {
	      FileDB files=storageService.store(file);
          System.out.println("file Uploaded : "+files);
	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }
	
	  @GetMapping("files")
	  public ResponseEntity<List<ResponseFile>> getListFiles() {
	    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
	      String fileDownloadUri = ServletUriComponentsBuilder
	          .fromCurrentContextPath()
	          .path("/File/files/")
	          //.path(dbFile.getId())
	          .toUriString();

	      return new ResponseFile(
	          dbFile.getName(),
	          fileDownloadUri,
	          dbFile.getType(),
	          dbFile.getData().length);
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }
	  
	
	  @Transactional
	@GetMapping("filesbyAdmin/{idAdmin}")
	  public ResponseEntity<List<ResponseFile>> getListFilesByIdAdmin(@PathVariable(value = "idAdmin")long idAdmin) {
		Admin ad1=adminRepository.findByidAdmin(idAdmin);
		
	    List<ResponseFile> files =  fileRepository.findByAdmin(ad1).map(dbFile -> {
		      String fileDownloadUri = ServletUriComponentsBuilder
			          .fromCurrentContextPath()
			          .path("/File/filesbyAdmin/")
			          .path(ad1.getIdAdmin().toString())
			          .toUriString();
		    
	      return new ResponseFile(
	          dbFile.getName(),
	          fileDownloadUri,
	          dbFile.getType(),
	          dbFile.getData().length);
	    }).collect(Collectors.toList());
	   for(ResponseFile i:files) {
		   System.out.println("test"+i);
		   
	   }
	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }
	 
	
	  
	 @GetMapping("files/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable long id) {
	    FileDB fileDB = storageService.getFile(id);

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
	        .body(fileDB.getData());
	  }
	  
	  
	  
	  
	  

}