package com.picom.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.picom.business.Administrateur;
import com.picom.business.Utilisateur;
import com.picom.dao.UtilisateurDao;
import com.picom.service.UtilisateurService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService, UserDetailsService {

	private UtilisateurDao utilisateurDao;
	private final PasswordEncoder passwordEncoder;

	@Override
	public Utilisateur recupererUtilisateur(String email, String motDePasse) {
		Utilisateur utilisateur = utilisateurDao.findByEmailAndMotDePasse(email, passwordEncoder.encode(motDePasse));
		return utilisateur;
	}

	// méthode de Spring security pour l'authentification
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (username.trim().isEmpty()) {
			throw new UsernameNotFoundException("username is empty");
		}

		Utilisateur utilisateur = utilisateurDao.findByEmail(username);
		if (utilisateur == null) {
			throw new UsernameNotFoundException("user " + username + " not found");
		}
		List<GrantedAuthority> grantedAuthorities = getGrantedAuthorities(utilisateur);
		User user = new User(utilisateur.getEmail(), utilisateur.getMotDePasse(), grantedAuthorities);
		return user;
	}

	// méthode d'ajout d'un role à un utilisateur
	private List<GrantedAuthority> getGrantedAuthorities(Utilisateur utilisateur) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		if (utilisateur instanceof Administrateur) {
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		} else {
			authorities.add(new SimpleGrantedAuthority("ROLE_CLIENT"));
		}

		return authorities;
	}

	@Override
	public Utilisateur recupererUtilisateur(String email) {
		return utilisateurDao.findByEmail(email);
	}

}
