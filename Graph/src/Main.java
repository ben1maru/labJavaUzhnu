import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Додати вузол");
            System.out.println("2. Знайти вузол за ID");
            System.out.println("3. Знайти дітей вузла");
            System.out.println("4. Знайти вузол за ім'ям");
            System.out.println("5. Знайти найкоротший шлях");
            System.out.println("0. Вийти");

            System.out.print("Виберіть опцію: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Пропустити рядок

            switch (choice) {
                case 1:
                    System.out.print("Введіть ID вузла: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введіть ім'я вузла: ");
                    String name = scanner.nextLine();
                    graph.addNode(id, name);
                    break;
                case 2:
                    System.out.print("Введіть ID вузла: ");
                    int idToFind = scanner.nextInt();
                    scanner.nextLine();
                    Node foundNodeById = graph.findNodeById(idToFind);
                    if (foundNodeById != null) {
                        System.out.println("Знайдено вузол: " + foundNodeById.getName());
                    } else {
                        System.out.println("Вузол не знайдено.");
                    }
                    break;
                case 3:
                    System.out.print("Введіть ID вузла: ");
                    int idToFindChildren = scanner.nextInt();
                    scanner.nextLine();
                    List<Node> childNodes = graph.findChildNodes(idToFindChildren);
                    if (childNodes != null) {
                        System.out.println("Діти вузла:");
                        for (Node child : childNodes) {
                            System.out.println(child.getName());
                        }
                    } else {
                        System.out.println("Вузол не знайдено або в нього немає дітей.");
                    }
                    break;
                case 4:
                    System.out.print("Введіть ім'я вузла: ");
                    String nameToFind = scanner.nextLine();
                    Node foundNodeByName = graph.findNodeByName(nameToFind);
                    if (foundNodeByName != null) {
                        System.out.println("Знайдено вузол з ім'ям: " + foundNodeByName.getName());
                    } else {
                        System.out.println("Вузол з таким ім'ям не знайдено.");
                    }
                    break;
                case 5:
                    System.out.print("Введіть початкове ім'я вузла: ");
                    String startNodeName = scanner.nextLine();
                    System.out.print("Введіть кінцеве ім'я вузла: ");
                    String endNodeName = scanner.nextLine();
                    List<Node> path = graph.findShortestPath(startNodeName, endNodeName);
                    if (path != null) {
                        System.out.print("Найкоротший шлях: ");
                        for (Node node : path) {
                            System.out.print(node.getName() + " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("Шлях не знайдено.");
                    }
                    break;
                case 0:
                    System.out.println("Програма завершила роботу.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Невірний вибір опції. Будь ласка, виберіть іншу опцію.");
            }
        }
    }
}