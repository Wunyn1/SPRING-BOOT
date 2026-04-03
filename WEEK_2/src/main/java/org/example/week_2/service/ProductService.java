package org.example.week_2.service;

import org.example.week_2.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class ProductService {
    private List<Product> products = new CopyOnWriteArrayList<>();
    public Product getProductByName(String name){
        for(Product p : products){
            if(name.equals(p.getName())){
                return p;
            }
        }
        return null;
    }
    public Product getProductById(long id){
        for(Product p : products){
            if(id == p.getId()){
                return p;
            }
        }
        return null;
    }
    public Product createNewProduct(Product product){
        products.add(product);
        return product;
    }
    public Product deleteProduct(long id){
        Product del = getProductById(id);
        if(del != null){
            products.remove(del);
        }
        return del;
    }
}
