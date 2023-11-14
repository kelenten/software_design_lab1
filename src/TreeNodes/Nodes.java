package TreeNodes;

import java.util.List;

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

    public abstract void listTree(List<Integer> pipe, boolean lastNode);

    public abstract CompositeNodes getFather(int level);

    public abstract Nodes getChild(String Name);

    protected void outputPrefix(List<Integer> pipe, boolean lastNode){
        int index = this.level - 1;
        for (int i = 0; i < index; i++) {
            if(pipe.contains(i)){
                System.out.print("|   ");
            } else {
                System.out.print("    ");
            }
        }
        if(lastNode){
            if(pipe.contains(index)){
                pipe.remove(new Integer(index));
            }
            System.out.print("└── ");
        } else {
            pipe.add(index);
            System.out.print("├── ");
        }
    }
}
