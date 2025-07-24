package com.wecare.demochatgpt.config

import org.springframework.ai.chat.client.ChatClient
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class OpenAIConfig {
    @Bean
    fun chatClient(builder: ChatClient.Builder): ChatClient {
        return builder
            .defaultSystem("You are a friendly chat bot that answers question in the text")
            .build()
    }
}