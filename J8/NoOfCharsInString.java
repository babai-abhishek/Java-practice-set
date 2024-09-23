package J8;

public class NoOfCharsInString {
    public static void main(String[] args) {
        String s1= "Welcome to Noteshacker ";
        long count = s1.replaceAll("\\s+","").toLowerCase()
                .chars().count();
        System.out.println("Char count "+count);
    }
}
