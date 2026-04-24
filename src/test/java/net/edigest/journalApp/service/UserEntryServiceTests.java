//package net.edigest.journalApp.service;
//
//import net.edigest.journalApp.repository.UserEntryRepository;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.springframework.test.util.AssertionErrors.assertEquals;
//
//
//@SpringBootTest
//public class UserEntryServiceTests{
//
//
//    @Autowired
//    UserEntryRepository userEntryRepository;
//
//
//    @ParameterizedTest
//    @ValueSource(strings = {
//            "ram",
//            "vipul",
//            "ronniek"
//    })
//    public void testAdd(String name){
//        //assertEquals("testing summation", 4, 2+2);
//        //assertNotNull(userEntryRepository.findByUserName("ram"));
//        //assertTrue(5 > 3);
//        assertNotNull(userEntryRepository.findByUserName(name), "failed for username "+ name);
//    }
//
//    @Disabled
//    @ParameterizedTest
//    @CsvSource({
//            "1,2,3",
//            "2,2,4",
//            "3,4,5"
//    })
//    public void Test(int a, int b , int expected){
//        assertEquals("abc", expected, a + b);
//    }
//
//
//}
