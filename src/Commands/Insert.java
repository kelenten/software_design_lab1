package Commands;

import FileManagers.FileManager;
import Models.Insert.InsertModel;

import java.io.File;

public class Insert implements Command{

    private FileManager fileManager;

    private int line;

    private String titleName;

    public Insert(FileManager fileManager, int line, String titleName) {
        this.fileManager = fileManager;
        this.line = line;
        this.titleName = titleName;
    }

    public Insert(FileManager fileManager, String titleName) {
        this.fileManager = fileManager;
        this.line = -1;
        this.titleName = titleName;
    }


    @Override
    public void execute() {
        InsertModel.insert(fileManager,line,titleName);
    }

    @Override
    public void undo() {

    }
}
