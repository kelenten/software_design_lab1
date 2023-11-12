package Commands;

import FileManagers.FileManager;

public class DirTree implements ICommand {

    FileManager fileManager;

    String titleName;

    public DirTree(FileManager fileManager, String titleName) {
        this.fileManager = fileManager;
        this.titleName = titleName;
    }

    @Override
    public void execute() {
        fileManager.dirTree(titleName);
    }

    @Override
    public void undo() {

    }
}
