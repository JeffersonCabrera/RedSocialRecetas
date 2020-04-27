package com.grupo04.caseritaPeru.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TU_UserRole", uniqueConstraints = @UniqueConstraint(columnNames = { "SROL", "NID" }))
public class TU_UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NUSROLID", nullable = false, updatable = true, insertable = true)
	private Integer id;

	@Column(name = "SROL", length = 50, nullable = false, updatable = true, insertable = true)
	private String rol;

	@ManyToOne(optional = false, cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "NID", referencedColumnName = "NID", nullable = false, updatable = true, insertable = true)
	private TM_UsuariosSC usuario;

	public TU_UserRole() {
	}

	public TU_UserRole(Integer id, String rol, TM_UsuariosSC usuario) {
		super();
		this.id = id;
		this.rol = rol;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public TM_UsuariosSC getUsuario() {
		return usuario;
	}

	public void setUsuario(TM_UsuariosSC usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "TU_UserRole [id=" + id + ", rol=" + rol + ", usuario=" + usuario + "]";
	}

}
