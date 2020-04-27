package com.grupo04.caseritaPeru.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo04.caseritaPeru.entity.TM_UsuariosSC;

@Repository("tm_UsuariosSCRepository")
public interface TM_UsuariosSCRepository extends JpaRepository<TM_UsuariosSC, Serializable> {

	public abstract TM_UsuariosSC findByUsuario(String usuario);
}
