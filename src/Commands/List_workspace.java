package Commands;

import FileManagers.FileManager;

import java.io.File;

public class List_workspace implements ICommand{
    private FileManager fileManager;

    public List_workspace(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public void execute() {
        this.fileManager.list_workspace();
    }

    @Override
    public void undo() {

    }
}
