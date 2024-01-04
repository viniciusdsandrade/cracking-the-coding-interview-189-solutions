import java.util.ArrayList;
import java.util.List;

public class _1_2_check_permutation {
    public static void main(String[] args) {

        testCheckPermutation("abcde", "edcba");
        testCheckPermutation("hello", "olleh");
        testCheckPermutation("apple", "papel");
        testCheckPermutation("kite", "eikt");
        testCheckPermutation("padle", "eldd");
        testCheckPermutation("abcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()_+", "abcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()_+");
        testCheckPermutation("ViníciusDosSantosAndrade", "ViníciusDosSantosAndrade");
    }

    public static boolean checkPermutation(String str1, String str2) {
        // Se elas não tiverem o mesmo tamanho, não são permutações
        if (str1.length() != str2.length()) return false;

        int[] letters = new int[256];

        // Conta a quantidade de cada caractere em str1
        for (int i = 0; i < str1.length(); i++) {
            letters[str1.charAt(i)]++;
        }

        // Decrementa a quantidade de cada caractere em str2
        for (int i = 0; i < str2.length(); i++) {
            letters[str2.charAt(i)]--;
            if (letters[str2.charAt(i)] < 0) {
                return false;
            }
        }

        // Se todos os valores do array forem 0, então são permutações
        return true;
    }

    public static void testCheckPermutation(String str1, String str2) {

        System.out.println("\nInput: " + str1 + ", " + str2);

        long startTime = System.nanoTime();
        boolean result = checkPermutation(str1, str2);
        long endTime = System.nanoTime();

        System.out.println("checkPermutation: " + result);
        System.out.println("Time: " + (endTime - startTime) + " ns");
        System.out.printf("Time: %.5f ms\n", (endTime - startTime) / 1_000_000.0);
    }
}
