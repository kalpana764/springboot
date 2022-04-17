package com.ss.org.cartService.controller;

import com.ss.org.cartService.entity.Product;
import com.ss.org.cartService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user/{id}/product")
@Log4j2
public class ProductController {

    ProductRepository productRepository;

    public ProductController( ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @PostMapping()
    public ResponseEntity<String> saveProduct(@RequestBody Product product){
        log.info("saveProduct :: start");
        Optional.ofNullable(product)
                .orElseThrow(IllegalArgumentException::new);
        try{
            log.info("Saving product : {}", product);
            productRepository.save(product);
           return new ResponseEntity<>("Product saved", HttpStatus.OK);
        }
        catch(Exception e){
            log.error("Exception while saving product", e);
           return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable(name = "id") String id){
        log.info("getProduct :: start");
        try{
            log.info("get product for id: {}", id);
            Product product = productRepository.getById(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        catch(Exception e){
            log.error("Error while getting product with id",e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(name= "id") String id){
        log.info("deleteProduct :: start");
        try{
            productRepository.deleteById(id);
            return new ResponseEntity<>("Product deleted", HttpStatus.BAD_REQUEST);
        }
        catch(Exception e){
            log.error("Error while deleting product with id: {}",id , e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
