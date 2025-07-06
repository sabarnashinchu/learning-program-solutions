import java.util.*;

public class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private float stockPrice;

    @Override
    public void register(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void deregister(Observer observer) {
        if (observer != null) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update(stockPrice);
        }
    }

    public void setStockPrice(float price) {
        this.stockPrice = price;
        notifyObservers();
    }
}
