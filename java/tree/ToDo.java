package tree;

import java.util.HashMap;
import java.util.Map;

public class ToDo {

    private Map<Integer, Integer> map;
    private int[] idArr = {1, 2, 3, 4, 5, 6};
    private int[] parentIdArr = {0, 0, 1, 3, 4, 0};

    private void setMap(int[] idArr, int[] parentIdArr){
        this.map = new HashMap<>();
        if (idArr.length == parentIdArr.length){
            for (int i = 0; i < idArr.length; i++) map.put(idArr[i], parentIdArr[i]);
        }
    }

    private Node getRoot(){
        setMap(idArr, parentIdArr);
        Node root = new Node(new Human(0, 0));
        setChilds(root);
        return root;
    }

    private void setChilds(Node node){
        for (int idKey : map.keySet()) {
            if (map.get(idKey) == node.getCurrent().getId()) node.getChilds().add(new Node(new Human(idKey, map.get(idKey))));
        }
        if (node.getChilds().size() != 0) {
            for (Node child : node.getChilds()) setChilds(child);
        }
    }

    public void showTree(){
        travelTree(getRoot());
    }

    private void travelTree(Node node){
        System.out.println("id: " + node.getCurrent().getId() + "   parentId: " + node.getCurrent().getParentId());
        if (node.getChilds().size() != 0) {
            for (Node child : node.getChilds()) travelTree(child);
        }
    }

}
