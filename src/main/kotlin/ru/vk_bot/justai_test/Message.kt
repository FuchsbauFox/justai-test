package ru.vk_bot.justai_test

import com.fasterxml.jackson.annotation.JsonProperty

data class Message (
    val id: Int,
    val date: Int,
    val out: Int,
    @JsonProperty("user_id")
    val userId: Int,
    @JsonProperty("read_state")
    val readState: Int,
    val title: String,
    val body: String,
)