package Commands;

import FileManagers.FileManager;
import Models.List.ConcreteTree;

import java.io.File;

public class DirTree implements Command{

    FileManager fileManager;

    String titleName;

    public DirTree(FileManager fileManager, String titleName) {
        this.fileManager = fileManager;
        this.titleName = titleName;
    }

    @Override
    public void execute() {
        ConcreteTree.dirTree(fileManager, titleName);
    }

    @Override
    public void undo() {

    }
}
