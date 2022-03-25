package com.csi.service;

import com.csi.dao.ProductDao;
import com.csi.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDaoImpl;

    @Override
    public Product saveData(Product product) {
        return productDaoImpl.saveData(product);
    }

    @Override
    public List<Product> getAllData() {
        return productDaoImpl.getAllData();
    }

    @Override
    public Product updateData(Product product) {
        return productDaoImpl.updateData(product);
    }

    @Override
    public void deleteDataById(int productId) {
        productDaoImpl.deleteDataById(productId);
    }
    @Cacheable(value = "productId")
    @Override

    public Optional<Product> getDataById(int productId) {
        log.info("****Fetch Data From Database****");
        return productDaoImpl.getDataById(productId);
    }
}