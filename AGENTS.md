# AGENTS.md — demomall 项目

标准开发流程的验证载体：Java 8 + Spring Boot 2.7.18 + Maven 单模块。

## 流程（必读）

- 流程总纲：`docs/标准开发流程.md` —— **任何改动前先读**；开发迭代走其 §2 循环，每阶段停下等确认。
- 架构与依赖规则：`docs/启动链/03-架构说明.md`；环境说明：`docs/启动链/04-环境清单.md`。

## 硬性规则

1. 依赖方向 `api → service → infra`，禁止反向；api 层不写业务逻辑；跨层各用各的 DTO。
2. 源码统一 UTF-8（pom 已配置，勿动——本机 Maven 平台编码是 GBK）。
3. 构建命令：`mvn clean package`（系统默认即 JDK 8，无需切换）；沙箱内仓库不通时追加 `-s G:\aiproject\maven-settings.xml`。
4. 交付前过《标准开发流程》§5.1 自检清单；测试全绿才算完成。
5. 文档同步：接口/数据结构变化时，同一次改动内更新 README 与架构文档。
6. Windows 下结束后台 java 进程用 `taskkill /PID <pid> /F`（git bash 的 kill 不可靠）；运行验证后确认端口释放，再继续构建。
