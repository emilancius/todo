package org.emgen.todo.entity

import javax.persistence.*

@Entity
@Table(name = "entries")
data class EntryEntity(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long?,
        val text: String
)