# demomall

标准开发流程的验证载体：Java 8 + Spring Boot 2.7.18 + Maven 单模块。

- 流程总纲：[docs/标准开发流程.md](docs/标准开发流程.md) —— 开发前必读
- 启动记录：[docs/启动链/](docs/启动链/)（需求 / 选型 / 架构 / 环境 / 验收）

## 运行

前置依赖：JDK 8、Maven 3.x（详见 [docs/启动链/04-环境清单.md](docs/启动链/04-环境清单.md)）

```bash
mvn spring-boot:run
# 或打包后运行
mvn package && java -jar target/demomall-0.1.0-SNAPSHOT.jar
```

## 接口

| 方法 | 路径 | 说明 |
|---|---|---|
| GET | `/api/products` | 商品列表 |
| GET | `/api/products/{id}` | 商品详情（不存在返回 404） |

```bash
curl http://localhost:8080/api/products
curl http://localhost:8080/api/products/1
```

## 测试

```bash
mvn test
```

## 结构

单模块三层单体：`api → service → infra`，禁止反向依赖，详见 [docs/启动链/03-架构说明.md](docs/启动链/03-架构说明.md)。

## 开发约定

任何改动前先读 [AGENTS.md](AGENTS.md)，按流程总纲 §2 迭代循环执行。
