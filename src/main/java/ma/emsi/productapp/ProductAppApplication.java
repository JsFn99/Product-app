package ma.emsi.productapp;

import ma.emsi.productapp.entities.Product;
import ma.emsi.productapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductAppApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProductAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null, "Computer", 7888, 12));
        productRepository.save(new Product(null, "Printer", 788, 122));
        productRepository.save(new Product(null, "Smartphone", 7888, 12));
        List<Product> products = productRepository.findAll();
        products.forEach(p -> {
            System.out.println(p.toString());
        });
        Product p = productRepository.findById(1L).get();
        System.out.println(p.toString());

    }
}
