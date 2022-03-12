package odavi.forum.mapper

import odavi.forum.dto.TopicForm
import odavi.forum.model.Topic
import odavi.forum.service.CourseService
import odavi.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService
): Mapper<TopicForm, Topic> {

    override fun map(t: TopicForm): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = courseService.findById(t.courseId),
            author = userService.findById(t.authorId)
        )
    }

}
