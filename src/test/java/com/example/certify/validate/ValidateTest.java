package com.example.certify.validate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ValidateTest {



    @Test
    public void testEmailValidator(){
        String email = "mariam@gmail.com";
        String email1 = "mariamgmail.com";
        String email2 = "mariamgmailcom";
        String email3 = "mariamfmail.com";

        assertFalse(Validate.checkIfEmailIsValid(email1));
        assertFalse(Validate.checkIfEmailIsValid(email2));
        assertFalse(Validate.checkIfEmailIsValid(email3));
        assertTrue(Validate.checkIfEmailIsValid(email));

    }

    @Test
    public void testPhoneNumber(){
        String i = "09034567889";


//       assertTrue(Validate.checkIfPhoneNumberIsValid(i));
       assertTrue(Validate.checkIfPhoneNumberIsValid("+2347023348494"));
        assertTrue(Validate.checkIfPhoneNumberIsValid("09034474839"));
        assertTrue(Validate.checkIfPhoneNumberIsValid("08034474839"));

        assertTrue(Validate.checkIfPhoneNumberIsValid("07134474839"));
        assertTrue(Validate.checkIfPhoneNumberIsValid("09134474839"));
        assertTrue(Validate.checkIfPhoneNumberIsValid("08134474839"));

    }
}