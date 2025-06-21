public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("pic1.jpg");
        image1.display();
        System.out.println("\nSecond call:");
        image1.display();
    }
}
