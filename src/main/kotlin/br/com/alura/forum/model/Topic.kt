package br.com.alura.forum.model

import java.time.LocalDateTime

data class Topic(
        val id: Long? = null,
        val title: String,
        val message: String,
        val createDate: LocalDateTime = LocalDateTime.now(),
        val course: Course,
        val author: ForumUser,
        val status: TopicStatus = TopicStatus.UNANSWERED,
        val answers: List<Answer> = ArrayList()
)