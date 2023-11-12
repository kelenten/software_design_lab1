package Commands;

import FileManagers.FileManager;

public class ListTree implements ICommand {

    FileManager fileManager;

    public ListTree(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public void execute() {
        fileManager.listTree();
    }

    @Override
    public void undo() {

    }
}
