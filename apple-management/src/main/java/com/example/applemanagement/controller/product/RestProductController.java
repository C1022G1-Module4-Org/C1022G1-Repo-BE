package com.example.applemanagement.controller.product;

import com.example.applemanagement.dto.productDTO.ProductDTO;
import com.example.applemanagement.model.product.MadeIn;
import com.example.applemanagement.model.product.Product;
import com.example.applemanagement.service.product.IMadeInService;
import com.example.applemanagement.service.product.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/apple/product")
@CrossOrigin("*")
public class RestProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private IMadeInService madeInService;

    @GetMapping("")
    public Page<Product> findAllProduct(@PageableDefault(size = 3,sort = "id", direction = Sort.Direction.DESC)Pageable pageable,
                                        @RequestParam(required = false, defaultValue = "") String search){
        Page<Product> products = productService.listAllProduct(search,pageable);
        List<Product> products1 = products.toList();
        return new PageImpl<>(products1, pageable, products.getTotalElements());
    }

    @GetMapping("/madein")
    public List<MadeIn> findAllMadeIn(){
        return madeInService.findAllMadeIn();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createNewProduct(@Validated @RequestBody ProductDTO productDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
                return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
            }
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDTO,product);
        productService.createNewProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteProduct(@PathVariable int id){
        Product product = productService.findProductById(id);
        productService.deleteProduct(product);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Product updateProduct(@PathVariable int id, @RequestBody ProductDTO productDTO){
        Product product = new Product();
        BeanUtils.copyProperties(productDTO,product);
        return productService.updateProduct(id,product);
    }
}
