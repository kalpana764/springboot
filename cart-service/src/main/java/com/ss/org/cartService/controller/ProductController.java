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

    @GetMapping("/{product_id}")
    public ResponseEntity<?> getProduct(@PathVariable(name = "product_id") String productId){
        log.info("getProduct :: start");
        try{
            log.info("get product for id: {}", productId);
            Product product = productRepository.getById(productId);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        catch(Exception e){
            log.error("Error while getting product",e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{product_id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(name= "product_id") String productId){
        log.info("deleteProduct :: start");
        try{
            productRepository.deleteById(productId);
            return new ResponseEntity<>("Product deleted", HttpStatus.BAD_REQUEST);
        }
        catch(Exception e){
            log.error("Error while deleting product " , e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
