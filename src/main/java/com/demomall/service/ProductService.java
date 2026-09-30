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

    /**
     * 按名称搜索：关键字为空返回全部；匹配不区分大小写（对中文无影响）。
     * 注意：Java 8 没有 String.isBlank()，判空用 trim().isEmpty()。
     */
    public List<Product> searchByName(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return list();
        }
        String normalized = keyword.trim().toLowerCase();
        List<Product> matched = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getName().toLowerCase().contains(normalized)) {
                matched.add(product);
            }
        }
        return Collections.unmodifiableList(matched);
    }

    private void put(Product product) {
        products.put(product.getId(), product);
    }
}
