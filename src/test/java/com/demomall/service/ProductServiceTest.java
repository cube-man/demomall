package com.demomall.service;

import com.demomall.service.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * 业务层单元测试：不起 Spring 容器，纯逻辑验证。
 */
class ProductServiceTest {

    private final ProductService productService = new ProductService();

    @Test
    void list_returnsSeededProducts() {
        List<Product> products = productService.list();
        assertEquals(3, products.size());
    }

    @Test
    void get_existingId_returnsProduct() {
        Product product = productService.get(1L);
        assertNotNull(product);
        assertEquals("机械键盘", product.getName());
    }

    @Test
    void get_unknownId_returnsNull() {
        assertNull(productService.get(999L));
    }
}
