package FileManagers;

import Titles.Titles;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MarkdownFile {
    String fileName;

    File file;

    List<Titles> childTitles;

    public MarkdownFile(String fileName) {
        this.fileName = fileName;
        this.childTitles = new ArrayList<>();
        File file = new File(fileName);
        if(!file.exists()){
            try {
                if(file.createNewFile()) {
                    System.out.print("文件创建成功");
                } else {
                    System.out.print("文件创建失败");
                }

            } catch (IOException e) {
                e.getStackTrace();
            }

        } else {
            System.out.print("读取文件:" + fileName);
        }

    }
}
