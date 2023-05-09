package com.api.demo.response;

public class TestResponse {

    private String id;
    private String testString;

    public TestResponse(String id, String testString) {
        this.id = id;
        this.testString = testString;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }
}
