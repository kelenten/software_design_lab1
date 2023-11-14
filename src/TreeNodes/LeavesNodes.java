package TreeNodes;

import java.util.List;

public class LeavesNodes extends Nodes {
    public TextType type;

    public LeavesNodes(int level, String titlesName, CompositeNodes father, TextType type) {
        super(level, titlesName, father);
        this.type = type;
    }

    @Override
    public void listTree(List<Integer> pipe, boolean lastNode) {
        outputPrefix(pipe, lastNode);
        if(type == TextType.UNORDERED_LIST){
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

    @Override
    public Nodes getChild(String Name) {
        return null;
    }
}
