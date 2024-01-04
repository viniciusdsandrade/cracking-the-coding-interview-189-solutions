import java.util.ArrayList;
import java.util.List;

public class _1_1_Is_Unique {

    /*

     1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
     cannot use additional data structures?

     */
    public static void main(String[] args) {

        testIsUnique("abcde");
        testIsUnique("hello");
        testIsUnique("apple");
        testIsUnique("kite");
        testIsUnique("padle");
        testIsUnique("abcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()_+");
        testIsUnique("ViníciusDosSantosAndrade");


        testIsUnique2("abcde");
        testIsUnique2("hello");
        testIsUnique2("apple");
        testIsUnique2("kite");
        testIsUnique2("padle");
        testIsUnique2("abcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()_+");
        testIsUnique2("ViníciusDosSantosAndrade");
    }

    public static boolean isUnique(String str) {
        if (str.length() > 256) return false;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (list.contains(val)) {
                return false;
            }
            list.add(val);
        }
        return true;
    }

    public static boolean isUnique2(String str) {
        // assume that the string is using ASCII
        if (str.length() > 128) return false;
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i); // get the ASCII value of the character
            if ((checker & (1 << val)) > 0) { // if the character is already in the array
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    public static void testIsUnique(String str) {

        System.out.println("\nInput: " + str);

        long startTime = System.nanoTime();
        boolean result = isUnique(str);
        long endTime = System.nanoTime();

        System.out.println("isUnique: " + result);
        System.out.println("Time: " + (endTime - startTime) + " ns");
        System.out.printf("Time: %.5f ms\n", (endTime - startTime) / 1_000_000.0);
    }

    public static void testIsUnique2(String str) {

        System.out.println("\nInput: " + str);
        long startTime = System.nanoTime();
        boolean result = isUnique2(str);
        long endTime = System.nanoTime();
        System.out.println("isUnique2: " + result);
        System.out.println("Time: " + (endTime - startTime) + " ns");
        System.out.printf("Time: %.5f ms\n", (endTime - startTime) / 1_000_000.0);
    }
}