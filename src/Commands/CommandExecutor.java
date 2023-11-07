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

        switch (firstWord){
            case "load":
                // 打开或创建新文件
                String fileName = commandStr.replaceFirst("^\\S+\\s*", "");
                Load load = new Load(fileName);
                load.execute();
                save(load);
            case "save":;
            case "insert":;
            case "append-head":;
            case "append-tail":;
            case "delete":;
            case "undo":;
            case "redo":;
            case "list":;
            case "list-tree":;
            case "dir-tree":;
            case "history":;
            case "stats":;
        }
    }

    private void save(Command command) {
        undoStacks.push(command);
        redoStacks.clear();
    }
}
