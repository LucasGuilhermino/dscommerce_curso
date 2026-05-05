package com.lgo.dscommerce.services;

import com.lgo.dscommerce.dto.ProductDTO;
import com.lgo.dscommerce.entities.Product;
import com.lgo.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true) //somente para leitura
    public ProductDTO findById(Long id){
        Optional<Product> result = productRepository.findById(id);
        Product product = result.get();
        ProductDTO dto = new ProductDTO(product);
        return dto;

        /*
        Resumido
        Product product = productRepository.findById(id).get();
        return new ProductDTO(product);
         */
    }
}
