package Commands;

import FileManagers.FileManager;
import Models.Insert.InsertModel;
import Models.delete.DeleteModel;

public class AppendTail implements ICommand {

    private FileManager fileManager;

    private int line;

    private String titleName;

    public AppendTail(FileManager fileManager, String titleName) {
        this.fileManager = fileManager;
        this.titleName = titleName;
    }

    @Override
    public void execute() {
        this.line = InsertModel.insertTail(fileManager, titleName);
    }

    @Override
    public void undo() {
        DeleteModel.deleteByLine(fileManager, this.line);
    }
}
