package com.csi.dao;

import com.csi.model.Product;
import com.csi.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductDaoImpl implements  ProductDao {

    @Autowired
    ProductRepository productRepositoryImpl;
    @Override
    public Product saveData(Product product) {
        return productRepositoryImpl.save(product);
    }

    @Override
    public List<Product> getAllData() {
        return productRepositoryImpl.findAll();
    }

    @Override
    public Product updateData( Product product) {
        return productRepositoryImpl.save(product);
    }

    @Override
    public void deleteDataById(int productId) {
        productRepositoryImpl.deleteById(productId);
    }

    @Override
    public Optional<Product> getDataById(int productId) {
        return productRepositoryImpl.findById(productId);
    }


}
