package odavi.forum.controller

import odavi.forum.dto.TopicForm
import odavi.forum.dto.TopicFormUpdate
import odavi.forum.dto.TopicView
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
    fun register(@RequestBody @Valid topicForm: TopicForm) {
        service.register(topicForm)
    }

    @PutMapping
    fun update(@RequestBody @Valid topicForm: TopicFormUpdate) {
        service.update(topicForm)
    }
}