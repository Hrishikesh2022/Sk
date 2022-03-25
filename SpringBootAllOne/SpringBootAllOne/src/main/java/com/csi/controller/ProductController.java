package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Product;
import com.csi.repo.ProductRepository;
import com.csi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService productServiceImpl;

    @Autowired
    ProductRepository productRepositoryImpl;


    @PostMapping("/savedata")
    public Product saveData(@RequestBody Product product)
    {
        return productServiceImpl.saveData(product);
    }

    @GetMapping("/getalldata")
    public List<Product> getAllData()
    {
        return  productServiceImpl.getAllData();
    }


    @PutMapping("/updatedata/{productId}")
    public Product updateData(@PathVariable int productId, @RequestBody Product product) throws RecordNotFoundException {
        Product product1= productRepositoryImpl.findById(productId).orElseThrow(()-> new RecordNotFoundException("**Product Record Not Found**"));
      product1.setProductName(product.getProductName());
      product1.setProductAddress(product.getProductAddress());
      product1.setProductCode(product.getProductCode());

        return   productServiceImpl.updateData(product1);



    }

    @DeleteMapping("/deletedatabyid/{productId}")
    public String deleteDataById(@PathVariable int productId)
    {
        productServiceImpl.deleteDataById(productId);
        return "Delete Data Sucessfully";
    }

    @GetMapping("/getdatabyid/{productId}")
    public Optional <Product> getDataById(@PathVariable int productId)
    {
        return productServiceImpl.getDataById(productId);
    }

}
