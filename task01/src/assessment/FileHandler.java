package assessment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FileHandler {
    private int wordCount = 0;
    private Map<String, Integer> wordFrequency = new HashMap<String, Integer>();
    private ArrayList<Integer> list = new ArrayList<>();
    private ArrayList<String> keyList = new ArrayList<>();

    public FileHandler() {
    }

    public void readFile(String fileName) throws IOException {
        String line = "", lineWithNoPunctuations = "";
        String[] checkLine;
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        System.out.println("TOP 10 WORDS WITH THE HIGHEST FREQUENCY\n");
        Map<String, Integer> temporaryMap = new HashMap<>();
        while ((line = br.readLine()) != null) {
            lineWithNoPunctuations += line.replaceAll("\\p{IsPunctuation}", "");
        }
        checkLine = lineWithNoPunctuations.toLowerCase().split(" ");
        for (String word : checkLine) {
            if (word.equalsIgnoreCase("")) {
                continue;
            } else {
                wordCount++;
            }
        }
        temporaryMap = getFrequency(checkLine);
        sortByFrequency(temporaryMap);
        System.out.println("Word Count: " + wordCount);
    }

    public Map<String, Integer> getFrequency(String[] lineOfText) {
        for (String text : lineOfText) {
            if (!wordFrequency.containsKey(text)) {
                this.wordFrequency.put(text, 1);
            } else {
                this.wordFrequency.put(text, wordFrequency.get(text) + 1);
            }
        }
        return wordFrequency;
    }

    public void sortByFrequency(Map<String, Integer> mapInput) {

        for (Map.Entry<String, Integer> map : mapInput.entrySet()) {
            list.add(map.getValue());
        }
        Collections.sort(list);
        // System.out.println(list.toString());
        int count = 0;
        for (int i = list.size() - 1; count <= 9; i--) {

            for (Map.Entry<String, Integer> map : mapInput.entrySet()) {
                if (count > 9) {
                    break;
                }
                if (list.get(i).equals(map.getValue())) {
                    if (map.getKey().equals("")) {
                        continue;
                    } else {
                        if (keyList.contains(map.getKey())) {
                            continue;
                        } else {
                            keyList.add(map.getKey());
                            double frequency = (double) list.get(i) / this.wordCount;
                            count++;
                            System.out.printf("%d. %s (Frequency: %.3f)\n", count, map.getKey(),
                                    frequency);
                        }
                    }
                }

            }
        }
    }

}
