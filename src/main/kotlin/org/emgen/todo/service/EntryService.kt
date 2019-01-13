package org.emgen.todo.service

import org.emgen.todo.entity.EntryEntity
import org.emgen.todo.mapper.EntryMapper
import org.emgen.todo.repository.EntryRepository
import org.emgen.todo.transmission.Entry
import org.springframework.stereotype.Service
import java.util.*

@Service
class EntryService(
        val repository: EntryRepository,
        val mapper: EntryMapper
): CoreService<EntryEntity, Long> {

    override fun save(entity: EntryEntity): EntryEntity = repository.save(entity)

    override fun fetch(): List<EntryEntity> = repository.findAll()

    override fun fetch(id: Long): Optional<EntryEntity> = repository.findById(id)

    override fun remove() = repository.deleteAll()

    override fun remove(id: Long) = repository.deleteById(id)

    fun saveEntry(entry: Entry) = mapper.mapEntryEntityToEntry(save(mapper.mapEntryToEntryEntity(entry)))

    fun fetchEntries() = mapper.mapEntryEntityListToEntryList(fetch())

    fun fetchEntry(id: Long): Optional<Entry> {
        val entity = fetch(id)
        return if (entity.isPresent) {
            Optional.of(mapper.mapEntryEntityToEntry(entity.get()))
        } else {
            Optional.empty()
        }
    }
}