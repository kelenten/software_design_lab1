package Commands;

import FileManagers.FileManager;

public class Delete implements Command{

    FileManager fileManager;

    int line;

    String titleName;

    public Delete(FileManager fileManager, int line) {
        this.fileManager = fileManager;
        this.line = line;
        this.titleName = null;
    }

    public Delete(FileManager fileManager,String titleName) {
        this.fileManager = fileManager;
        this.line = -1;
        this.titleName = titleName;
    }

    @Override
    public void execute() {
        fileManager.delete(line, titleName);
    }

    @Override
    public void undo() {

    }
}
