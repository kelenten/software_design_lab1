package Commands;

import FileManagers.FileManager;
import Models.Insert.InsertModel;
import Models.delete.DeleteModel;

public class AppendHead implements ICommand {

    private FileManager fileManager;

    private String titleName;

    public AppendHead(FileManager fileManager, String titleName) {
        this.fileManager = fileManager;
        this.titleName = titleName;
    }

    @Override
    public void execute() {
        InsertModel.insert(fileManager, 1, titleName);
    }

    @Override
    public void undo() {
        DeleteModel.deleteByLine(fileManager ,1);
    }
}
