package com.producto.controller;

import com.producto.model.Producto;
import com.producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@GetMapping
	public String listarProductos(Model model) {
		List<Producto> productos = productoService.findAll();
		model.addAttribute("productos", productos);
		return "productos/list";
	}

	@GetMapping("/nuevo")
	public String mostrarFormularioDeRegistro(Model model) {
		model.addAttribute("producto", new Producto());
		return "productos/form";
	}

	@PostMapping
	public String registrarProducto(@ModelAttribute Producto producto) {
		productoService.save(producto);
		return "redirect:/productos";
	}

	@GetMapping("/editar/{id}")
	public String mostrarFormularioDeEdicion(@PathVariable Long id, Model model) {
		Producto producto = productoService.findById(id).orElse(null);
		model.addAttribute("producto", producto);
		return "productos/form";
	}

	@PostMapping("/{id}")
	public String actualizarProducto(@PathVariable Long id, @ModelAttribute Producto producto) {
		producto.setIdProducto(id);
		productoService.save(producto);
		return "redirect:/productos";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable Long id) {
		productoService.deleteById(id);
		return "redirect:/productos";
	}
}