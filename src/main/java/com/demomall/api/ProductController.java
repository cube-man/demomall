package com.demomall.api;

import com.demomall.api.dto.ProductResponse;
import com.demomall.service.ProductService;
import com.demomall.service.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品目录接口：只做参数处理与 DTO 转换，不写业务逻辑（依赖规则见 03-架构说明.md）。
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponse> list() {
        return productService.list().stream()
                .map(ProductController::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/search")
    public List<ProductResponse> search(@RequestParam(required = false) String name) {
        return productService.searchByName(name).stream()
                .map(ProductController::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> get(@PathVariable Long id) {
        Product product = productService.get(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toResponse(product));
    }

    private static ProductResponse toResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName(), product.getDescription());
    }
}
