package Models.Insert;

import FileManagers.FileManager;

import java.io.File;

public class InsertModel {
    public static void insert(FileManager fileManager, int line, String titleName){
        fileManager.insert(line, titleName);
    }
}
