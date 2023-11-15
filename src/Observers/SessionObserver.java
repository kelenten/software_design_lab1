package Observers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SessionObserver implements IObserver {
    private final String SESSION_FILE_PATH = "session.md";

    private String filePath;

    private LocalDateTime startTime;

    private List<String> content = new ArrayList<>();


    public SessionObserver() {
        String formattedDateTime = ObserverUtils.getFormattedDateTime();
        String content = "session start at  " + formattedDateTime;
        ObserverUtils.log(SESSION_FILE_PATH, content);
        this.content.add(content);
    }

    public void update(String filePath){
        if(this.filePath == null){
            this.filePath = filePath;
            startTime = LocalDateTime.now();
        } else if(!this.filePath.equals(filePath)){
            LocalDateTime stopTime = LocalDateTime.now();
            Duration duration = Duration.between(startTime, stopTime);
            long hours = duration.toHours();
            long minutes = duration.toMinutes() % 60;
            String content = "./" + this.filePath + " " + hours + " 小时 " + minutes + " 分钟";
            ObserverUtils.log(SESSION_FILE_PATH, content);
            this.content.add(content);
            this.filePath = filePath;
            startTime = LocalDateTime.now();
        }
    }

    public void showAll(){
        for (String content:
             this.content) {
            System.out.println(content);
        }
        LocalDateTime stopTime = LocalDateTime.now();
        Duration duration = Duration.between(startTime, stopTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        System.out.println("./" + this.filePath + " " + hours + " 小时 " + minutes + " 分钟");
    }

    public void showCurrent(){
        LocalDateTime stopTime = LocalDateTime.now();
        Duration duration = Duration.between(startTime, stopTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        String content = "./" + filePath + " " + hours + " 小时 " + minutes + " 分钟";
        System.out.println(content);
    }
}
