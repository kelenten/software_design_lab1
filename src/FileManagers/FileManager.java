package FileManagers;

import Commands.CommandExecutor;
import Observers.LogObserver;
import Observers.SessionObserver;

import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static FileManager instance;  // FileManager单一实例

    private List<MarkdownFile> fileList;  // 编辑的文件列表

    private MarkdownFile tempFile;  // 当前编辑的文件

    private CommandExecutor commandExecutor; // 命令解析器

    private FileManager() {
        this.fileList = new ArrayList<>();
        this.commandExecutor = new CommandExecutor();
    }

    public synchronized static FileManager getInstance(){
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }

    public void createNewFile(String name) {
        MarkdownFile newFile = new MarkdownFile(name);
        fileList.add(newFile);
        this.setTempFile(newFile);
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

    public int insertTail(String titleName){
        return tempFile.insertTail(titleName);
    }

    public String deleteByLine(int line){
        return tempFile.deleteByLine(line);
    }

    public int deleteByName(String titleName){
        return tempFile.deleteByName(titleName);
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

    public void attachLogObserver(LogObserver observer){
        this.commandExecutor.attachLogObserver(observer);
    }

    public void attachSessionObserver(SessionObserver observer){
        this.commandExecutor.attachSessionObserver(observer);
    }
}
