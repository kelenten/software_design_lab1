package FileManagers;

import Titles.Titles;

import java.util.ArrayList;
import java.util.List;

public class MarkdownFile {
    String fileName;

    List<Titles> childTitles;

    public MarkdownFile(String fileName) {
        this.fileName = fileName;
        this.childTitles = new ArrayList<>();
    }
}
