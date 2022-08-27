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
public class UtilisateurServiceImpl implements UtilisateurService ,UserDetailsService{
	
	private UtilisateurDao utilisateurDao;
	private final PasswordEncoder passwordEncoder;

	@Override
	public Utilisateur recupererUtilisateur(String email, String motDePasse) {
		return utilisateurDao.findByEmailAndMotDePasse(email, motDePasse);
	}
	

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		if (email.trim().isEmpty()) {
			throw new UsernameNotFoundException("username is empty");
		}

		Utilisateur utilisateur = utilisateurDao.findByEmail(email);
		if (utilisateur == null) {
			throw new UsernameNotFoundException("email " + email + " not found");
		}
		List<GrantedAuthority> grantedAuthorities = getGrantedAuthorities(utilisateur);
		User user = new User(utilisateur.getEmail(), utilisateur.getMotDePasse(), grantedAuthorities);
		System.out.println(user);
		return user;
	}
	
    private List<GrantedAuthority> getGrantedAuthorities(Utilisateur utilisateur) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        Set<Role> roles = utilisateur.getRoles();
//        for (Role role : roles) {
//        	authorities.add(new SimpleGrantedAuthority(role.getNom()));	
//		}
        if (utilisateur instanceof Administrateur) {
        	authorities.add(new SimpleGrantedAuthority("ADMIN"));
        }else {
        	authorities.add(new SimpleGrantedAuthority("CLIENT"));
        }
    	
        return authorities;
    }




}