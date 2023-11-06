package me.rikirk.timetrackr.repositories

import me.rikirk.timetrackr.entities.Task
import org.springframework.data.repository.CrudRepository

interface TaskRepository: CrudRepository<Task, String> {
    fun getTaskByName(name: String): Task?
}