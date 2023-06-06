import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static ArrayList<Node> graph;
    public static void main(String[] args) throws FileNotFoundException {
        setupTree();
        BFS();
    }

    private static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> visited  = new ArrayList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            Integer a = queue.remove();
            if(visited.contains(a)){
                continue;
            }
            for(Integer i : graph.get(a-1).getNodes()) {
                if (!queue.contains(i)){
                    queue.add(i);
                }
            }
            visited.add(a);
        }

        for(int i = 0 ; i < visited.size() ; i++){
            Integer element = visited.get(i);
            System.out.println(element);
        }
    }

    private static void setupTree() throws FileNotFoundException {
        graph = new ArrayList<>();
        Scanner scan = new Scanner(new File("tree.txt"));
        while(scan.hasNext()){
            String line = scan.nextLine();
            parseLine(line);
        }
    }

    private static void parseLine(String line) {
        String[] keys = line.split(" ");
        int key = Integer.parseInt(keys[0]);
        ArrayList<Integer> points = new ArrayList<>();
        for(int i = 1; i < keys.length;i++){
            points.add(Integer.parseInt(keys[i]));
        }
        graph.add(new Node(key, points));
    }
}
