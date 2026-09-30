package com.demomall.api.dto;

/**
 * 商品响应 DTO：api 层对外模型，与 service 内部模型解耦（跨层传值规则见 03-架构说明.md）。
 */
public class ProductResponse {

    private final Long id;
    private final String name;
    private final String description;

    public ProductResponse(Long id, String name, String description) {
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
