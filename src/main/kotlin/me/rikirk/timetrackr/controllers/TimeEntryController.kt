package me.rikirk.timetrackr.controllers

import me.rikirk.timetrackr.controllers.models.CreateTimeEntryRequest
import me.rikirk.timetrackr.services.TimeEntryService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
class TimeEntryController(val timeEntryService: TimeEntryService) {
    @PostMapping("/time")
    fun createTimeEntry(@RequestBody createTimeEntryRequest: CreateTimeEntryRequest) = timeEntryService.createTimeEntry(
        createTimeEntryRequest.task
    )

    @GetMapping("/time")
    fun getCurrentTimeEntry() = timeEntryService.getCurrentTimeEntry()
}