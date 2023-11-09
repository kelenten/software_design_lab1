package FileManagers;

import Commands.CommandExecutor;
import Observers.Observer;

import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static FileManager instance;  // FileManager单一实例

    public List<MarkdownFile> fileList;  // 编辑的文件列表

    public MarkdownFile tempFile;  // 当前编辑的文件

    public CommandExecutor commandExecutor; // 命令解析器

    public List<Observer> observerList; // Observer集合

    private FileManager() {
        this.fileList = new ArrayList<>();
        this.observerList = new ArrayList<>();
        this.commandExecutor = new CommandExecutor();
    }

    public static FileManager getInstance(){
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }

    public MarkdownFile createNewFile(String name) {
        MarkdownFile newFile = new MarkdownFile(name);
        fileList.add(newFile);
        this.setTempFile(newFile);
        return newFile;
    }

    public void setTempFile(MarkdownFile tempFile) {
        this.tempFile = tempFile;
    }

    public void executeCommand(String command){
        this.commandExecutor.execute(command, this);
    }

    public void save(){
        this.tempFile.save();
    }

    public void insert(int line, String titleName){
        tempFile.insert(line, titleName);
    }

    public  void delete(int line,String titleName){
        tempFile.delete(line, titleName);
    }

    public  void listFile(){
        this.tempFile.list();
    }

    public void listTree(){
        this.tempFile.listTree();
    }

    public void dirTree(String titleName){
        this.tempFile.dirTree(titleName);
    }

    public void attachObserver(Observer observer) {
        this.observerList.add(observer);
    }

    public  void detachObserver (Observer observer) {
        this.observerList.remove(observer);
    }
}
