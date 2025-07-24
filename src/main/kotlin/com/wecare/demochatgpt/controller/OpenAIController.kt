package com.wecare.demochatgpt.controller


import com.wecare.demochatgpt.OpenAIClient
import org.springframework.ai.chat.client.ChatClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/test")
class OpenAIController(

    @Autowired
    private val openAIClient: OpenAIClient,

    @Autowired
    private val myClient: ChatClient,

    @Value("\${ai.api.key}")
    private val apiKey: String
) {
    @GetMapping("/feign-client")
    fun callByFeignClient(@RequestParam question: String): ResponseEntity<String>{
        return ResponseEntity.ok(
            openAIClient.callApi(
                "Bearer $apiKey",
                mapOf(
                    "model" to "gpt-4o-mini",
                    "messages" to arrayOf(
                        mapOf(
                            "role" to "system",
                            "content" to "과격한 10년차 시니어 개발자",
                        ),
                        mapOf(
                            "role" to "user",
                            "content" to question
                        )
                    )
                )
            )
        )
    }

    @GetMapping("/lib")
    fun callByLib(@RequestParam question: String): ResponseEntity<String>{
        return ResponseEntity.ok(
            myClient.prompt()
                .user(question)
                .call()
                .content()
        )
    }
}