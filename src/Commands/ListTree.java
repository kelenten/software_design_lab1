package Commands;

import FileManagers.FileManager;
import Models.List.ConcreteListModel;
import Models.List.ConcreteTree;

import java.io.File;

public class ListTree implements Command{

    FileManager fileManager;

    public ListTree(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public void execute() {
        ConcreteTree.listTree(fileManager);
    }

    @Override
    public void undo() {

    }
}
