package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Contact;
import com.model.Contact.Status;
import com.repository.ContactRepository;

@RestController
public class ContactController {

	@Autowired
	ContactRepository repo;

	@GetMapping("/contacts")
	public List<Contact> getAllContacts() {
		return repo.findAll();
	}

	@PostMapping("/contacts")
	public void AddContact(@RequestBody Contact contact) {
		repo.save(contact);
	}

	@PutMapping("/contacts")
	public void EditContact(@RequestBody Contact contact) {
		if (repo.findById(contact.getFirstName()).isPresent()) {
			repo.save(contact);
		}
	}

	@DeleteMapping("/contacts/{name}")
	public void deleteContact(@PathVariable("name") String name) {
		repo.deleteById(name);

	}

	@PutMapping("/contacts/{name}/{status}")
	public void inActivateContact(@PathVariable("name") String name, @PathVariable("status") Status status) {
		System.out.println("value being modified is =" + name + status);
		Optional<Contact> contact = repo.findById(name);
		if (contact.isPresent()) {
			contact.get().setStatus(status);
			repo.save(contact.get());
		}

	}

}
