import java.io.FileWriter;
import java.io.IOException;
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

    public void AddStopWordsFile(File selectedFile) throws FileNotFoundException{
        Scanner in = new Scanner(selectedFile);
        while (in.hasNext()){
            stopWords.add(in.next());
        }
    }

    public void CountWordFrequency(File selectedFile) throws FileNotFoundException{
        Scanner in = new Scanner(selectedFile);
        wordCount.clear();
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

    public void SaveFrequencies (String filename) throws IOException {
        File file = new File(filename);

        if (file.createNewFile()){
            System.out.println("File is created!");
            FileWriter writer = new FileWriter(file);
            String toSave = wordCount.toString();
            toSave = toSave.replaceAll(", ", "\n");
            toSave = toSave.replaceAll("=", ": ");
            toSave = toSave.replaceAll("}", "");
            toSave = toSave.replaceAll("\\{", "#");
            writer.write(toSave);
            writer.close();
        }else{
            System.out.println("File already exists.");
        }
    }
}
