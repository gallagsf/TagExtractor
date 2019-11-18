import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.File;
import java.io.FileNotFoundException;

public class WordCounter {
    Map<String, Integer> wordCount = new TreeMap<>();
    HashSet<String> stopWords = new HashSet<>();


    WordCounter(){}

    public void AddStopWordsFile(String filename) throws FileNotFoundException{
        Scanner in = new Scanner(new File(filename));
        while (in.hasNext()){
            stopWords.add(in.next());
        }
    }

    public void CountWordFrequency(String filename) throws FileNotFoundException{
        Scanner in = new Scanner(new File(filename));
        while (in.hasNext()) {
            String beingChecked = Clean(in.next());

            Integer count = wordCount.get(beingChecked);

            if (stopWords.contains(beingChecked)) {}
            else if (count == null) {
                count = 1;
                wordCount.put(beingChecked, count);
            }
            else {
                count += 1;
                wordCount.put(beingChecked, count);
            }
        }
    }

    private String Clean(String toClean){
        String clean = "";
        for (int i = 0; i < toClean.length(); ++i){
            char beingChecked = toClean.charAt(i);
            if (Character.isLetter(beingChecked)) {clean += beingChecked;}
        }
        return clean.toLowerCase();
    }

    public void PrintFrequencies(){
        for (String key : wordCount.keySet()){
            System.out.printf("%s %20d\n", key, wordCount.get(key));
        }
    }
}
