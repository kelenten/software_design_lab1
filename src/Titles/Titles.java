package Titles;


import java.util.ArrayList;
import java.util.List;

public class Titles extends AbstractTitles{


    public List<AbstractTitles> children;

    public Titles(int line, String titlesName) {
        super(line, titlesName);
        this.children = new ArrayList<>();
    }
}
