public class WebApp implements Observer {
    private String appName;

    public WebApp(String name) {
        this.appName = name;
    }

    @Override
    public void update(float price) {
        System.out.println(appName + " - Stock Price Updated: ₹" + price);
    }
}
