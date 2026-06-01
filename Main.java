import java.io.*;
import java.util.*;

class DocumentDictionary {

    public static void main(String[] args) {

        HashMap<String, Wordinfo> dictionary = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/document.txt"));

            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {

                lineNumber++;

                line = line.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "");

                String[] words = line.split("\\s+");

                for (String word : words) {

                    if (word.isEmpty())
                        continue;

                    dictionary.putIfAbsent(word, new Wordinfo());

                    dictionary.get(word).addOccurrence(lineNumber);
                }
            }

            br.close();

            System.out.println("DOCUMENT DICTIONARY");

            for (Map.Entry<String, Wordinfo> entry : dictionary.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
