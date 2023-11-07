package Models.Insert;

import FileManagers.FileManager;

import java.io.File;

public class InsertModel {
    public static void insert(FileManager fileManager, int line, String titleName){
        if(line == -1){
            fileManager.tempFile.content.add(titleName);
        } else {
            fileManager.tempFile.content.add((line - 1), titleName);
        }
    }
}
