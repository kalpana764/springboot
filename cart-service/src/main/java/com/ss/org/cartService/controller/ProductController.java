package com.ss.org.cartService.controller;

import com.ss.org.cartService.common.CustomException;
import com.ss.org.cartService.entity.Product;
import com.ss.org.cartService.entity.User;
import com.ss.org.cartService.repository.ProductRepository;
import com.ss.org.cartService.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping()
@Log4j2
public class ProductController {

    ProductRepository productRepository;
    UserRepository userRepository;

    public ProductController(ProductRepository productRepository,
                             UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/user/{userId}/product")
    public ResponseEntity<String> saveProduct(@PathVariable Long userId, @RequestBody Product product) {
        log.info("saveProduct :: start");
        Optional.ofNullable(product)
                .orElseThrow(IllegalArgumentException::new);
        log.info("Saving product : {}", product);
        User user = userRepository.getById(userId);
        productRepository.save(product);
        return new ResponseEntity<>("Product saved", HttpStatus.OK);

    }

    @GetMapping("product/{product_id}")
    public ResponseEntity<?> getProduct(@PathVariable(name = "product_id") Long productId) {
        log.info("getProduct :: start");
        log.info("get product for id: {}", productId);
        Optional.ofNullable(productRepository.getById(productId))
                .ifPresent((product) -> new ResponseEntity<>(product, HttpStatus.OK));
        throw new CustomException("No product found");
    }

    @DeleteMapping("product/{product_id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(name = "product_id") Long productId) {
        log.info("deleteProduct :: start");
        productRepository.deleteById(productId);
        return new ResponseEntity<>("Product deleted", HttpStatus.BAD_REQUEST);
    }

}
