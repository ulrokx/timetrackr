package me.rikirk.timetrackr.repositories

import me.rikirk.timetrackr.entities.Task
import me.rikirk.timetrackr.entities.TimeEntry
import org.springframework.data.repository.CrudRepository

interface TimeEntryRepository: CrudRepository<TimeEntry, String> {
    fun getFirstByTaskOrderByStartTimeDesc(task: Task): TimeEntry?
}