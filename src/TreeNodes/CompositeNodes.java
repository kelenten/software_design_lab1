package TreeNodes;


import java.util.ArrayList;
import java.util.List;

public class CompositeNodes extends Nodes {


    private List<Nodes> children;

    public CompositeNodes(int level, String titlesName, CompositeNodes father) {
        super(level, titlesName, father);
        this.children = new ArrayList<>();
    }

    @Override
    public void listTree(List<Integer> pipe, boolean lastNode) {
        outputPrefix(pipe, lastNode);
        System.out.print(titlesName + "\n");
        for (Nodes child:
             children) {
            child.listTree(pipe, children.indexOf(child) == children.size() - 1);
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

    public List<Nodes> getChildren() {
        return children;
    }
}
