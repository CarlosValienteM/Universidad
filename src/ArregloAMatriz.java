import java.util.*;

public class ArregloAMatriz {

    public static List<List<Integer>> convertirArregloAMatriz(int[] nums) {
        // 1. Contar la frecuencia de cada número
        Map<Integer, Integer> frecuencia = new HashMap<>();
        for (int num : nums) {
            frecuencia.put(num, frecuencia.getOrDefault(num, 0) + 1);
        }

        // 2. Crear la matriz 2D
        List<List<Integer>> matriz2D = new ArrayList<>();
        while (!frecuencia.isEmpty()) {
            List<Integer> fila = new ArrayList<>();
            Set<Integer> elementosAEliminar = new HashSet<>();
            for (Map.Entry<Integer, Integer> entry : frecuencia.entrySet()) {
                int num = entry.getKey();
                fila.add(num);
                frecuencia.put(num, frecuencia.get(num) - 1);
                if (frecuencia.get(num) == 0) {
                    elementosAEliminar.add(num);
                }
            }
            matriz2D.add(fila);

            // 3. Eliminar los números que ya se agregaron a una fila
            for (int num : elementosAEliminar) {
                frecuencia.remove(num);
            }
        }

        return matriz2D;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 1, 2, 3, 1};
        List<List<Integer>> matrizResultante = convertirArregloAMatriz(nums);
        System.out.println(matrizResultante);
    }
}