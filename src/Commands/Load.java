package Commands;

import FileManagers.FileManager;

public class Load implements ICommand {
    private String fileName;

    private FileManager fileManager;


    public Load(String fileName,FileManager fileManager) {
        this.fileName = fileName;
        this.fileManager = fileManager;
    }

    @Override
    public void execute() {
        fileManager.createNewFile(fileName);
    }

    @Override
    public void undo() {

    }
}
