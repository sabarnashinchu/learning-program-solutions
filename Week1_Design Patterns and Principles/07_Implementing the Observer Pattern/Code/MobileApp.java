public class MobileApp implements Observer {
    private String appName;

    public MobileApp(String name) {
        this.appName = name;
    }

    @Override
    public void update(float price) {
        System.out.println(appName + " - Stock Price Updated: ₹" + price);
    }
}
