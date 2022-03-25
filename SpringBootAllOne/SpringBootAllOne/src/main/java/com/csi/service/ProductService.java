package com.csi.service;

import com.csi.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public Product saveData(Product product);

    public List<Product> getAllData();

    public Product updateData(Product product);

    public  void deleteDataById(int productId);

    public Optional<Product> getDataById(int productId);
}
