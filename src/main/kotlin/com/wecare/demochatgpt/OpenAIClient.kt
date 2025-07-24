package com.wecare.demochatgpt

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(name = "openAI", url = "https://api.openai.com/v1")
interface OpenAIClient {

    @PostMapping("/chat/completions")
    fun callApi(
        @RequestHeader("Authorization") authorization: String,
        @RequestBody body: Map<String, Any>
    ): String
}