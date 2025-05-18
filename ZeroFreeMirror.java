import java.util.*;

public class ZeroFreeMirror {
    public static boolean isPalindrome(ArrayList<Integer> newArr) {
        int left = 0;
        int right = newArr.size() - 1;

        while (left < right) {
            if (!newArr.get(left).equals(newArr.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String formatArray(ArrayList<Integer> newArr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < newArr.size(); i++) {
            sb.append(newArr.get(i));
            // this will check if the current element is not the last element of the array.
            if (i != newArr.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array");
        int arraySize = sc.nextInt();
        sc.nextLine();

        if (arraySize < 0) {
            System.out.println(arraySize + " is an invalid array size");
            return;
        }

        System.out.println("Enter the elements of the array");
        String inputLine = sc.nextLine();
        String input[] = inputLine.split(" ");

        int arr[] = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        ArrayList<Integer> newArr = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                newArr.add(arr[i]);
            }
        }

        if (isPalindrome(newArr)) {
            System.out.println(formatArray(newArr) + " is a palindrome array");
        } else {
            System.out.println(inputLine + " is not a palindrome array");
        }
    }
}