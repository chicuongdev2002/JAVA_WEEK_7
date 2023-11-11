package vn.edu.iuh.fit.week_7_nguyenchicuong.backend.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.iuh.fit.week_7_nguyenchicuong.backend.enums.ProductStatus;
import vn.edu.iuh.fit.week_7_nguyenchicuong.backend.models.Product;
import vn.edu.iuh.fit.week_7_nguyenchicuong.backend.services.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Qualifier("productImplement")
    @Autowired
    private ProductService service;
    private int PAGE;
    private int SIZE;
//    @GetMapping("/list")
//    private String formProduct(Model model){
//        model.addAttribute("products",service.getAll());
//        return "admin/product";
//    }
    @GetMapping("/page")
    public String getAllBySort(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size, RedirectAttributes redirectAttributes){
        int currentPage= page.orElse(1);
        int currentSize=size.orElse(10);
        Page<Product> p = service.findPage(currentPage - 1, currentSize, "name", "asc");
        model.addAttribute("pageProduct",p);
        int totalPage= p.getTotalPages();
        if(totalPage>0){
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
            PAGE=currentPage;
            SIZE=currentSize;
        }


        return "admin/product";
    }
    @GetMapping("/insert")
    public String insertForm(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("statuses", ProductStatus.values());
        return "/admin/insert_product";
    }
    @PostMapping("/insertNew")
    public String insert(@ModelAttribute("product") Product product){
        if(product!=null){
            service.save(product);
            return "redirect:/product/page";
        }
        return "redirect:/product/insert";
    }
    @PostMapping("/updateProduct")
    public String update(@ModelAttribute("product") Product product,long id){
        if(product!=null){
            service.findById(id);
            service.save(product);
            return "redirect:/product/page";
        }
        return "redirect:/product/insert";
    }

}
