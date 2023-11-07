package Titles;

public abstract class AbstractTitles {
    // 行数
    public int line;

    // 名称
    public String titlesName;

    public AbstractTitles(int line, String titlesName) {
        this.line = line;
        this.titlesName = titlesName;
    }
}
