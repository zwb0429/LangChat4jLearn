package com.example.langchat4j;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;

/**
 * 入门示例一：低层 ChatModel API
 * <p>
 * 参考：https://docs.langchain4j.dev/get-started
 * <p>
 * 运行前请设置环境变量 OPENAI_API_KEY（或任意 OpenAI 兼容服务的 Key + BaseUrl）。
 */
public class _01_BasicChatModel {

    public static void main(String[] args) {
        // 推荐：API Key 从环境变量读取，避免硬编码泄漏
        String apiKey = System.getenv("OPENAI_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            System.err.println("请先设置环境变量 OPENAI_API_KEY");
            return;
        }

        ChatModel model = OpenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gpt-4o-mini")
                .build();

        String answer = model.chat("Say 'Hello World'");
        System.out.println(answer); // Hello World
    }
}
