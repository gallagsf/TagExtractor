import java.io.FileNotFoundException;

public class ApplicationRunner {
    public static void main(String[] args) throws FileNotFoundException {
        WordCounter counter = new WordCounter();
        System.out.println("test1");

        counter.CountWordFrequency("aTaleOfTwoCities.txt");
        System.out.println("test2");

        counter.PrintFrequencies();
    }
}
