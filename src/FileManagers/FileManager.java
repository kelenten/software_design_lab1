package FileManagers;

import Commands.CommandExecutor;
import Observers.LogObserver;
import Observers.SessionObserver;

import java.util.*;

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

    /**
     * 创建新的工作区，如果工作区已经存在则会提示
     * @param name 工作区的名称
     */
    public void createNewFile(String name) {
        boolean workspaceHasExist = false;
        for (MarkdownFile file:
             fileList) {
            if (file.getFileName().equals(name)) {
                workspaceHasExist = true;
                break;
            }
        }
        if(!workspaceHasExist){
            MarkdownFile newFile = new MarkdownFile(name);
            fileList.add(newFile);
            this.setTempFile(newFile);
        } else {
            System.out.println("工作区已存在。");
        }
    }

    /**
     * 使用文件名切换活动区文件
     * @param fileName 活动区文件名称
     */
    public void setWorkSpace(String fileName){
        boolean fileExist = false;
        MarkdownFile file = null;

        for (MarkdownFile temp:
             fileList) {
            if(temp.getFileName().equals(fileName)){
                fileExist = true;
                file = temp;
                break;
            }
        }
        if(fileExist){
            setTempFile(file);
        } else {
            System.out.println("工作区不存在。");
        }
    }

    /**
     * 设置活动状态的工作区
     * @param tempFile 活动状态的文件实例
     */
    public void setTempFile(MarkdownFile tempFile) {
        this.tempFile = tempFile;
    }

    /**
     * 将当前工作区内编辑的内容保存到相应文件中，若无活动状态的工作区则会提示
     */
    public void save(){
        if(tempFile != null){
            this.tempFile.save();
        } else {
            System.out.println("没有活动状态的工作区");
        }
    }

    /**
     * 展示当前所有已经打开过的workspace
     */
    public void list_workspace(){
        for (MarkdownFile file:
             fileList) {
            String name = file.getFileName();
            if(this.tempFile != null && this.tempFile.getFileName().equals(name)){
                System.out.println("->" + name + " *");
            } else {
                System.out.println(name);
            }
        }
    }

    /**
     * 程序退出
     */
    public void exit(){
        System.out.println("Do you want to save the current workspace [Y/N]");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if(input.equals("Y")){
            for (MarkdownFile file:
                    fileList) {
                file.save();
            }
        }
        System.exit(0);
    }

    /**
     * 关闭当前活动的工作区
     */
    public void closeWorkspace(){
        System.out.println("Do you want to save the current workspace [Y/N]");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if(input.equals("Y")){
            this.save();
        }
        fileList.remove(this.tempFile);
        this.tempFile = null;
    }

    public void executeCommand(String command){
        this.commandExecutor.execute(command, this);
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

    public String[] deleteByName(String titleName){
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
