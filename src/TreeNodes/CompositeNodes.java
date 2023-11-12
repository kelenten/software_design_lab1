package TreeNodes;


import java.util.ArrayList;
import java.util.List;

public class CompositeNodes extends Nodes {


    public List<Nodes> children;

    public CompositeNodes(int level, String titlesName, CompositeNodes father) {
        super(level, titlesName, father);
        this.children = new ArrayList<>();
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
        System.out.print(titlesName + "\n");
        for (Nodes child:
             children) {
            if(children.indexOf(child) == children.size() - 1){
                child.listTree(blank, true);
            } else {
                child.listTree(blank, false);
            }
        }
    }

    @Override
    public CompositeNodes getFather(int level) {
        if(father.level == level){
            return father;
        } else {
            return father.getFather(level);
        }
    }

    @Override
    public Nodes getChild(String name) {
        Nodes temp = null;
        for (Nodes child:
             children) {
            if(temp == null){
                if(child.titlesName.equals(name)){
                    temp = child;
                } else {
                    temp = child.getChild(name);
                }
            }
        }
        return temp;
    }
}
