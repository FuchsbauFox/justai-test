package ru.vk_bot.justai_test

import com.fasterxml.jackson.annotation.JsonProperty

data class Callback (
    val type: String,
    @JsonProperty("object")
    val message: Message?,
    @JsonProperty("group_id")
    val groupId: String,
    val secret: String?,
)