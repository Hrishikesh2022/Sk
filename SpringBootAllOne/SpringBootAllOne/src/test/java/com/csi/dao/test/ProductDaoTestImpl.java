package com.csi.dao.test;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.csi.dao.ProductDao;
import com.csi.model.Product;
import com.csi.repo.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductDaoTestImpl {

    @Autowired
    ProductDao productDaoImpl;

    @MockBean
    ProductRepository productRepositoryImpl;

    @Test
    public void saveDataTest() {
        Product product = new Product(121, "Ram", "Pune", 9876644);
        productDaoImpl.saveData(product);
        verify(productRepositoryImpl, times(1)).save(product);
    }
    @Test
    public void getAllDataTest()
    {
        when(productRepositoryImpl.findAll()).thenReturn(Stream.of(new Product(123,"Mahesh","Pune",7419638)
                , new Product(124,"Shyam","Pune",999638)).collect(Collectors.toList()));

        Assert.assertEquals(2,productDaoImpl.getAllData().size());

    }
    @Test
    public void updateDataTest()
    {
        Product product = new Product(121, "Ram", "Pune", 9876644);
        productDaoImpl.updateData(product);
        verify(productRepositoryImpl, times(1)).save(product);

    }
    @Test
    public void deleteDataTest()
    {
        Product product = new Product(121, "Ram", "Pune", 9876644);
       // productDaoImpl.deleteByData(product.getProductId());
        verify(productRepositoryImpl, times(1)).deleteById(product.getProductId());

    }

}
