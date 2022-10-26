package Demo2;

public class TCP2 {
    public static void main(String[] args) {
        TCP1 tcp1 = new TCP1();
        try {
            tcp1.client();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
