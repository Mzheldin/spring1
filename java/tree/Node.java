package tree;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private Human current;
    private List<Node> childs;

    public Node(Human human){
        this.current = human;
        childs = new ArrayList<>();
    }

    public void setCurrent(Human current) {
        this.current = current;
    }

    public Human getCurrent() {
        return current;
    }

    public List<Node> getChilds() {
        return childs;
    }
}
