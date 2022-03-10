package br.com.alura.forum.service

import br.com.alura.forum.model.Course
import org.springframework.stereotype.Service

@Service
class CourseService(var courses: List<Course>) {

    init {
        val course = Course(
            id = 1,
            name = "programming",
            category = "technology"
        )

        courses = listOf(course)
    }

    fun findById(id: Long): Course{
        return courses.stream().filter {
                course -> course.id == id
        }.findFirst().get()
    }
}
