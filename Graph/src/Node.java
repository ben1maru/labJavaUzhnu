import java.util.*;

public class Node {
    private int id;
    private String name;
    private List<Node> children;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
        this.children = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addChild(Node child) {
        children.add(child);
    }
}
