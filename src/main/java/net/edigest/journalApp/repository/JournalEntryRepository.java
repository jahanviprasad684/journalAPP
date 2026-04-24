package net.edigest.journalApp.repository;

import net.edigest.journalApp.entity.JournalEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;


@Component
public interface JournalEntryRepository extends MongoRepository<JournalEntity, ObjectId> {
}
