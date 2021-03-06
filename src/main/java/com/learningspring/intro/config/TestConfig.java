package com.learningspring.intro.config;

import com.learningspring.intro.model.entities.*;
import com.learningspring.intro.model.entities.enums.OrderStatus;
import com.learningspring.intro.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) {
        User U1 = new User(
                "Pedro Carvalho",
                "pedrocarvalho@gmail.com",
                "(21)98732-1234",
                "123456");

        User U2 = new User(
                "Maria Silva",
                "mariasilva@outlook.com",
                "(19)98765-4321",
                "654321");

        User U3 = new User(
                "João Camargo",
                "joaocamargo@gmail.com",
                "(24)98434-6543",
                "222444");

        User U4 = new User(
                "Fernanda Oliveira",
                "fernandaoliveira@yahoo.com.br",
                "(11)99882-1234",
                "909023");

        User U5 = new User(
                "Adriana de Jesus",
                "jesusadriana@gmail.com",
                "(11)99333-0099",
                "987634");

        Order O1 = new Order(
                Instant.parse("2022-06-20T19:53:07Z"),
                OrderStatus.PAID,
                U1);

        Order O2 = new Order(
                Instant.parse("2022-07-20T15:21:00Z"),
                OrderStatus.WAITING_PAYMENT,
                U2);

        Order O3 = new Order(
                Instant.parse("2022-08-20T12:00:00Z"),
                OrderStatus.WAITING_PAYMENT,
                U1);

        Order O4 = new Order(
                Instant.parse("2022-08-12T10:04:05Z"),
                OrderStatus.CANCELED,
                U3);

        Order O5 = new Order(
                Instant.parse("2022-08-12T20:13:15Z"),
                OrderStatus.SHIPPED,
                U5);

        Category C1 = new Category(
                "Eletronics");

        Category C2 = new Category(
                "Books");

        Category C3 = new Category(
                "Computers");

        Product P1 = new Product(
                "Smart TV",
                "Samsung TV 4K",
                2999.99,
                "https://images-americanas.b2w.io/produtos/01/00/img/3068549/7/3068549711_1SZ.jpg");

        Product P2 = new Product(
                "Mixer Grinder",
                "Bosch Mixer Grinder",
                199.99,
                "https://m.media-amazon.com/images/I/71Wq0mQNTLL._SL1500_.jpg");

        Product P3 = new Product(
                "Laptop",
                "HP Laptop",
                1599.99,
                "https://www.notebookcheck.info/uploads/tx_nbc2/HPPavilion13-b__1__03.jpg");

        Product P4 = new Product(
                "Lord of the Rings",
                "Written by J.R.R. Tolkien",
                19.99,
                "https://images-na.ssl-images-amazon.com/images/I/71jLBXtWJWL.jpg");

        Product P5 = new Product(
                "Harry Potter and the Philosopher's Stone",
                "Written by J.K. Rowling",
                29.99,
                "https://images-na.ssl-images-amazon.com/images/I/81ibfYk4qmL.jpg");

        P1.getCategories().add(C1);
        P2.getCategories().add(C1);
        P3.getCategories().add(C3);
        P4.getCategories().add(C2);
        P5.getCategories().add(C2);


        userRepository.saveAll(Arrays.asList(U1, U2, U3, U4, U5));
        orderRepository.saveAll(Arrays.asList(O1, O2, O3, O4, O5));
        categoryRepository.saveAll(Arrays.asList(C1, C2, C3));
        productRepository.saveAll(Arrays.asList(P1, P2, P3, P4, P5));

        OrderItem OI1 = new OrderItem(O1, P1, 2, P1.getPrice());
        OrderItem OI2 = new OrderItem(O1, P3, 1, P3.getPrice());
        OrderItem OI3 = new OrderItem(O2, P3, 2, P3.getPrice());
        OrderItem OI4 = new OrderItem(O3, P5, 1, P5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(OI1, OI2, OI3, OI4));

        Payment PM1 = new Payment(
                Instant.parse("2022-06-20T21:53:07Z"),
                O1);

        O1.setPayment(PM1);

        orderRepository.save(O1);

    }
}
