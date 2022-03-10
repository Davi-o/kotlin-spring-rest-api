package br.com.alura.forum.service

import br.com.alura.forum.dto.TopicDTO
import br.com.alura.forum.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val courseService: CourseService,
    private val userService: UserService
) {

    fun listAll(): List<Topic> {
        return topics
    }

    fun findById(id: Long): Topic {
        return topics.stream().filter { t ->
            t.id == id
        }.findFirst().get()
    }

    fun register(dto: TopicDTO) {
        topics = topics.plus(Topic(
            id = topics.size.toLong() + 1,
            title = dto.title,
            message = dto.message,
            course = courseService.findById(dto.courseId),
            author = userService.findById(dto.authorId)
        ))
    }


}