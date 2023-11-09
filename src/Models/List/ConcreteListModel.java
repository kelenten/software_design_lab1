package Models.List;

import FileManagers.FileManager;

public class ConcreteListModel implements ListModelInterface {
    public static void list(FileManager fileManager){
        fileManager.listFile();
    }
}
