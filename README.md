# LangChat4jLearn

基于 [LangChain4j](https://docs.langchain4j.dev/get-started) 的入门学习项目。

## 环境要求

- JDK 17+（LangChain4j 最低要求）
- Maven 3.8+

## 项目结构

```
src/main/java/com/example/langchat4j/
├── _01_BasicChatModel.java   # 入门示例一：低层 ChatModel API（最简对话）
└── _02_AiServices.java       # 入门示例二：高级 AI Services API（声明式接口）
```

## 使用步骤

1. 设置 API Key 环境变量（不要提交到仓库）：

```bash
# Windows PowerShell
$env:OPENAI_API_KEY = "sk-..."

# Linux / macOS
export OPENAI_API_KEY=sk-...
```

2. 运行示例：

```bash
mvn compile exec:java -Dexec.mainClass=com.example.langchat4j._01_BasicChatModel
mvn compile exec:java -Dexec.mainClass=com.example.langchat4j._02_AiServices
```

## 依赖说明

- `dev.langchain4j:langchain4j` — 核心模块（AI Services 高级 API）
- `dev.langchain4j:langchain4j-open-ai` — OpenAI 接入（支持任意 OpenAI 兼容服务，可通过 `baseUrl()` 切换）
- 版本由 `langchain4j-bom`（当前 1.24.0）统一管理

## 参考

- 官方入门文档：https://docs.langchain4j.dev/get-started
- AI Services 教程：https://docs.langchain4j.dev/tutorials/ai-services

## 许可

仅用于个人学习。欢迎 Fork / Star，如需引用代码请注明出处。
