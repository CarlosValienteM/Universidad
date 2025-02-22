import java.util.*;

public class GroupingPeople {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        Map<Integer, List<Integer>> groupsBySize = new HashMap<>();

        // Organizar personas por tamaño de grupo deseado
        for (int i = 0; i < n; i++) {
            int size = groupSizes[i];
            groupsBySize.computeIfAbsent(size, k -> new ArrayList<>()).add(i);
        }

        List<List<Integer>> result = new ArrayList<>();

        // Construir grupos
        for (Map.Entry<Integer, List<Integer>> entry : groupsBySize.entrySet()) {
            int size = entry.getKey();
            List<Integer> people = entry.getValue();
            for (int i = 0; i < people.size(); i += size) {
                result.add(people.subList(i, Math.min(i + size, people.size())));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        GroupingPeople gp = new GroupingPeople();
        int[] groupSizes = {2, 1, 3, 2, 1, 3, 1};
        List<List<Integer>> result = gp.groupThePeople(groupSizes);

        // Imprimir el resultado (para verificar)
        for (List<Integer> group : result) {
            System.out.println(group);
        }
    }
}