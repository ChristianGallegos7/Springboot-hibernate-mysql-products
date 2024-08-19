package com.bases.project.controllers;

import com.bases.project.entities.Producto;
import com.bases.project.repositories.ProductoRepository;
import com.bases.project.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAllProducts() {
        return this.productoService.findAll();
    }

    @GetMapping("/{id}")
    public Producto getProductById(@PathVariable Long id) {
        return this.productoService.findById(id);
    }

    @PostMapping
    public Producto createProduct(@RequestBody Producto producto) {
        return this.productoService.create(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProduct(@PathVariable Long id, @RequestBody Producto productoDetail) {
        return this.productoService.update(id, productoDetail);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return this.productoService.delete(id);
    }

}
