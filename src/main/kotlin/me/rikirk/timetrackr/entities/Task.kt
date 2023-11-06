package me.rikirk.timetrackr.entities

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import jakarta.persistence.*

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "name")
@Entity(name = "tasks")
class Task(
    @Id @Column(name = "name", nullable = false, unique = true) val name: String,
    @ManyToOne() @JoinColumn(name = "group_id") val group: Group,
) {
    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY)
    var timeEntries = mutableListOf<TimeEntry>()
}
