package FileManagers;

import Titles.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkdownFile {
    // 文件名
    public String fileName;

    // 文件对象
    public File file;

    // 文件内容
    public List<String> content;
    public MarkdownFile(String fileName) {
        this.fileName = fileName;
        this.content = new ArrayList<>();
        file = new File(fileName);
        if(!file.exists()){
            try {
                if(file.createNewFile()) {
                    System.out.println("文件创建成功");
                } else {
                    System.out.println("文件创建失败");
                }

            } catch (IOException e) {
                e.getStackTrace();
            }

        } else {
            System.out.println("读取文件:" + fileName);
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.add(line);
                }
            } catch (IOException e) {
                e.getStackTrace();
            }
        }
    }

    public void save(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.file))) {
            for (String line:
                 this.content) {
                writer.write(line + "\n");
            }
            System.out.println("内容已成功写入文件");
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public void insert(int line, String titleName){
        if(line == -1) {
            content.add(titleName);
        } else {
            content.add((line -1), titleName);
        }
    }

    public void delete(int line, String titleName){
        if (line == -1){
            content.removeIf(str -> str.equals(titleName));
        } else {
            content.remove(line - 1);
        }

    }

    public void list(){
        System.out.println("文件:" + this.fileName);
        for (String line:
             this.content) {
            System.out.println(line);
        }
    }

    public void listTree(){
        CompositeNodes rootTitle = new CompositeNodes(0, "this is root", null);
        Pattern pattern1 = Pattern.compile("^(#+)\\s(.+)");
        Pattern pattern2 = Pattern.compile("^(\\d\\.)\\s(.+)");
        Pattern pattern3 = Pattern.compile("^([\\*\\+-])\\s(.+)");
        int tempLevel = 0;
        CompositeNodes tempTitle = rootTitle;
        for (String line:
             this.content) {
            Matcher matcher1 = pattern1.matcher(line);
            Matcher matcher2 = pattern2.matcher(line);
            Matcher matcher3 = pattern3.matcher(line);
            String lineContent;
            if(matcher1.find()) {
                int titleLevel = matcher1.group(1).length();
                lineContent = matcher1.group(2);
                CompositeNodes temp = null;
                if(titleLevel > tempLevel){
                    temp = new CompositeNodes(titleLevel, lineContent, tempTitle);
                    tempTitle.children.add(temp);
                } else {
                    CompositeNodes father = tempTitle.getFather(titleLevel - 1);
                    temp = new CompositeNodes(titleLevel, lineContent, father);
                    father.children.add(temp);
                }
                tempTitle = temp;
                tempLevel = temp.level;
            } else if(matcher3.matches()){
                lineContent = matcher3.group(2);
                LeavesNodes temp = new LeavesNodes(tempLevel + 1, lineContent, tempTitle, TextType.UNORDEREDLIST);
                tempTitle.children.add(temp);

            } else if(matcher2.matches()){
                lineContent = line;
                LeavesNodes temp = new LeavesNodes(tempLevel + 1, lineContent, tempTitle, TextType.ORDEREDLIST);
                tempTitle.children.add(temp);
            }
        }
        List<Nodes> children = rootTitle.children;
        for (Nodes child:
                children) {
            child.listTree(0, children.indexOf(child) == children.size() - 1);
        }
    }
}
