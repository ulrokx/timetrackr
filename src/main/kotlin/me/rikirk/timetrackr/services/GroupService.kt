package me.rikirk.timetrackr.services

import me.rikirk.timetrackr.entities.Group
import me.rikirk.timetrackr.exceptions.NameTakenException
import me.rikirk.timetrackr.exceptions.NotFoundException
import me.rikirk.timetrackr.repositories.GroupRepository
import org.springframework.stereotype.Service

@Service
class GroupService(val groupRepository: GroupRepository) {
    fun getGroups(): Iterable<Group> = groupRepository.findAll()

    fun createGroup(name: String): Group {
        val existingGroup = groupRepository.findById(name)
        if (existingGroup.isPresent) {
            throw NameTakenException("Group name already taken")
        }
        return groupRepository.save(Group(name))
    }

    fun getGroupByName(name: String) = groupRepository.getGroupByName(name) ?: throw NotFoundException("Group not found")
}