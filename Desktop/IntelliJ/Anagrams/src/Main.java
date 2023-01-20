public class Main {
    public static void main(String[] args) {
        String aLower = "az";

        int[] store = new int[26];

        for (int i = 0; i < aLower.length(); i++) {
            store[aLower.charAt(i) - 'a']++;

       }
        for (int i : store) {
            System.out.println(i);
        }
    }
}