package Commands;

import FileManagers.FileManager;

import java.awt.*;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandExecutor {

    private Stack<Command> redoStacks;
    private Stack<Command> undoStacks;
    public CommandExecutor() {
        this.redoStacks = new Stack<>();
        this.undoStacks = new Stack<>();
    }

    public void execute(String commandStr, FileManager fileManager) {
        // 使用正则表达式匹配输入的第一个单词
        String firstWord = commandStr.trim().split("\\s+")[0].toLowerCase();
        Pattern pattern = null;
        Matcher matcher = null;
        String titlesName = null;
        int line = -1;

        switch (firstWord){
            case "load":
                // 打开或创建新文件
                String fileName = commandStr.replaceFirst("load\\s", "");
                Load load = new Load(fileName, fileManager);
                load.execute();
                saveCommand(load);
                break;
            case "save":
                // 将内存中的当前编辑数据保存到之前加载的或新创建的⽂件中。确保有⼀个⽂件已经被加载或创建。
                Save save = new Save(fileManager);
                save.execute();
                saveCommand(save);
                break;
            case "insert":
                // 在指定⾏插⼊标题或⽂本。如果不指定⾏号，则默认在⽂件的最后⼀⾏插⼊内容。
                pattern = Pattern.compile("^insert\\s(\\w+)\\s(.*)");
                Pattern pattern2 = Pattern.compile("^insert\\s(.*)");
                matcher = pattern.matcher(commandStr);
                Matcher matcher2 = pattern2.matcher(commandStr);
                Insert insert = null;

                if(matcher.find()) {
                    line = Integer.parseInt(matcher.group(1));
                    titlesName = matcher.group(2);
                    insert = new Insert(fileManager, line, titlesName);
                } else if(matcher2.find()){
                    titlesName = matcher2.group(1);
                    insert = new Insert(fileManager, titlesName);
                } else {
                    System.out.print("insert error");
                }
                insert.execute();
                saveCommand(insert);
                break;
            case "append-head":
                // 在⽂件起始位置插⼊标题或⽂本。
                pattern = Pattern.compile("^(append-head\\s)(.*)");
                matcher = pattern.matcher(commandStr);
                if(matcher.find()) {
                    titlesName = matcher.group(2);
                }
                AppendHead appendHead = new AppendHead(fileManager, titlesName);
                appendHead.execute();
                saveCommand(appendHead);
                break;
            case "append-tail":
                // 在⽂件最后⼀⾏插⼊标题或⽂本。
                pattern = Pattern.compile("^(append-tail\\s)(.*)");
                matcher = pattern.matcher(commandStr);
                if(matcher.find()){
                    titlesName = matcher.group(2);
                }
                AppendTail appendTail = new AppendTail(fileManager, titlesName);
                appendTail.execute();
                saveCommand(appendTail);
                break;
            case "delete":
                pattern = Pattern.compile("^(delete\\s)(.*)");
                matcher = pattern.matcher(commandStr);
                Delete delete = null;
                if(matcher.find()){
                    try {
                        line = Integer.parseInt(matcher.group(2));
                        delete = new Delete(fileManager, line);
                    } catch (NumberFormatException e) {
                        titlesName = matcher.group(2);
                        delete = new Delete(fileManager, titlesName);
                    }
                }
                delete.execute();
                saveCommand(delete);
                break;
            case "undo":
                Undo undo = new Undo();
                break;
            case "redo":
                Redo redo = new Redo();
                break;
            case "list":
                List list = new List(fileManager);
                list.execute();
                saveCommand(list);
                break;
            case "list-tree":
                ListTree listTree = new ListTree(fileManager);
                listTree.execute();
                saveCommand(listTree);
                break;
            case "dir-tree":
                pattern = Pattern.compile("^dir-tree\\s(.*)");
                matcher = pattern.matcher(commandStr);
                if(matcher.find()){
                    titlesName = matcher.group(1);
                }
                DirTree dirTree = new DirTree(fileManager, titlesName);
                dirTree.execute();
                saveCommand(dirTree);
                break;
            case "history":
                pattern = Pattern.compile("^history\\s(.*)");
                matcher = pattern.matcher(commandStr);
                if(matcher.find()){

                }
                break;
            case "stats":
                break;
            case "exit":
                System.exit(0);
        }
    }

    private void saveCommand(Command command) {
        undoStacks.push(command);
        redoStacks.clear();
    }
}
