package com.wecare.demochatgpt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class DemoChatgptApplication

fun main(args: Array<String>) {
    runApplication<DemoChatgptApplication>(*args)
}