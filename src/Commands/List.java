package Commands;

import FileManagers.FileManager;

public class List implements ICommand {
    FileManager fileManager;

    public List(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public void execute() {
        fileManager.listFile();
    }

    @Override
    public void undo() {

    }
}
