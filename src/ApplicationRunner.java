import java.io.FileNotFoundException;
import java.io.IOException;

public class ApplicationRunner {
    public static void main(String[] args) throws IOException {
        WordCounter counter = new WordCounter();


        counter.AddStopWordsFile("stopWords.txt");
        counter.CountWordFrequency("aTaleOfTwoCities.txt");

        counter.SaveFrequencies("save5.txt");
    }
}
