package Models.delete;

import FileManagers.FileManager;

public class DeleteModel {
    public static String deleteByLine(FileManager fileManager, int line){
        return fileManager.deleteByLine(line);
    }

    public static String[] deleteByName(FileManager fileManager, String name){
        return fileManager.deleteByName(name);
    }
}
