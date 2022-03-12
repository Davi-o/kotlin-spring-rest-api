package odavi.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class TopicForm(
    @field:NotEmpty val title: String,
    @field:NotEmpty val message: String,
    @field:NotNull val courseId: Long,
    @field:NotNull val authorId: Long
)
