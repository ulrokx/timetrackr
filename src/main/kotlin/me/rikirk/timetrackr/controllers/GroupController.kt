package me.rikirk.timetrackr.controllers

import me.rikirk.timetrackr.controllers.models.CreateGroupRequest
import me.rikirk.timetrackr.entities.Group
import me.rikirk.timetrackr.services.GroupService
import org.springframework.web.bind.annotation.*

@RestController
class GroupController(val groupService: GroupService) {
    @GetMapping("/groups")
    fun getGroups(): Iterable<Group> = groupService.getGroups()

    @GetMapping("/groups/{name}")
    fun getGroupByName(@PathVariable name: String): Group = groupService.getGroupByName(name)

    @PostMapping("/groups")
    fun addGroup(@RequestBody createGroupRequest: CreateGroupRequest): Group = groupService.createGroup(createGroupRequest.name)

}