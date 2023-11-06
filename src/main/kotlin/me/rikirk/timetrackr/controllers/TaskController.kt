package me.rikirk.timetrackr.controllers

import me.rikirk.timetrackr.controllers.models.CreateTaskRequest
import me.rikirk.timetrackr.entities.Task
import me.rikirk.timetrackr.services.TaskService
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
class TaskController(val taskService: TaskService) {
    @GetMapping("/tasks")
    fun getTasks(): Iterable<Task> = taskService.getTasks()

    @GetMapping("/tasks/{name}")
    fun getTaskByName(@PathVariable name: String): Task = taskService.getTaskByName(name)

    @PostMapping("/tasks")
    fun createTask(@RequestBody createTaskRequest: CreateTaskRequest) =
        taskService.createTask(createTaskRequest.name, createTaskRequest.group)
            ?: throw ResponseStatusException(org.springframework.http.HttpStatus.BAD_REQUEST, "Group not found")
}