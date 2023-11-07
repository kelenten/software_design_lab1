import FileManagers.FileManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 唯一的文件管理器
        FileManager fileManager = FileManager.getInstance();

        System.out.println("Markdown文件编辑器");
        Scanner in = new Scanner(System.in);

        System.out.println("请输入指令: ");
        while (in.hasNext()){
            String commandStr = in.nextLine();
            // 对输入命令进行解析
            fileManager.executeCommand(commandStr);
            System.out.println("请输入指令: ");
        }
        in.close();
    }
}