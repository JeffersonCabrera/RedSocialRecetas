package com.grupo04.caseritaPeru.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grupo04.caseritaPeru.entity.TM_UsuariosSC;
import com.grupo04.caseritaPeru.repository.TM_UsuariosSCRepository;
import com.grupo04.caseritaPeru.service.TM_UsuarioSCService;

@Service("tm_UsuarioSCServiceImpl")
public class TM_UsuarioSCServiceImpl implements TM_UsuarioSCService {

	
	@Autowired
	@Qualifier("tm_UsuariosSCRepository")
	private TM_UsuariosSCRepository tm_UsuariosSCRepository;
	
	@Override
	public TM_UsuariosSC save(TM_UsuariosSC tm_usuariO) {
		// TODO Auto-generated method stub
		return tm_UsuariosSCRepository.save(tm_usuariO);
	}

}
