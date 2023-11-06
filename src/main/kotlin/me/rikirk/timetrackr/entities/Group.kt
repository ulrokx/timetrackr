package me.rikirk.timetrackr.entities

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import jakarta.persistence.*

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "name")
@Entity(name = "groups")
class Group(
    @Id @Column(name = "name", nullable = false, unique = true)
    var name: String,
) {
    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    var tasks = mutableListOf<Task>()
}