package Commands;

import FileManagers.FileManager;

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
                Save save = new Save();
                save.execute();
                saveCommand(save);
                break;
            case "insert":
                // 在指定⾏插⼊标题或⽂本。如果不指定⾏号，则默认在⽂件的最后⼀⾏插⼊内容。
                pattern = Pattern.compile("^(insert\\s)(\\w+)(\\s)(.*)");
                matcher = pattern.matcher(commandStr);
                titlesName = null;
                int line = -1;
                if(matcher.find()) {
                    line = Integer.parseInt(matcher.group(2));
                    titlesName = matcher.group(4);
                } else {
                    System.out.print("insert error");
                }
                Insert insert = new Insert();
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
                AppendHead appendHead = new AppendHead();
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
                AppendTail appendTail = new AppendTail();
                appendTail.execute();
                saveCommand(appendTail);
                break;
            case "delete":
                pattern = Pattern.compile("^(delete\\s)(.*)");
                matcher = pattern.matcher(commandStr);
                if(matcher.find()){
                    try {
                        line = Integer.parseInt(matcher.group(2));
                    } catch (NumberFormatException e) {
                        titlesName = matcher.group(2);
                    }
                }
                Delete delete = new Delete();
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
                List list = new List();
                list.execute();
                saveCommand(list);
                break;
            case "list-tree":
                ListTree listTree = new ListTree();
                listTree.execute();
                saveCommand(listTree);
                break;
            case "dir-tree":
                pattern = Pattern.compile("^dir-tree\\s(.*)");
                matcher = pattern.matcher(commandStr);
                if(matcher.find()){
                    titlesName = matcher.group(1);
                }
            case "history":
                pattern = Pattern.compile("^history\\s(.*)");
                matcher = pattern.matcher(commandStr);
                if(matcher.find()){

                }

            case "stats":;
        }
    }

    private void saveCommand(Command command) {
        undoStacks.push(command);
        redoStacks.clear();
    }
}
