package odavi.forum.service

import odavi.forum.dto.TopicForm
import odavi.forum.dto.TopicFormUpdate
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
        return topicViewMapper.map(getTopicById(id))
    }

    fun register(topicForm: TopicForm) {
        val topic = topicFormMapper.map(topicForm)
        topic.id = topics.size.toLong()+1
        
        topics = topics.plus(topic)
    }

    fun getTopicById(id: Long): Topic {
        return topics.stream().filter { t ->
            t.id == id
        }.findFirst().get()
    }

    fun update(topicForm: TopicFormUpdate) {
        val topic = getTopicById(topicForm.id)
        topics = topics.minus(topic).plus(Topic(
            id = topicForm.id,
            title = topicForm.title,
            message = topicForm.message,
            author = topic.author,
            course = topic.course,
            answers = topic.answers,
            status = topic.status,
            createDate = topic.createDate
        ))
    }

}
