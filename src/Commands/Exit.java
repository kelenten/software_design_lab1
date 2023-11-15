package Commands;

import FileManagers.FileManager;

public class Exit implements ICommand{
    FileManager fileManager;

    public Exit(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public void execute() {
        fileManager.exit();
    }

    @Override
    public void undo() {

    }
}
