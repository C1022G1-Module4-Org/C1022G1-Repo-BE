package com.example.applemanagement.controller.product;

import com.example.applemanagement.model.product.Product;
import com.example.applemanagement.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apple/product")
@CrossOrigin("*")
public class RestProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public Page<Product> findAllProduct(@PageableDefault(size = 4,sort = "id", direction = Sort.Direction.DESC)Pageable pageable,
                                        @RequestParam(required = false, defaultValue = "") String search){
        Page<Product> products = productService.listAllProduct(search,pageable);
        List<Product> products1 = products.toList();
        return new PageImpl<>(products1, pageable, products.getTotalElements());
    }
}
