package com.csi.dao;

import com.csi.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {

    public Product saveData(Product product);

    public List<Product> getAllData();

    public Product updateData( Product product);

    public  void deleteDataById(int productId);

    public Optional<Product> getDataById(int productId);
}
