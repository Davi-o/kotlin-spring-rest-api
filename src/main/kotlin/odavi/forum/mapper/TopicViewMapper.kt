package odavi.forum.mapper

import odavi.forum.dto.TopicView
import odavi.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper: Mapper<Topic, TopicView> {
    override fun map(topic: Topic): TopicView {
        return TopicView(
            id = topic.id,
            title = topic.title,
            message = topic.message,
            status = topic.status,
            creationDate = topic.createDate
        )
    }
}