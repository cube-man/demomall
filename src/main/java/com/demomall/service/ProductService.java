package com.demomall.service;

import com.demomall.service.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品目录业务：内存预置数据（最简载体，无存储，见 03-架构说明.md 技术风险表）。
 */
@Service
public class ProductService {

    private final Map<Long, Product> products = new LinkedHashMap<>();

    public ProductService() {
        put(new Product(1L, "机械键盘", "87 键红轴，PBT 键帽"));
        put(new Product(2L, "无线鼠标", "2.4G + 蓝牙双模，静音微动"));
        put(new Product(3L, "显示器支架", "铝材气弹簧，支持 17-32 英寸"));
    }

    public List<Product> list() {
        return Collections.unmodifiableList(new ArrayList<>(products.values()));
    }

    public Product get(Long id) {
        return products.get(id);
    }

    private void put(Product product) {
        products.put(product.getId(), product);
    }
}
