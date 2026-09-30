/**
 * 基础设施层：配置类与未来的外部访问实现（数据存储、远程调用等）。
 * 当前为空：最简载体暂无外部依赖，数据由 ProductService 内存预置。
 * 依赖规则：只允许 service → infra，禁止反向（见 docs/启动链/03-架构说明.md）。
 */
package com.demomall.infra;
