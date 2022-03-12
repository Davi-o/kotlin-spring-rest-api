package odavi.forum.controller

import odavi.forum.dto.TopicForm
import odavi.forum.dto.TopicView
import odavi.forum.model.Topic
import odavi.forum.service.TopicService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun listing(): List<TopicView> {
        return service.listAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): TopicView {
        return service.findById(id)
    }

    @PostMapping
    fun register(@RequestBody @Valid topic: TopicForm) {
        service.register(topic)
    }

}