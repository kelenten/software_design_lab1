package Commands;

import FileManagers.FileManager;
import Models.Insert.InsertModel;
import Models.delete.DeleteModel;

public class Insert implements ICommand {

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
        this.titleName = titleName;
    }


    @Override
    public void execute() {
        InsertModel.insert(fileManager,line,titleName);
    }

    public void execute2(){
        this.line = InsertModel.insertTail(fileManager, titleName);
    }

    @Override
    public void undo() {
        DeleteModel.deleteByLine(fileManager, this.line);
    }
}
