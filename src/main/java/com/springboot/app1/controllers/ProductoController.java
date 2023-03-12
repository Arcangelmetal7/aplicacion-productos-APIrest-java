package com.springboot.app1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.app1.domains.Producto;
import com.springboot.app1.services.ProductoService;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@RequestMapping("/productos")
	public String productos(Model model) {
		List<Producto> productos = productoService.buscarTodos();
		model.addAttribute("productos", productos);
		return "productos";
	}

	@RequestMapping("/insertarProducto/{id}")
	public String insertarProducto(Model model, @PathVariable("id") Long id) {
		if (id == 0) {

			model.addAttribute("producto", new Producto());
		} else {
			model.addAttribute("producto", productoService.buscarPorId(id));
		}
		return "insertarProducto";
	}

	@RequestMapping("/guardarProducto")
	public String guardarProducto(Model model, Producto producto) {

		Producto miProducto = productoService.insertarProducto(producto);
		model.addAttribute("producto", miProducto);
		return "productoRegistrado";
	}

	@RequestMapping("/eliminarProducto/{id}")
	public String BorrarProducto(Model model, @PathVariable("id") Long id) {

                Producto miProducto=productoService.buscarPorId(id);
                if(miProducto==null){
                return "paginaDeError";
                }else{
            
		productoService.borrarPorId(id);
		List<Producto> productos = productoService.buscarTodos();
		model.addAttribute("productos", productos);

		return "productos";}
	}
        
        
        @RequestMapping("/buscarPorNombre")
	public String buscarPorNombre(Model model) {
		model.addAttribute("producto", new Producto());
		return "buscarPorNombre";
	}


	@RequestMapping("/encontrarPorIdProducto/{id}")
	public String encontrarPorIdProducto(Model model, @PathVariable("id") Long id) {

		Producto producto = productoService.buscarPorId(id);

		model.addAttribute("producto", producto);

		return "productoPorId";
	}

      
        
	@RequestMapping("/encontrarPorNombreProducto/{nombre}")
	public String buscarPorNombreProducto(Model model, Producto producto) {

		List<Producto> productos = productoService.buscarPorNombreParte(producto.getNombre());

                if(productos==null){
                    return "paginaDeError";
                }else{
		model.addAttribute("productos", productos);

		return "productoEncontrado";}
	}

}
