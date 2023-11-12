package Observers;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LogObserver implements IObserver {

    private final String FILE_PATH = "log.md";

    public LogObserver() {
        String formattedDateTime = ObserverUtils.getFormattedDateTime();
        String content = "session start at  " + formattedDateTime;
        ObserverUtils.log(FILE_PATH, content);
    }

    public void update(String content) {
        String formattedDateTime = ObserverUtils.getFormattedDateTime();
        String newContent = formattedDateTime + "  " + content;
        ObserverUtils.log(FILE_PATH, newContent);
    }

    public void getLog(int num){
        List<String> content = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(this.FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.add(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        List<String> stringList = content.subList(content.size() - num - 1, content.size() - 1);
        Collections.reverse(stringList);
        StringBuilder result = new StringBuilder();
        for (String str:
             stringList) {
            result.append(str).append("\n");
        }
        System.out.println(result.toString());
    }
}
