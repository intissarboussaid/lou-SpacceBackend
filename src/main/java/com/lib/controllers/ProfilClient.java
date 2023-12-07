package com.lib.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lib.models.Account;
import com.lib.models.Client;
import com.lib.repository.AccountRepository;
import com.lib.repository.ClientRepository;

@RestController
@RequestMapping("/profil/client/")
public class ProfilClient {
	
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	AccountRepository accountRepository;
	
	@GetMapping("GetAll")
	public List<Client> GettAllInformationClient() {
		return clientRepository.getAll();
		
	}
	@GetMapping("GetById/{id_client}")
	public Client GettClientById(@PathVariable("id_client") Long id_client) {
		
		Client client =clientRepository.getByID(id_client);
		//if(client!=null)
		return client;
	
	}
	
	@GetMapping("getEmailClient/{id_client}")
public String GetEmailClient(@Validated @PathVariable("id_client") long id_client) {
		
		Client client =clientRepository.getByID(id_client);
		System.out.println("client :" +client);
		Account account =client.getAccount();
		String EmailClientAccount = account.getEmail();
		return EmailClientAccount;
		
	}
	
	@PutMapping("updateProfilClient/{id_client}")
	public Client UpdateClient(@PathVariable(value = "id_client")long id_client, @Validated @RequestBody Client clientDetail) {
		Client client =clientRepository.getByID(id_client);
		client.setAdresse(clientDetail.getAdresse());
		client.setCodepostale(clientDetail.getCodepostale());
		client.setFirstName(clientDetail.getFirstName());
		client.setLastname(clientDetail.getLastname());
		client.setLocalisation(clientDetail.getLocalisation());
		client.setTel(clientDetail.getTel());
		clientRepository.save(client);
		return client;
	}
	
	@DeleteMapping("DeleteClient/{id_client}")
	public String DeleteProfilClient(@PathVariable(value = "id_client")long id_client) {
		Client client = clientRepository.getByID(id_client);
		Account account = client.getAccount();
		clientRepository.deleteById(id_client);
		long idAccount = account.getIdaccount();
		accountRepository.deleteById(idAccount);
		Account accountDeleted=accountRepository.findById1(idAccount);
		Client clientDeleted = clientRepository.getByID(id_client);
		if (accountDeleted==null && clientDeleted ==null) {
			return "we deleted ";
		}
		
		else return "error";
	}
	

}
