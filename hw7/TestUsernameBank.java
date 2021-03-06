import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Map;

public class TestUsernameBank {

    @Test
    public void testGoodGenerateUsername() {
        UsernameBank bank = new UsernameBank();
        bank.generateUsername("aat", "at@berkeley.edu");
        assertEquals("at@berkeley.edu", (bank.getUsersAndMails()).get("aat"));
    }

    @Test (expected = NullPointerException.class)
    public void testNullGenerateUsername() {
        UsernameBank bank2 = new UsernameBank();
        bank2.generateUsername(null, "at@berkeley.edu");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testBadGenerateUsername() {
        UsernameBank bank3 = new UsernameBank();
        bank3.generateUsername("aaat", "at@berkeley.edu");
    }

    @Test
    public void testGoodGetEmail() {
        UsernameBank bank = new UsernameBank();
        bank.generateUsername("aat", "at@berkeley.edu");
        assertEquals("at@berkeley.edu", bank.getEmail("aat"));
    }

    @Test (expected = NullPointerException.class)
    public void testNullGetEmail() {
        UsernameBank bank = new UsernameBank();
        bank.generateUsername("aat", "at@berkeley.edu");
        bank.getEmail(null);
    }

    @Test (expected = NullPointerException.class)
    public void testNullGetUsername() {
        UsernameBank bank = new UsernameBank();
        bank.generateUsername("aat", "at@berkeley.edu");
        bank.getUsername(null);
    }

    @Test
    public void testGoodGetUsername() {
        UsernameBank bank = new UsernameBank();
        bank.generateUsername("Aat", "at@berkeley.edu");
        assertEquals("Aat", bank.getUsername("at@berkeley.edu"));
    }

    @Test
    public void testGetBadEmails() {
        UsernameBank bank = new UsernameBank();
        bank.generateUsername("Aat", "at@berkeley.edu");
        bank.getUsername("444@berkeley.edu");
        bank.getUsername("444@berkeley.edu");
        bank.getUsername("444@berkeley.edu");
        Map<String, Integer> badEmails = bank.getBadEmails();
        assertEquals(3, badEmails.get("444@berkeley.edu"), 0);
    }

    @Test
    public void testGetBadUsernames() {
        UsernameBank bank = new UsernameBank();
        bank.generateUsername("Aat", "at@berkeley.edu");
        bank.getEmail("4321");
        bank.getEmail("4321");
        Map<String, Integer> badUsernames = bank.getBadUsernames();
        assertEquals(2, badUsernames.get("4321"), 0);
    }



    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestUsernameBank.class);
    }
}