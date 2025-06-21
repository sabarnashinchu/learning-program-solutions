import java.util.Scanner;

public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobile = new MobileApp("MobileApp");
        Observer web = new WebApp("WebApp");

        market.register(mobile);
        market.register(web);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter new stock price: ");
        float price1 = sc.nextFloat();
        market.setStockPrice(price1); // Both observers get updated

        market.deregister(mobile); // Deregister MobileApp

        System.out.print("Enter another stock price: ");
        float price2 = sc.nextFloat();
        market.setStockPrice(price2); // Only WebApp gets update

        sc.close();
    }
}
