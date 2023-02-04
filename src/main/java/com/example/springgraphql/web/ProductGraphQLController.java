package com.example.springgraphql.web;

import com.example.springgraphql.entities.Category;
import com.example.springgraphql.entities.Product;
import com.example.springgraphql.repository.CategoryRepository;
import com.example.springgraphql.repository.ProductRepository;
import jakarta.persistence.ManyToMany;
import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
@RequiredArgsConstructor
public class ProductGraphQLController {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @QueryMapping
    public List<Product> productList(){
        return productRepository.findAll();
    }

    @QueryMapping
    public Product productById(@Argument String id) {
        return productRepository.findById(id).orElseThrow(
                ()->new RuntimeException(String.format("Product %s not found ",id))
        );
    }
    @QueryMapping
    public List<Category> categories(){
        return categoryRepository.findAll();

    }
    @QueryMapping
    public Category categoryById(@Argument Long id) {
        return categoryRepository.findById(id).orElseThrow(
                ()->new RuntimeException(String.format("Category %s not found",id))
        );
    }

    @MutationMapping
    public Product saveProduct(@Argument Product product){
        product.setId(UUID.randomUUID().toString());
        return productRepository.save(product);
    }
}
