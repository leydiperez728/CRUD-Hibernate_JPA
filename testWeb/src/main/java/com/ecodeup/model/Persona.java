/**
 * 
 */
package com.ecodeup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Leydi P
 *
 */
@Entity
@Table(name = "Persona", schema = "Doztgy")
public class Persona {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cedula")
	private Long cedula;

	@Column(name="nombre")
	private String nombre;

	@Column(name="apellido")
	private String apellido;

	@Column(name="direccion")
	private String direccion;

	@Column(name="celular")
	private Long celular;

	@Column(name="telefono")
	private Long telefono;

	public Long getCedula() {
		return cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Long getCelular() {
		return celular;
	}

	public void setCelular(Long celular) {
		this.celular = celular;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Persona [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion="
				+ direccion + ", celular=" + celular + ", telefono=" + telefono + "]";
	}

}
