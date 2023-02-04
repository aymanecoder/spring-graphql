package com.example.springgraphql;


import com.example.springgraphql.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringGraphQlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringGraphQlApplication.class, args);
    }


    //    @Bean
//    CommandLineRunner run(CategoryRepository categoryRepprository,
//                          ProductRepository productRepository){
//        return args -> {
//            Random random=new Random();
//            List.of("Computer","Printer","Smartphone").forEach(cat->{
//                Category category=Category.builder().name(cat).build();
//                categoryRepository.save(category);
//            });
//
//            categoryRepository.findAll().forEach(category->{
//
//                for (int i = 0; i < 10; i++) {
//                    Product product=Product.builder()
//                            .id(UUID.randomUUID().toString())
//                            .name("Computer "+i)
//                            .price(100+Math.random()*50000)
//                            .quantity(random.nextInt(100))
//                            .category(category)
//                            .build();
//                    productRepository.save(product);
//                }
//            });
//        };
//    }


}
