package Commands;

import FileManagers.FileManager;

public class Save implements Command{

    private FileManager fileManager;

    public Save(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public void execute() {
        fileManager.save();
        System.out.print("保存成功");
    }

    @Override
    public void undo() {

    }
}
