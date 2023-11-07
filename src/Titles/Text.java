package Titles;

public class Text extends AbstractTitles{
    public String type;

    public Text(int line, String titlesName, String type) {
        super(line, titlesName);
        this.type = type;
    }
}
