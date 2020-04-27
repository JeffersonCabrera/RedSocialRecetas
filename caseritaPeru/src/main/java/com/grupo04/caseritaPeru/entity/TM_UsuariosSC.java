package com.grupo04.caseritaPeru.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TM_UsuariosSC")
public class TM_UsuariosSC {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NID", nullable = false, updatable = true, insertable = true)
	private Integer id;

	@Column(name = "DFECHAREGISTRO", columnDefinition = "DATETIME DEFAULT NOW()", nullable = false, updatable = true, insertable = true)
	private Date fecha_registro;

	@Column(name = "SUSUARIO", nullable = false, length = 50, updatable = true, insertable = true)
	private String usuario;

	@Column(name = "SCONTRASENA", nullable = false, length = 200, updatable = true, insertable = true)
	private String contraseña;

	@Column(name = "SUSUARIOFULL", nullable = false, length = 50, updatable = true, insertable = true)
	private String usuario_full;

	@Column(name = "SEMAIL", nullable = true, length = 50, updatable = true, insertable = true)
	private String email;

	@Column(name = "NERROR", nullable = true, updatable = true, insertable = true)
	private Integer nerror;

	@Column(name = "NESTADO", nullable = true, updatable = true, insertable = true)
	private boolean estado;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy ="usuario" )
	private Set<TU_UserRole> userRole = new HashSet<TU_UserRole>();

	public TM_UsuariosSC() {
	}

	public TM_UsuariosSC(String usuario, String contraseña, boolean estado) {
		super();
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.estado = estado;
	}

	public TM_UsuariosSC(String usuario, String contraseña, boolean estado, Set<TU_UserRole> userRole) {
		super();
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.estado = estado;
		this.userRole = userRole;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getUsuario_full() {
		return usuario_full;
	}

	public void setUsuario_full(String usuario_full) {
		this.usuario_full = usuario_full;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getNerror() {
		return nerror;
	}

	public void setNerror(Integer nerror) {
		this.nerror = nerror;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Set<TU_UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<TU_UserRole> userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "TM_UsuariosSC [id=" + id + ", fecha_registro=" + fecha_registro + ", usuario=" + usuario
				+ ", contraseña=" + contraseña + ", usuario_full=" + usuario_full + ", email=" + email + ", nerror="
				+ nerror + ", estado=" + estado + ", userRole=" + userRole + "]";
	}
	
	
	
 

	
	
}
