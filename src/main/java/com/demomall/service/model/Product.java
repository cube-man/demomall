package com.demomall.service.model;

/**
 * 商品内部模型：仅限 service 层及以内使用，禁止直接暴露给 api 层（依赖规则见 docs/启动链/03-架构说明.md）。
 */
public class Product {

    private final Long id;
    private final String name;
    private final String description;

    public Product(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
