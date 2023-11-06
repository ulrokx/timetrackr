package me.rikirk.timetrackr.entities

import jakarta.persistence.*
import java.time.Duration
import java.time.LocalDateTime

@Entity(name = "time_entries")
class TimeEntry(
    @Column(name = "start_time", nullable = false)
    val startTime: LocalDateTime,
    @ManyToOne()
    @JoinColumn(name = "task_id")
    val task: Task,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: String = ""

    @Column(name = "end_time", nullable=true)
    var endTime: LocalDateTime? = null

    @Column(name = "duration", nullable=true)
    var duration: Duration? = null
}