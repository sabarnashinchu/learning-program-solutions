package com.example;

public class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String[] checkStatusMultipleTimes() {
        return new String[] {
            api.getStatus(),
            api.getStatus(),
            api.getStatus()
        };
    }
}
