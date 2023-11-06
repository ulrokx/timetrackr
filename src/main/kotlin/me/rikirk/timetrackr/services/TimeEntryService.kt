package me.rikirk.timetrackr.services

import me.rikirk.timetrackr.entities.TimeEntry
import me.rikirk.timetrackr.exceptions.NotFoundException
import me.rikirk.timetrackr.repositories.TaskRepository
import me.rikirk.timetrackr.repositories.TimeEntryRepository
import org.springframework.web.bind.annotation.RestController
import java.time.Duration
import java.time.LocalDateTime

@RestController
class TimeEntryService(
    val timeEntryRepository: TimeEntryRepository, val taskRepository: TaskRepository
) {
    fun createTimeEntry(taskId: String): TimeEntry? {
        val task = taskRepository.findById(taskId)
        if (task.isEmpty) {
            throw NotFoundException("Task not found")
        }
        val lastEntry = timeEntryRepository.getFirstByTaskOrderByStartTimeDesc(task.get())
        val time = LocalDateTime.now()
        return if (lastEntry == null || lastEntry.endTime != null) {
            val entry = TimeEntry(time, task.get())
            timeEntryRepository.save(entry)
        } else {
            lastEntry.endTime = time
            lastEntry.duration = Duration.between(lastEntry.startTime, time)
            timeEntryRepository.save(lastEntry)
        }
    }
}