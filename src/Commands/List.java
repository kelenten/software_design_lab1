package Commands;

import FileManagers.FileManager;
import Models.List.ConcreteListModel;

public class List implements Command{
    FileManager fileManager;

    public List(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public void execute() {
        ConcreteListModel.list(fileManager);
    }

    @Override
    public void undo() {

    }
}
