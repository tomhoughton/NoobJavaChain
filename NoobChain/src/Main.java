
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String myHash = BlockIDUtil.applySHA256("my name is tome");

        System.out.println("my hash");
        System.out.println(myHash);
    }
}