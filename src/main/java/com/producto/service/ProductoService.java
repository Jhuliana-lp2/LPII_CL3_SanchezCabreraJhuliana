package com.producto.service;

import com.producto.model.Producto;
import com.producto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	public List<Producto> findAll() {
		return productoRepository.findAll();
	}

	public Optional<Producto> findById(Long id) {
		return productoRepository.findById(id);
	}

	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}

	public void deleteById(Long id) {
		productoRepository.deleteById(id);
	}
}