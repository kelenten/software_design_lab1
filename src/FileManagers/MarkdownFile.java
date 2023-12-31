package FileManagers;

import TreeNodes.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkdownFile {
    // 文件名
    private String fileName;

    // 文件对象
    private File file;

    // 文件内容
    private List<String> content;

    private CompositeNodes rootTitle;

    MarkdownFile(String fileName) {
        this.fileName = fileName;
        this.content = new ArrayList<>();
        this.rootTitle = null;
        file = new File(fileName);
        if(!file.exists()){
            try {
                file.createNewFile();

            } catch (IOException e) {
                e.getStackTrace();
            }

        } else {
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

    void save(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.file, false))) {
            for (String line:
                 this.content) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    void insert(int line, String titleName){
        content.add((line -1), titleName);
    }

    int insertTail(String titleName){
        content.add(titleName);
        return content.indexOf(titleName) + 1;
    }

    String deleteByLine(int line){
        String name = content.get(line - 1);
        content.remove(name);
        return name;
    }

    String[] deleteByName(String name){
        String[] result = new String[2];
        Iterator<String> iterator = this.content.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.split("\\s")[1].equals(name)) {
                result[0] = str;
                result[1] = this.content.indexOf(str) + 1 + "";
                iterator.remove();
            }
        }
        return result;
    }

    void list(){
        System.out.println("文件:" + this.fileName);
        for (String line:
             this.content) {
            System.out.println(line);
        }
    }

    private CompositeNodes getTree(){
        CompositeNodes rootTitle = new CompositeNodes(0, "this is root", null);
        Pattern pattern1 = Pattern.compile("^(#+)\\s(.+)");
        Pattern pattern2 = Pattern.compile("^(\\d\\.)\\s(.+)");
        Pattern pattern3 = Pattern.compile("^([*+-])\\s(.+)");
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
                    tempTitle.getChildren().add(temp);
                } else {
                    CompositeNodes father = tempTitle.getFather(titleLevel - 1);
                    temp = new CompositeNodes(titleLevel, lineContent, father);
                    father.getChildren().add(temp);
                }
                tempTitle = temp;
                tempLevel = temp.getLevel();
            } else if(matcher3.matches()){
                lineContent = matcher3.group(2);
                LeavesNodes temp = new LeavesNodes(tempLevel + 1, lineContent, tempTitle, TextType.UNORDERED_LIST);
                tempTitle.getChildren().add(temp);

            } else if(matcher2.matches()){
                lineContent = line;
                LeavesNodes temp = new LeavesNodes(tempLevel + 1, lineContent, tempTitle, TextType.ORDERED_LIST);
                tempTitle.getChildren().add(temp);
            }
        }
        return rootTitle;
    }

    void listTree(){
        this.rootTitle = this.getTree();
        List<Nodes> children = rootTitle.getChildren();
        for (Nodes child:
                children) {
            child.listTree(new ArrayList<>(), children.indexOf(child) == children.size() - 1);
        }
    }

    void dirTree(String titleName){
        this.rootTitle = this.getTree();
        Nodes temp = this.rootTitle.getChild(titleName);
        temp.listTree(new ArrayList<>(), true);
    }

    String getFileName() {
        return fileName;
    }
}
