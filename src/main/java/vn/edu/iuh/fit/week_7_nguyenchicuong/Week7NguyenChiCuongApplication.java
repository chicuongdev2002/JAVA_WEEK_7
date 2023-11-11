package vn.edu.iuh.fit.week_7_nguyenchicuong;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.week_7_nguyenchicuong.backend.enums.ProductStatus;
import vn.edu.iuh.fit.week_7_nguyenchicuong.backend.models.Product;
import vn.edu.iuh.fit.week_7_nguyenchicuong.backend.repositories.ProductRepository;

@SpringBootApplication
public class Week7NguyenChiCuongApplication {
    @Autowired
private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(Week7NguyenChiCuongApplication.class, args);
    }
//    @Bean
//    CommandLineRunner test(){
//        return args -> {
//            Faker fk=new Faker();
//            for (int i=0;i<100;i++){
//                Product p=new Product();
//                p.setName(String.valueOf(fk.name()));
//                p.setDescription(fk.lorem().sentence());
//                p.setManufacturer(fk.company().name());
//                p.setStatus(ProductStatus.ACTIVE);
//                p.setUnit(fk.commerce().material());
//                productRepository.save(p);
//            }
//        };
//    }

}
