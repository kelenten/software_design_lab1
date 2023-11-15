package Commands;

import FileManagers.FileManager;

public class Close implements ICommand{

    private FileManager fileManager;

    public Close(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public void execute() {
        fileManager.closeWorkspace();
    }

    @Override
    public void undo() {

    }
}
