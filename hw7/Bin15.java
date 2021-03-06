import java.lang.Math;
// Don't forget to answer the follow-up question!
public class Bin15 {

    // A string of exactly 15 characters, each a 0 or 1.
    private String myBinStr;

    // A constantly-whining constructor for your testing purposes.
    public Bin15(String input) {

        // Check for null input
        if (input == null) {
            String msg = "Your binary string is null";
            throw new NullPointerException(msg);
        }

        // Check for length
        if (input.length() != 15) {
            String msg = "Your binary string isn't of length 15";
            throw new IllegalArgumentException(msg);
        }

        // Check for illegal characters
        for (int count = 0; count < 15; count++) {
            char c = input.charAt(count);
            // Careful with comparing vs 0 and comparing vs '0'
            if (c != '0' && c != '1') {
                String msg = "Your binary string contains a non-binary character";
                throw new IllegalArgumentException(msg);
            }
        }

        // The input is good. Let's roll.
        this.myBinStr = input;
    }
    
    @Override
    public boolean equals(Object o) {
        if ((o != null) && (this != null) && (o instanceof Bin15)) {
            Bin15 other = (Bin15) o;
            return (this.myBinStr).equals(other.myBinStr);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        // Turn it into its int value?
        int intVal = 0; // Initialize.
        for (int i = 0; i < 15; i = i + 1) {
            char num = (this.myBinStr).charAt(i);
            intVal = intVal << 1;
            if (num == '1') {
                intVal = intVal + 1;
            }
        }
        return intVal;
    }

    /* DO THIS LAST, AFTER IMPLEMENTING EVERYTHING
    Follow-up question: The current length of our myBinStr is 15. What is the
    longest length possible for this String such that we still can produce a
    perfect hash (assuming we can rewrite the hash function)? Write your answer
    in the method followUpAnswer(). 
    */
    public static final int followUpAnswer() {
        return 32; 
        /* There are around 4.295 * 10^9 unique ints. 
        How many unique strings of some length that <= that 4 billion tho? GUESS AND CHECK. 
            * 2^42 is 4.39 * 10^12. Too much. 
            * 2^30 = 1.07 * 10^9. Too low. */
    }
    
    public static void main(String[] args) {
        // Optional testing here. Potentially useless information:
        int c = 0x9 - 1 - 0b01;
        // 0x9 means 9 in hexadecimal
        // 1 means 1 in decimal
        // 0b01 means 01 or 1 in binary
        System.out.println("Note to self: Answer follow-up question!");
    }
}

