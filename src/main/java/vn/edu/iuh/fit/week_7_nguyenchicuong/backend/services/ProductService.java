package vn.edu.iuh.fit.week_7_nguyenchicuong.backend.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week_7_nguyenchicuong.backend.models.Product;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    List<Product> getAll();
    Optional<Product> findById(long id);
    Product save(Product product);
    Page<Product> findPage(int pageNo, int pageSize, String sortBy, String sortDerection);
}
