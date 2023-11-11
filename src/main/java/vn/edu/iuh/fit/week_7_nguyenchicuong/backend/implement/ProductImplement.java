package vn.edu.iuh.fit.week_7_nguyenchicuong.backend.implement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.week_7_nguyenchicuong.backend.models.Product;
import vn.edu.iuh.fit.week_7_nguyenchicuong.backend.repositories.ProductRepository;
import vn.edu.iuh.fit.week_7_nguyenchicuong.backend.services.ProductService;

import java.util.List;
import java.util.Optional;

@Component
public class ProductImplement implements ProductService {
    @Autowired
    private ProductRepository repository;
    @Override
    public List<Product> getAll() {

        return repository.findAll();
    }

    @Override
    public Optional<Product> findById(long id) {
        return repository.findById(id);
    }
    @Override
    public Page<Product> findPage(int pageNo, int pageSize, String sortBy, String sortDerection) {
        Sort sort= Sort.by(Sort.Direction.fromString(sortDerection),sortBy);
        Pageable pageable= PageRequest.of(pageNo,pageSize,sort);
        return repository.findAll(pageable);
    }
    @Override
    public Product save(Product product) {
        return repository.save(product);
    }
}
