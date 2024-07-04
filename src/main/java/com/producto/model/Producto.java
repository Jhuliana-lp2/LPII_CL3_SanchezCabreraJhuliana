package com.producto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;

	private String Nombre;
	private double Precio;
	private double PrecioVenta;
	private int Stock;
	private String Estado;
	private String Descripcion;

	public void setIdProducto(Long id) {

	}

}