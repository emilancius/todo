package org.emgen.todo.repository

import org.emgen.todo.entity.EntryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface EntryRepository: JpaRepository<EntryEntity, Long>