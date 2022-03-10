package br.com.alura.forum.controller

import br.com.alura.forum.dto.TopicDTO
import br.com.alura.forum.model.Topic
import br.com.alura.forum.service.TopicService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun listing(): List<Topic> {
        return service.listAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Topic {
        return service.findById(id)
    }

    @PostMapping
    fun register(@RequestBody topic: TopicDTO) {
        service.register(topic)
    }

}