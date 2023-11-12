import FileManagers.FileManager;
import Observers.LogObserver;
import Observers.SessionObserver;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestUtils {
    static String getOutput(String[] inputList){
        // 创建一个 ByteArrayOutputStream 对象，用于捕获输出
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // 将标准输出流重定向到 ByteArrayOutputStream
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        FileManager fileManager = FileManager.getInstance();

        // 创建Observers
        LogObserver logObserver = new LogObserver();
        SessionObserver sessionObserver = new SessionObserver();

        fileManager.attachLogObserver(logObserver);
        fileManager.attachSessionObserver(sessionObserver);

        for (String str:
                inputList) {
            fileManager.executeCommand(str);
        }



        // 从 ByteArrayOutputStream 中获取输出内容
        return outputStream.toString();
    }
}
