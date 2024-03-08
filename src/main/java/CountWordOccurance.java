import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class CountWordOccurance {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(System.getProperty("user.dir"))
                .resolve("fox.txt");
          BufferedReader reader = new BufferedReader(new FileReader(path.toFile()));
        Map<String, Integer> occurrence = new HashMap<>();
        String line = reader.readLine();

        while(line != null) {

            if(!line.trim().equals("")) {
                String [] words = line.split(" ");

                for(String word : words) {
                    if(word == null || word.trim().equals("")) {
                        continue;
                    }
                    String processed = word.toLowerCase();
                    processed = processed.replace(",", "");

                    if(occurrence.containsKey(processed)) {
                        occurrence.put(processed,
                                occurrence.get(processed) + 1);
                    } else {
                        occurrence.put(processed, 1);
                    }
                }
            }


            line = reader.readLine();
        }


        System.out.println(occurrence);



        }
    }

