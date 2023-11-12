package Commands;

import FileManagers.FileManager;
import Models.Insert.InsertModel;
import Models.delete.DeleteModel;

public class Delete implements ICommand {

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
        this.titleName = DeleteModel.deleteByLine(fileManager, line);
    }

    public void execute2(){
       this.line = DeleteModel.deleteByName(fileManager, titleName);
    }

    @Override
    public void undo() {
        InsertModel.insert(fileManager, line, titleName);
    }
}
