package com.springboot.app1.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app1.domains.Producto;
import com.springboot.app1.exception.ProductoNoEncontradoException;
import com.springboot.app1.services.ProductoService;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/producto/")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoRestController {

	@Autowired
	private ProductoService productoService;
        
        
        @GetMapping("/todos")
        public List<Producto> buscarTodos(){
            List<Producto> productos=productoService.buscarTodos();
            return productos;
            
        }

	@GetMapping("/{id}")
	public Producto buscarPorId(@PathVariable Long id) throws ProductoNoEncontradoException{
		Producto producto = productoService.buscarPorId(id);
                 if (producto == null) {
            throw new ProductoNoEncontradoException("Producto no encontrado");
        }

		return producto;
	}
}
