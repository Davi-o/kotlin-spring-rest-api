package br.com.alura.forum.service

import br.com.alura.forum.model.ForumUser
import org.springframework.stereotype.Service

@Service
class UserService(var users: List<ForumUser> = ArrayList()) {

    init {
        val user = ForumUser(
            id = 1,
            name = "John Doe",
            email = "john@doe.com"
        )

        users = listOf(user)
    }

    fun findById(authorId: Long): ForumUser {
        return users.stream().filter{
            author -> author.id == authorId
        }.findFirst().get()
    }

}
