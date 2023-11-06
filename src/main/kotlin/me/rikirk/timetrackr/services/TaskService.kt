package me.rikirk.timetrackr.services

import me.rikirk.timetrackr.entities.Task
import me.rikirk.timetrackr.exceptions.NameTakenException
import me.rikirk.timetrackr.exceptions.NotFoundException
import me.rikirk.timetrackr.repositories.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(val taskRepository: TaskRepository, val groupService: GroupService) {
    fun getTasks(): Iterable<Task> = taskRepository.findAll()

    fun getTaskByName(name: String): Task = taskRepository.getTaskByName(name) ?: throw NotFoundException("Task not found")

    fun createTask(name: String, groupName: String): Task? {
        val group = groupService.getGroupByName(groupName)
        val existingTask = taskRepository.findById(name)
        if (existingTask.isPresent) {
            throw NameTakenException("Task name already taken")
        }
        val task = Task(name, group)
        return taskRepository.save(task)
    }
}