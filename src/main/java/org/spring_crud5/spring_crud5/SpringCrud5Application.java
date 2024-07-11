package org.spring_crud5.spring_crud5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.spring_crud5.spring_crud5.pojo.Customer;
import org.spring_crud5.spring_crud5.pojo.Ordine;
import org.spring_crud5.spring_crud5.pojo.Product;
import org.spring_crud5.spring_crud5.serv.CustomerService;
import org.spring_crud5.spring_crud5.serv.OrdineService;
import org.spring_crud5.spring_crud5.serv.ProductService;

import java.util.List;

@SpringBootApplication
public class SpringCrud5Application implements CommandLineRunner {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrdineService ordineService;

    @Autowired
    private ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(SpringCrud5Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Customer customer1 = new Customer("John", "Doe", "john.doe@example.com", "+1234567890");
        Customer customer2 = new Customer("Jane", "Smith", "jane.smith@example.com", "+9876543210");

        customerService.saveCustomer(customer1);
		customerService.saveCustomer(customer2);


        Product product1 = new Product("Laptop", 1000, 20);
        Product product2 = new Product("Mouse", 20, 20);
        Product product3 = new Product("Keyboard", 50, 20);

        productService.saveProduct(product1);
		productService.saveProduct(product2);
        productService.saveProduct(product3);

        Ordine ordine1 = new Ordine(customer1, List.of(product1));
        Ordine ordine2 = new Ordine(customer2,List.of(product2, product3));

        ordineService.saveOrdine(ordine1);
	ordineService.saveOrdine(ordine2);
    }
}
