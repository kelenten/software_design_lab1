package Commands;

import FileManagers.FileManager;

public class Open implements ICommand{
    private String fileName;

    private FileManager fileManager;

    public Open(String fileName, FileManager fileManager) {
        this.fileName = fileName;
        this.fileManager = fileManager;
    }

    @Override
    public void execute() {
        fileManager.setWorkSpace(fileName);
    }

    @Override
    public void undo() {

    }
}
