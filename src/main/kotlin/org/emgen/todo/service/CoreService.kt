package org.emgen.todo.service

import java.util.*

interface CoreService<T, K> {

    fun save(entity: T): T

    fun fetch(): List<T>

    fun fetch(id: K): Optional<T>

    fun remove()

    fun remove(id: K)
}