package Observers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ObserverUtils {

    static void log(String filePath, String content){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content + "\n");
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    static String getFormattedDateTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");
        return currentDateTime.format(formatter);
    }
}
