package com.picom.controller.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.security.RolesAllowed;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.picom.business.Client;
import com.picom.dto.ClientDto;
import com.picom.exception.UtilisateurExistantException;
import com.picom.service.ClientService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class ClientRestController {

	private final ClientService clientService;

	@GetMapping("clients/{id}")
	public Client ClientGet(@PathVariable Long id) {
		return clientService.recupererUtilisateur(id);
	}

	// Méthode pour ajouter un client
	@GetMapping("clients/{email}/{motDePasse}")
	public ResponseEntity<Client> clientGetByEmailAndMotDePasse(@PathVariable String email,
			@PathVariable String motDePasse) throws URISyntaxException {
		Client u = clientService.recupererClient(email, motDePasse);

		if (u.getId() == null) {
			return ResponseEntity.badRequest().body(null);
		}

		return ResponseEntity.created(new URI("/api/clients/" + email + "/" + motDePasse)).body(u);
	}

	@PostMapping("addClient")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ClientDto ajouterClient(@Valid @RequestBody ClientDto clientDto, BindingResult result) {

		Client client = new Client();
		client.setNom(clientDto.getNom());
		client.setPrenom(clientDto.getPrenom());
		client.setEmail(clientDto.getEmail());
		client.setMotDePasse(clientDto.getMotDePasse());
		client.setNumeroDeTelephone(clientDto.getNumeroDeTelephone());
		clientService.enregistrerClient(clientDto);
		return clientDto;
	}

	@ExceptionHandler(UtilisateurExistantException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public String traiterUtilisateurDejaExistant(Exception exception) {
		return exception.getMessage();
	}

	@ExceptionHandler(javax.validation.ConstraintViolationException.class)
	@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
	public List<String> traiterDonneesInvalidesAvecDetails(ConstraintViolationException exception) {
		return exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
				.collect(Collectors.toList());
	}

}
