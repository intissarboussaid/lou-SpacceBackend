package com.lib.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lib.models.Admin;
import com.lib.models.Decoration;
import com.lib.repository.AdminRepository;
import com.lib.repository.DecorationRepository;

@RestController
@RequestMapping("/Decoration/")
public class DecorationController {
	@Autowired
	DecorationRepository decorationRepository;
	@Autowired
	AdminRepository adminRepository;
	
	
	@PostMapping("Add/{idAdmin}")
	public Decoration AddClothes(@Valid @PathVariable("idAdmin")long idAdmin, @RequestBody Decoration decoRequest) {
		Admin admin = adminRepository.findById(idAdmin);
		decoRequest.setAdmin(admin);
		return decorationRepository.save(decoRequest);
	}

	  @PutMapping("Update/{idDeco}")
	    public Decoration GereProfil(@PathVariable(value = "idDeco")long idDeco, @RequestBody Decoration decoDetail) {
		  Decoration deco = decorationRepository.findDecoById(idDeco);
		  System.out.println(deco);
		  deco.setRest_Stocke(decoDetail.getRest_Stocke());
		  deco.setDescription(decoDetail.getDescription());
		  deco.setDetail(decoDetail.getDetail());
		  deco.setPhoto(decoDetail.getPhoto());
		  deco.setPrice(decoDetail.getPrice());
		  deco.setQuantite(decoDetail.getQuantite());
		  deco.setVideo(decoDetail.getVideo());
		  deco.setBrand(decoDetail.getBrand());
		  deco.setName(decoDetail.getName());
	    	return decorationRepository.save(deco);
	    }
	  
	  @GetMapping("AllDeco")
	  public List<Decoration> AfficherToutDecoration(){
		  return decorationRepository.findAll();
	  }
	  
	  @GetMapping("GetId/{idDeco}")
	  public Decoration GetDecorationById(@PathVariable(value = "idDeco")long idDeco){
		  return decorationRepository.findDecoById(idDeco);
	  }
	  
	  @GetMapping("GetName/{Name}")
	  public List<Decoration> GetDecorationName(@PathVariable(value = "Name")String Name){
		  return decorationRepository.findByName(Name);
	  }
	  
	  @DeleteMapping("delete/{idDeco}")
	  public void DeleteClothes (@PathVariable(value = "idDeco")long idDeco) {
		  Decoration deco = decorationRepository.findDecoById(idDeco);
		  decorationRepository.delete(deco);
	  }
	
	  
}
