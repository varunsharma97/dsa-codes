package main.java.recursion;

public class StringPermutation {
    static void printStringPermutation(String str, int index) {
        if (str.length() == index) System.out.println(str);
        for (int i = index; i < str.length(); i++) {
            str = swap(str, index, i);
            printStringPermutation(str, index + 1);
            str = swap(str, i, index);
        }
    }

    static String swap(String str, int i, int j) {
        char[] strCharArray = str.toCharArray();
        char temp = strCharArray[i];
        strCharArray[i] = strCharArray[j];
        strCharArray[j] = temp;
        return String.copyValueOf(strCharArray);
    }

    public static void main(String[] args) {
        String inputString = "ABCDEF";
        printStringPermutation(inputString, 0);
    }
}
