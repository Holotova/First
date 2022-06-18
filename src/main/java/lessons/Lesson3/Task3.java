package lessons.Lesson3;

public class Task3 {
    public static void main(String[] args) {
        String text = "aabbccdddeeeea";
        System.out.println(calcSymbolAmount(text, 'a'));
        System.out.println(calcSymbolAmount(text, 'e'));
        System.out.println(calcSymbolAmount(text, '5'));

    }

    private static int calcSymbolAmount(String text, char symbol) {
        int amount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == symbol) {
                amount++;
            }
        }
        return amount;
    }
}
