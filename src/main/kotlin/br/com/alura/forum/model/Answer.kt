package br.com.alura.forum.model

import java.time.LocalDateTime

data class Answer(
    val id: Long? = null,
    val message: String,
    val createDate: LocalDateTime = LocalDateTime.now(),
    val author: ForumUser,
    val topic: Topic,
    val isSolution: Boolean
)
