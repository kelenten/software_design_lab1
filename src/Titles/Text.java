package Titles;

public class Text extends AbstractTitles{
    public String type;

    public Text(int level, String titlesName, String type) {
        super(level, titlesName);
        this.type = type;
    }
}
