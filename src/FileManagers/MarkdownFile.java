package FileManagers;

import Titles.Titles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MarkdownFile {
    // 文件名
    String fileName;

    // 文件对象
    File file;

    // 文件内容
    String context;



    public MarkdownFile(String fileName) {
        this.fileName = fileName;
        this.context = "";
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
                StringBuilder content = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                this.context = content.toString();
            } catch (IOException e) {
                e.getStackTrace();
            }
        }
    }
}
