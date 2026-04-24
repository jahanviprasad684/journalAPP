package net.edigest.journalApp.service;


import lombok.extern.slf4j.Slf4j;
import net.edigest.journalApp.entity.JournalEntity;
import net.edigest.journalApp.entity.User;
import net.edigest.journalApp.repository.JournalEntryRepository;
import net.edigest.journalApp.repository.UserEntryRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Component
@Slf4j
public class UserEntryService {

    @Autowired
    private UserEntryRepository userEntryRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserEntryService.class);

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveEntry(User user){
        userEntryRepository.save(user);
    }

    public Boolean saveNewEntry(User user){
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userEntryRepository.save(user);
            return true;
        }catch (Exception e){
            log.error("hahahaha");
            logger.warn("hahahaha");
            logger.info("hahahaha");
            logger.debug("hahahaha");
            logger.trace("hahahaha");
            return false;
        }
    }

    public List<User> getAll(){
        return userEntryRepository.findAll();
    }

    //logic for getbyID
    public Optional<User> getById(ObjectId id){
        return userEntryRepository.findById(id);

    }

    //logic for delete
    public void deleteById(ObjectId id){
        userEntryRepository.deleteById(id);
    }

    public User findByUserName(String userName){

        return userEntryRepository.findByUserName(userName);
    }

    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        userEntryRepository.save(user);
    }
}
