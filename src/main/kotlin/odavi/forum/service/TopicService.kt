package odavi.forum.service

import odavi.forum.dto.TopicForm
import odavi.forum.dto.TopicView
import odavi.forum.mapper.TopicFormMapper
import odavi.forum.mapper.TopicViewMapper
import odavi.forum.model.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper
) {

    fun listAll(): List<TopicView> {
        return topics.stream().map {
                topic -> topicViewMapper.map(topic)
        }.collect(Collectors.toList())
    }

    fun findById(id: Long): TopicView {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst().get()

        return topicViewMapper.map(topic)
    }

    fun register(topicForm: TopicForm) {
        val topic = topicFormMapper.map(topicForm)
        topic.id = topics.size.toLong()+1
        
        topics = topics.plus(topic)
    }


}