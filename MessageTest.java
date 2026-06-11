
package chatapp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MessageTest {
    
    @Test
    public void testValidRecipientCellFormat() {
        Message ms = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertEquals("Cell phone successfully captured", ms.checkRecipientCell());
    }
    @Test
    public void testInvalidRecipientCellFormat(){
        Message ms = new Message("08575975889", "Hi Keegan, did you recieve the payment?");
        assertEquals("Cell phone number incorrectly formatted or doesnt contain the international code. Correct the number and try again", ms.checkRecipientCell());
    }
    
    //tets for valid and invlid message lengths limits
    @Test
    public void testValidMessageLengthLimit() {
        Message ms = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertEquals("Message ready to send.", ms.validateMessageLength());
    }
    @Test
    public void testInvalidMessageLengthLimit(){
        Message ms = new Message("08575975889", "Hi Keegan, did you recieve the payment?");
        assertEquals("Message exceeds 250 charecters by x charecters. Please reduce the size", ms.validateMessageLength());
    }
    
    // Message sending options
    @Test
    public void testMessageSendingOption() {
        Message ms = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertEquals("Message successfully sent.", ms.sendMessages(1));
    }
    @Test
    public void testMEssageDisregardingOption(){
        Message ms = new Message("08575975889", "Hi Keegan, did you recieve the payment?");
        assertEquals("Press 0 to delete the message.", ms.sendMessages(2));
    }
    @Test
    public void testStoringMessageOption() {
        Message ms = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertEquals("Message successfully stored", ms.sendMessages(3));
    }
    
    
}
