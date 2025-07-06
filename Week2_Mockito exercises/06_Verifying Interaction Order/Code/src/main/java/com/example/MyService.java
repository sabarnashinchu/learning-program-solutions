package com.example;

public class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public void performOperation() {
        api.connect();
        api.fetchData();
        api.disconnect();
    }
}
