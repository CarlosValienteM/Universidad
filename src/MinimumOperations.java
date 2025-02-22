import java.util.Arrays;

public class MinimumOperations {

    public static int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (boxes.charAt(j) == '1') {
                    answer[i] += Math.abs(i - j);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String boxes = "1110";
        int[] result = minOperations(boxes);
        System.out.println(Arrays.toString(result)); 
    }
}