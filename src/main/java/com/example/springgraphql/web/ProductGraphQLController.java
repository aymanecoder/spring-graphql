package com.example.springgraphql.web;

import com.example.springgraphql.dto.ProductRequestDTO;
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
    public Product saveProduct(@Argument ProductRequestDTO product){
        Category category = categoryRepository.findById(product.categoryId()).orElse(null);
        Product productToSave = new Product();
        productToSave.setId(UUID.randomUUID().toString());
        productToSave.setName(product.name());
        productToSave.setPrice(product.price());
        productToSave.setQuantity(product.quantity());
        productToSave.setCategory(category);
        return productRepository.save(productToSave);
    }
    @MutationMapping
    public Product updateProduct(@Argument String id,@Argument ProductRequestDTO product){
        Category category = categoryRepository.findById(product.categoryId()).orElse(null);
        Product productToSave = new Product();
        productToSave.setId(id);
        productToSave.setName(product.name());
        productToSave.setPrice(product.price());
        productToSave.setQuantity(product.quantity());
        productToSave.setCategory(category);
        return productRepository.save(productToSave);
    }
    @MutationMapping
    public String deleteProduct(@Argument String id){
        productRepository.deleteById(id);
        return "Product deleted successfully";
    }
}
