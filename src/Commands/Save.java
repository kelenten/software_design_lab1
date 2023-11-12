package Commands;

import FileManagers.FileManager;

public class Save implements ICommand {

    private FileManager fileManager;

    public Save(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public void execute() {
        fileManager.save();
    }

    @Override
    public void undo() {

    }
}
