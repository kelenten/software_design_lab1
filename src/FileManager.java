import Commands.CommandExecutor;
import Models.Log.Log;
import Models.Session.Session;
import Observers.Observer;

import java.io.File;
import java.util.List;

public class FileManager {
    private static FileManager instance;

    List<File> fileList;

    private List<Observer> observerList;
    private FileManager() {}

    public static FileManager getInstance(){
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }

    public void attachObserver(Observer observer) {
        observerList.add(observer);
    }

    public  void detachObserver (Observer observer) {
        observerList.remove(observer);
    }


}
