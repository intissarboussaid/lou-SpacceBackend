package com.lib.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lib.models.Admin;
import com.lib.models.Clothes;
import com.lib.repository.AdminRepository;
import com.lib.repository.ClothesRepository;

@RestController
@RequestMapping("/clothes/")
public class ClothesControlleur {
	
	
	@Autowired
	ClothesRepository clothesRepository;
	@Autowired
	AdminRepository adminRepository;
	
	
	@PostMapping("Add/{idAdmin}")
	public Clothes AddClothes(@Valid @PathVariable("idAdmin")long idAdmin, @RequestBody Clothes clothesRequest) {
		Admin admin = adminRepository.findById(idAdmin);
		clothesRequest.setAdmin(admin);
		return clothesRepository.save(clothesRequest);
	}

	  @PutMapping("update/{IdClothes}")
	  //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	 // @PreAuthorize("hasRole('ADMIN')")
	    public Clothes GereProfil(@PathVariable(value = "IdClothes")long IdClothes, @RequestBody Clothes clothesDetail) {
		  Clothes clothes = clothesRepository.findById(IdClothes);
		  clothes.setBrand(clothesDetail.getBrand());
		  clothes.setGendre(clothesDetail.getGendre());
		  clothes.setType(clothesDetail.getType());
		  clothes.setDescription(clothesDetail.getDescription());
		  clothes.setDetail(clothesDetail.getDetail());
		  clothes.setPhoto(clothesDetail.getPhoto());
		  clothes.setPrice(clothesDetail.getPrice());
		  clothes.setQuantite(clothesDetail.getQuantite());
		  clothes.setVideo(clothesDetail.getVideo());
		
	    	return clothesRepository.save(clothes);
	    	
	    }
	  
	  @GetMapping("AllClothes")
	  public List<Clothes> AfficherToutClothes(){
		  return clothesRepository.findAll();
	  }
	  
	  @GetMapping("Get/{IdClothes}")
	  public Clothes GetClothesById(@PathVariable(value = "IdClothes")long IdClothes){
		  return clothesRepository.findById(IdClothes);
	  }
	  
	  @DeleteMapping("delete/{IdClothes}")
	  public void DeleteClothes (@PathVariable(value = "IdClothes")long IdClothes) {
		  Clothes cloth = clothesRepository.findById(IdClothes);
		  clothesRepository.delete(cloth);
	  }
	
	  
	  
	  
}
