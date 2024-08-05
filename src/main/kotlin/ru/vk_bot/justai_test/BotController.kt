package ru.vk_bot.justai_test

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import kotlin.random.Random

@RestController
class BotController {

    private val logger = LoggerFactory.getLogger(javaClass)
    private val webClient: WebClient = WebClient.builder()
        .baseUrl("https://api.vk.com/method")
        .build()

    @PostMapping("/callback")
    fun callback(@RequestBody request: Callback): String {
        if(request.type == "confirmation")
            return KEY
        else if(request.type == "message_new") {
            if(request.secret != null && request.secret == "secret" && request.message != null) {
                logger.info(request.message.body)
                val data = SendMessage(
                    message = "Вы сказали: ${request.message.body}",
                    userId = request.message.userId,
                    token = TOKEN,
                    randomId = Random.nextInt(10000)
                )

                webClient
                    .post()
                    .uri("messages.send?")
                    .bodyValue(data)
                    .retrieve()
            }
        }
        return "ok"
    }
}