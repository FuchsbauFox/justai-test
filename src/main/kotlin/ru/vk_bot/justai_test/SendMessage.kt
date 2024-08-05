package ru.vk_bot.justai_test

import com.fasterxml.jackson.annotation.JsonProperty

data class SendMessage(
    val message: String,
    @JsonProperty("peer_id")
    val userId: Int,
    @JsonProperty("access_token")
    val token: String,
    @JsonProperty("random_id")
    val randomId: Int,
)