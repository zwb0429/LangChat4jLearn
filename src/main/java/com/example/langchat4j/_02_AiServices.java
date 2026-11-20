package com.example.langchat4j;

import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.UserMessage;

/**
 * 入门示例二：高级 AI Services API（声明式接口，类似 Spring Data JPA 的风格）
 * <p>
 * 参考：https://docs.langchain4j.dev/tutorials/ai-services
 */
public class _02_AiServices {

    // 1. 定义一个接口，用注解描述 Prompt 模板
    interface Assistant {

        String chat(String userMessage);

        @UserMessage("把下面这句话翻译成英文：{{it}}")
        String translateToEnglish(String it);
    }

    public static void main(String[] args) {
        String apiKey = System.getenv("OPENAI_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            System.err.println("请先设置环境变量 OPENAI_API_KEY");
            return;
        }

        // 2. 基于底层模型，动态生成接口的实现
        Assistant assistant = AiServices.create(
                Assistant.class,
                OpenAiChatModel.builder()
                        .apiKey(apiKey)
                        .modelName("gpt-4o-mini")
                        .build()
        );

        // 3. 像调用普通 Java 方法一样与 LLM 对话
        System.out.println(assistant.chat("你好，请介绍一下你自己"));
        System.out.println(assistant.translateToEnglish("大模型正在改变世界"));
    }
}
