import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Markdown文件编辑器");
        Scanner in = new Scanner(System.in);


        while (in.hasNext()){
            System.out.println("请输入指令: ");
            String commandStr = in.next();
            // 使用正则表达式匹配输入的第一个单词
            String firstWord = commandStr.trim().split("\\s+")[0].toLowerCase();

            switch (firstWord){
                case "load":;
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
        in.close();
    }
}