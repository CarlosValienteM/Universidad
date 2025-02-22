public class OrdenarPorFrecuencia {

    public static int[] ordenarPorFrecuencia(int[] nums) {
        // 1. Calcular frecuencias
        int[] frecuencias = new int[201]; // Rango de números: -100 a 100
        for (int num : nums) {
            frecuencias[num + 100]++; // Ajustar índice para evitar negativos
        }

        // 2. Crear arreglo de conteo
        int maxFrecuencia = 0;
        for (int frecuencia : frecuencias) {
            maxFrecuencia = Math.max(maxFrecuencia, frecuencia);
        }
        int[] conteo = new int[maxFrecuencia + 1];

        // 3. Llenar arreglo de conteo
        for (int num : nums) {
            int frecuencia = frecuencias[num + 100];
            conteo[frecuencia]++;
        }

        // 4. Construir arreglo resultado
        int[] resultado = new int[nums.length];
        int indice = 0;
        for (int frecuencia = conteo.length - 1; frecuencia >= 1; frecuencia--) {
            if (conteo[frecuencia] > 0) {
                for (int num : nums) {
                    if (frecuencias[num + 100] == frecuencia) {
                        for (int i = 0; i < frecuencia; i++) {
                            resultado[indice++] = num;
                        }
                        frecuencias[num + 100] = 0; // Marcar como contado
                    }
                }
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 8, 5, 2, 8, 5, 2, 8, 1, 9, 1, 9};
        int[] resultado = ordenarPorFrecuencia(nums);
        for (int num : resultado) {
            System.out.print(num + " ");
        }
        System.out.println(); // Salida:[5, 5, 5, 2, 2, 2, 8, 8, 8, 1, 1, 9, 9]
    }
}