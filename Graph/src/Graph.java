import java.util.*;
public class Graph {
    private Map<Integer, Node> nodeMap;

    public Graph() {
        nodeMap = new HashMap<>();
    }

    public void addNode(int id, String name) {
        Node node = new Node(id, name);
        nodeMap.put(id, node);
    }

    public Node findNodeById(int id) {
        return nodeMap.get(id);
    }

    public List<Node> findChildNodes(int id) {
        Node node = findNodeById(id);
        if (node != null) {
            return node.getChildren();
        }
        return null;
    }

    public Node findNodeByName(String name) {
        for (Node node : nodeMap.values()) {
            if (node.getName().equals(name)) {
                return node;
            }
        }
        return null;
    }

    public List<Node> findShortestPath(String startNodeName, String endNodeName) {
        Node startNode = findNodeByName(startNodeName);
        Node endNode = findNodeByName(endNodeName);

        if (startNode == null || endNode == null) {
            return null;
        }

        Map<Node, Node> parentMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == endNode) {
                break; // Досягнуто кінцевого вузла
            }

            for (Node child : current.getChildren()) {
                if (!parentMap.containsKey(child)) {
                    parentMap.put(child, current);
                    queue.add(child);
                }
            }
        }

        if (!parentMap.containsKey(endNode)) {
            return null; // Шлях не знайдено
        }

        List<Node> shortestPath = new ArrayList<>();
        Node current = endNode;
        while (current != startNode) {
            shortestPath.add(current);
            current = parentMap.get(current);
        }
        shortestPath.add(startNode);
        Collections.reverse(shortestPath);
        return shortestPath;
    }
}
