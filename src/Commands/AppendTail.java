package Commands;

import FileManagers.FileManager;
import Models.Insert.InsertModel;

public class AppendTail implements Command{

    private FileManager fileManager;

    private String titleName;

    public AppendTail(FileManager fileManager, String titleName) {
        this.fileManager = fileManager;
        this.titleName = titleName;
    }

    @Override
    public void execute() {
        InsertModel.insert(fileManager, -1, titleName);
    }

    @Override
    public void undo() {

    }
}
