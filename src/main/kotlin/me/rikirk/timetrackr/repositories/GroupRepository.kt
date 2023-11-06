package me.rikirk.timetrackr.repositories

import me.rikirk.timetrackr.entities.Group
import org.springframework.data.repository.CrudRepository

interface GroupRepository: CrudRepository<Group, String> {
    fun getGroupByName(name: String): Group?
}