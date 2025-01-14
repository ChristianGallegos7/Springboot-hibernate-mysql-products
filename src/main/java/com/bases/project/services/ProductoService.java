package com.bases.project.services;

import com.bases.project.entities.Producto;
import com.bases.project.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll(){
        return this.productoRepository.findAll();
    }

    public Producto findById(Long id){
        return this.productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    public Producto create(Producto producto){
        return this.productoRepository.save(producto);
    }

    public Producto update(Long id, Producto productoDetail){
        Producto producto = this.productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        producto.setNombre(productoDetail.getNombre());
        producto.setPrecio(productoDetail.getPrecio());
        return this.productoRepository.save(producto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete(Long id){
        this.productoRepository.deleteById(id);
        return "Product deleted successfully!";
    }

}
