package com.grupo04.caseritaPeru.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.grupo04.caseritaPeru.entity.TM_UsuariosSC;
import com.grupo04.caseritaPeru.entity.TU_UserRole;
import com.grupo04.caseritaPeru.repository.TM_UsuariosSCRepository;

@Service("tmUsuarioSCService")
public class TMUsuarioSCService implements UserDetailsService {

	@Autowired
	@Qualifier("tm_UsuariosSCRepository")
	private TM_UsuariosSCRepository tm_UsuariosSCRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TM_UsuariosSC user = tm_UsuariosSCRepository.findByUsuario(username);
		List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());
		return buildUser(user,authorities);
	}

	private User buildUser(TM_UsuariosSC user, List<GrantedAuthority> authorities) { 

		return new User(user.getUsuario(), user.getContraseña(), user.isEstado(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildAuthorities(Set<TU_UserRole> userRole) {
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();

		for (TU_UserRole tuUserRole : userRole) {
			auths.add(new SimpleGrantedAuthority(tuUserRole.getRol()));
		}

		return new ArrayList<GrantedAuthority>(auths);
	}
}
