package Titles;

public class LeavesNodes extends Nodes {
    public TextType type;

    public LeavesNodes(int level, String titlesName, CompositeNodes father, TextType type) {
        super(level, titlesName, father);
        this.type = type;
    }

    @Override
    public void listTree(int blank, boolean lastNode) {
        for (int i = 0; i < blank; i++) {
            System.out.print("    ");
        }
        for (int i = 0; i < level - blank - 1; i++) {
            System.out.print("|   ");
        }
        if(lastNode){
            blank = this.level;
            System.out.print("└── ");
        } else {
            System.out.print("├── ");
        }
        if(type == TextType.UNORDEREDLIST){
            System.out.print("·" + titlesName + "\n");
        } else {
            System.out.print(titlesName + "\n");
        }
    }

    @Override
    public CompositeNodes getFather(int level) {
        if(father.level == level){
            return father;
        } else {
            return null;
        }
    }
}
