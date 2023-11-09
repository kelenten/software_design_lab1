package Titles;

public abstract class Nodes {
    // 层级
    public int level;

    // 名称
    public String titlesName;

    public CompositeNodes father;

    public Nodes(int level, String titlesName, CompositeNodes father) {
        this.level = level;
        this.titlesName = titlesName;
        this.father = father;
    }

    public abstract void listTree(int blank, boolean lastNode);

    public abstract CompositeNodes getFather(int level);
}
