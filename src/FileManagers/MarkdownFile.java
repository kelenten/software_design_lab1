package FileManagers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
}
