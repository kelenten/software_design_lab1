package Commands;

import FileManagers.FileManager;

import java.io.File;

public class Load implements Command{
    String fileName;

    FileManager fileManager;


    public Load(String fileName,FileManager fileManager) {
        this.fileName = fileName;
        this.fileManager = fileManager;
    }

    @Override
    public void execute() {
        System.out.println("创建工作文件:" + this.fileName);

        fileManager.createNewFile(fileName);
    }
}
