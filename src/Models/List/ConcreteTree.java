package Models.List;

import FileManagers.FileManager;

import java.io.File;

public class ConcreteTree extends Tree{
    public static void listTree(FileManager fileManager){
        fileManager.listTree();
    }

    public static void dirTree(FileManager fileManager, String titleName){
        fileManager.dirTree(titleName);
    }
}
