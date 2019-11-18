import java.io.FileNotFoundException;

public class ApplicationRunner {
    public static void main(String[] args) throws FileNotFoundException {
        WordCounter counter = new WordCounter();


        counter.AddStopWordsFile("stopWords.txt");
        counter.CountWordFrequency("aTaleOfTwoCities.txt");


        counter.PrintFrequencies();
    }
}
