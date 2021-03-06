package ngordnet;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestPlotter {

    public static final int NINETYTWO = 1992;
    public static final double THREEDOTSIX = 3.6;
    public static final int NINETYTHREE = 1993;
    public static final double NINEDOTTWO = 9.2;
    public static final int NINETYFOUR = 1994;
    public static final double FIFTEENTWO = 15.2;
    public static final int NINTYFIVE = 1995;
    public static final double SIXTEENONE = 16.1;
    public static final int NINTYSIX = 1996;
    public static final double NEGFIFTEENSEVEN = -15.7;
    public static final int SEVENTEENTWENTYFOUR = 1724;
    public static final int SEVENTEENFIFTYSEVEN = 1757;
    public static final int OHFIVE = 2005;
    public static final int OHEIGHT = 2008;

    @Test 
    public void testPlotTS() {
        TimeSeries<Double> ts = new TimeSeries<Double>();
        ts.put(NINETYTWO, THREEDOTSIX);
        ts.put(NINETYTHREE, NINEDOTTWO);
        ts.put(NINETYFOUR, FIFTEENTWO);
        ts.put(NINTYFIVE, SIXTEENONE);
        ts.put(NINTYSIX, NEGFIFTEENSEVEN);
        Plotter.plotTS(ts, "Title", "XLabel", "YLabel", "Legend");
    }

    @Test
    public void testPlotCountHistory() {
        NGramMap shortNGM = new NGramMap("./ngrams/very_short.csv", "./ngrams/total_counts.csv");
        Plotter.plotCountHistory(shortNGM, "wandered", OHFIVE, OHEIGHT);
    }

    @Test 
    public void testPlotWeightHistoryy() { 
        NGramMap ngm = new NGramMap("./ngrams/words_that_start_with_q.csv", 
            "./ngrams/total_counts.csv");
        Plotter.plotWeightHistory(ngm, "quantity", SEVENTEENTWENTYFOUR, SEVENTEENFIFTYSEVEN);
    }

    @Test
    public void testPlotCategoryWeights() {
        NGramMap ngm = new NGramMap("./ngrams/words_that_start_with_q.csv", 
            "./ngrams/total_counts.csv");
        WordNet wn = new WordNet("./wordnet/synsets.txt", "./wordnet/hyponyms.txt");
        Plotter.plotCategoryWeights(ngm, wn, "quantity", SEVENTEENTWENTYFOUR, SEVENTEENFIFTYSEVEN);
    }

    @Test
    public void testPlotCategoryWeights2() {
        NGramMap ngm = new NGramMap("./ngrams/words_that_start_with_q.csv", 
            "./ngrams/total_counts.csv");
        WordNet wn = new WordNet("./wordnet/synsets.txt", "./wordnet/hyponyms.txt");
        Plotter.plotCategoryWeights(ngm, wn, new String[] {"quantity", "quarrel"}, 
            SEVENTEENTWENTYFOUR, SEVENTEENFIFTYSEVEN);
    }

    @Test
    public void testPlotAllWords() {
        NGramMap ngm = new NGramMap("./ngrams/words_that_start_with_q.csv", 
            "./ngrams/total_counts.csv");
        Plotter.plotAllWords(ngm, new String[] {"quantity", "quarrel"}, 
            SEVENTEENTWENTYFOUR, SEVENTEENFIFTYSEVEN);
    }



    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestPlotter.class);
    }

}
