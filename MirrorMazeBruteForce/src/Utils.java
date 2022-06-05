import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    public static byte[] increment(byte[] A) {
        boolean carry = true;
        for (int i = (A.length - 1); i >= 0; i--) {
            if (carry) {
                if (A[i] == 0) {
                    A[i] = 1;
                    carry = false;
                }
                else {
                    A[i] = 0;
                    carry = true;
                }
            }
        }
        return A;
    }

    public char[] getStartingCombination(int length) {
        char[] b = new char[length];
         Arrays.fill(b, '0');
         return b;
    }
    // Function to generate all binary strings
    static void generateAllBinaryStrings(int n,
                                         String arr[], int i, List<String[]> allCombinations) {
        if (i == n) {
            allCombinations.add(arr.clone());
            return;
        }

        // First assign "0" at ith position
        // and try for all other permutations
        // for remaining positions
        arr[i] = "0";
        generateAllBinaryStrings(n, arr, i + 1, allCombinations);

        // And then assign "1" at ith position
        // and try for all other permutations
        // for remaining positions
        arr[i] = "1";
        generateAllBinaryStrings(n, arr, i + 1, allCombinations);
    }

    public static List<String[]> generate(int length) {
        List<String[]> all = new ArrayList<>();
        generateAllBinaryStrings(length, new String[length], 0, all);
        return all;
    }
}

