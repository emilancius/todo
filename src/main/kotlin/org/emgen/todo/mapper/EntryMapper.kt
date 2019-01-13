package org.emgen.todo.mapper

import org.emgen.todo.entity.EntryEntity
import org.emgen.todo.transmission.Entry
import org.springframework.stereotype.Component

@Component
class EntryMapper {

    fun mapEntryToEntryEntity(entry: Entry) = EntryEntity(entry.id, entry.text)

    fun mapEntryEntityToEntry(entity: EntryEntity) = Entry(entity.id, entity.text)

    fun mapEntryListToEntryEntityList(entries: List<Entry>) = entries.map { mapEntryToEntryEntity(it) }

    fun mapEntryEntityListToEntryList(entities: List<EntryEntity>) = entities.map { mapEntryEntityToEntry(it) }
}