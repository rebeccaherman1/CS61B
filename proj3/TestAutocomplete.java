import org.junit.Test;
import static org.junit.Assert.*;

public class TestAutocomplete {

    @Test
    public void testStructure() {
        String[] terms = new String[] {"smog", "buck", "sad", "spite", "spit", "spy"};
        double[] weights = {(double) 5, (double) 10, (double) 12, (double) 20, (double) 15, (double) 7};
        Autocomplete a = new Autocomplete(terms, weights);
        assertNotNull(a);
    }

    @Test
    public void testWeightOf() {
        String[] terms2 = new String[] {"smog", "buck", "sad", "spite", "spit", "spy"};
        double[] weights2 = {(double) 5, (double) 10, (double) 12, (double) 20, (double) 15, (double) 7};
        Autocomplete a2 = new Autocomplete(terms2, weights2);

        assertEquals(a2.weightOf("spit"), 15, 0);
        assertEquals(a2.weightOf("spite"), 20, 0);
        assertEquals(a2.weightOf("smmg"), 0, 0);
    }

    @Test
    public void testTopMatch() {
        String[] terms3 = new String[] {"smog", "buck", "sad", "spite", "spit", "spy"};
        double[] weights3 = {(double) 5, (double) 10, (double) 12, (double) 20, (double) 15, (double) 7};
        Autocomplete a3 = new Autocomplete(terms3, weights3);

        assertEquals(a3.topMatch("s"), "spite");
        assertNull(a3.topMatch("soie"));
    }

    @Test
    public void testTopMatches() {
        String[] terms4 = new String[] {"smog", "buck", "sad", "spite", "spit", "spy"};
        double[] weights4 = {(double) 5, (double) 10, (double) 12, (double) 20, (double) 15, (double) 7};
        Autocomplete a4 = new Autocomplete(terms4, weights4);

        Iterable<String> checkMatches = a4.topMatches("s", 3);
        String[] theMatches = new String[3];
        
        int i = 0;
        for (String match : checkMatches) {
            theMatches[i] = match;
            i = i + 1;
        }

        assertEquals("spite", theMatches[0]);
        assertEquals("spit", theMatches[1]);
        assertEquals("sad", theMatches[2]);
    }

    @Test
    public void testTopMatches2() {
        String[] terms5 = new String[] {"smog", "buck", "sad", "spite", "spit", "spy"};
        double[] weights5 = {(double) 5, (double) 10, (double) 12, (double) 20, (double) 15, (double) 7};
        Autocomplete a5 = new Autocomplete(terms5, weights5);

        Iterable<String> checkMatches = a5.topMatches("s", 4);
        String[] theMatches = new String[4];
        
        int i = 0;
        for (String match : checkMatches) {
            theMatches[i] = match;
            i = i + 1;
        }

        Iterable<String> checkMatchesNull = a5.topMatches("smoggy", 1);
        assertNull(checkMatchesNull);

        assertEquals("spite", theMatches[0]);
        assertEquals("spit", theMatches[1]);
        assertEquals("sad", theMatches[2]);
        assertEquals("spy", theMatches[3]);
    }

    @Test
    public void testTopMatchesWithSelf() {
        String[] terms = new String[] {"the", "they", "their", "them", "there"};
        double[] weights = {56271872.0, 3340398.0, 2820265.0, 2509917.0, 1961200.0};
        Autocomplete a = new Autocomplete(terms, weights);

        Iterable<String> checkMatches = a.topMatches("the", 5);
        String[] theMatches = new String[5];
        
        int i = 0;
        for (String match : checkMatches) {
            theMatches[i] = match;
            i = i + 1;
        }

        assertEquals("the", theMatches[0]);
        assertEquals("they", theMatches[1]);
        assertEquals("their", theMatches[2]);
        assertEquals("them", theMatches[3]);
        assertEquals("there", theMatches[4]);
    }

    @Test
    public void testComp() {
        String[] terms = new String[] {"come", "comes", "comedy", "comely", "company", "complete", "companion", "completely", "comply"};
        double[] weights = {873007.0, 153299.0, 11718.2, 5122.6, 133159.0, 78039.8, 60384.9, 52050.3, 44817.7};
        Autocomplete a = new Autocomplete(terms, weights);

        Iterable<String> checkMatches = a.topMatches("comp", 5);
        String[] theMatches = new String[5];
        
        int i = 0;
        for (String match : checkMatches) {
            theMatches[i] = match;
            i = i + 1;
        }

        assertEquals("company", theMatches[0]);
        assertEquals("complete", theMatches[1]);
        assertEquals("companion", theMatches[2]);
        assertEquals("completely", theMatches[3]);
        assertEquals("comply", theMatches[4]);
    }

    @Test
    public void testMCities() {
        String[] terms = new String[] {"Mumbai, India", "Mexico City, Distrito Federal, Mexico", "Aye Yo, CA"};
        double[] weights = {12691836.0, 12294193.0, 3255944.0};
        Autocomplete a = new Autocomplete(terms, weights);

        Iterable<String> checkMatches = a.topMatches("M", 7);
        String[] theMatches = new String[2];
        
        int i = 0;
        for (String match : checkMatches) {
            theMatches[i] = match;
            i = i + 1;
        }

        assertEquals(2, theMatches.length);
        assertEquals("Mumbai, India", theMatches[0]);
        assertEquals("Mexico City, Distrito Federal, Mexico", theMatches[1]);
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testDifferentLength() {
        String[] terms = new String[] {"Mumbai, India", "Mexico City, Distrito Federal, Mexico", "Aye Yo, CA"};
        double[] weights = {12691836.0, 12294193.0, 3255944.0, 3871829.9};
        Autocomplete a = new Autocomplete(terms, weights);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDuplicateInputs() {
        String[] terms = new String[] {"Mumbai, India", "Mexico City, Distrito Federal, Mexico", "Aye Yo, CA", "Mumbai, India"};
        double[] weights = {12691836.0, 12294193.0, 3255944.0, 3871829.9};
        Autocomplete a = new Autocomplete(terms, weights);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWeights() {
        String[] terms = new String[] {"Mumbai, India", "Mexico City, Distrito Federal, Mexico", "Aye Yo, CA"};
        double[] weights = {12691836.0, 12294193.0, -3255944.0};
        Autocomplete a = new Autocomplete(terms, weights);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNonPositiveKTerms() {
        String[] terms = new String[] {"Mumbai, India", "Mexico City, Distrito Federal, Mexico", "Aye Yo, CA"};
        double[] weights = {12691836.0, 12294193.0, 3255944.0};
        Autocomplete a = new Autocomplete(terms, weights);

        Iterable<String> checkMatches = a.topMatches("M", 0);
    }


    public static void main(String[] args) {
            jh61b.junit.textui.runClasses(TestAutocomplete.class);
        }

}