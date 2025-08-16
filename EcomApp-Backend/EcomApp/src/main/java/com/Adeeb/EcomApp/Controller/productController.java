package com.Adeeb.EcomApp.Controller;

import com.Adeeb.EcomApp.Model.Product;
import com.Adeeb.EcomApp.Service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class productController {
    @Autowired
    private productService service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> allProducts(){
        return new ResponseEntity<>(service.getAllProducts() , HttpStatus.OK);
    }

    @GetMapping("/product/{prodId}")
    public ResponseEntity<Product> getProdById(@PathVariable int prodId){
        Product prod = service.getProductById(prodId);
        if(prod != null){
            return new ResponseEntity<>(prod , HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product ,
                                        @RequestPart MultipartFile imageFile){
        try {
            Product product1 = service.addProduct(product, imageFile);
            return new ResponseEntity<>(product1 , HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
