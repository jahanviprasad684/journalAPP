package net.edigest.journalApp.service;


import net.edigest.journalApp.entity.JournalEntity;
import net.edigest.journalApp.entity.User;
import net.edigest.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;



@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserEntryService userEntryService;


    @Transactional
    public void saveEntry(JournalEntity journalEntity, String userName){
        try {
            User user = userEntryService.findByUserName(userName);
            journalEntity.setDate(LocalDateTime.now());
            JournalEntity saved = journalEntryRepository.save(journalEntity);
            journalEntryRepository.save(journalEntity);
            user.getJournalEntities().add(saved);
            userEntryService.saveEntry(user);
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("error occured while saving the entries");
        }
    }

    public void saveEntry(JournalEntity journalEntity){
        journalEntryRepository.save(journalEntity);
    }

    public List<JournalEntity> getAll(){
        return journalEntryRepository.findAll();
    }

    //logic for getbyID
    public Optional<JournalEntity> getById(ObjectId id){
        return journalEntryRepository.findById(id);

    }

    //logic for delete
    @Transactional
    public boolean deleteById(ObjectId id, String username){
        boolean removed;
        try {
            User user = userEntryService.findByUserName(username);
            removed = user.getJournalEntities().removeIf(x -> x.getId().equals(id));
            if (removed) {
                userEntryService.saveEntry(user);
                journalEntryRepository.deleteById(id);
            }
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("An error occured while deleteing the entity " + e);
        }

        return removed;
    }



}
