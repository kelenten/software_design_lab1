package Titles;


import java.util.ArrayList;
import java.util.List;

public class Titles extends AbstractTitles{


    public List<AbstractTitles> children;

    public Titles(int level, String titlesName) {
        super(level, titlesName);
        this.children = new ArrayList<>();
    }
}
