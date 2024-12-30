package org.example.aoprequestloggingdemo.dto.request;

import org.example.aoprequestloggingdemo.dto.BaseRequest;


public class HelloExampleRequest extends BaseRequest {
    private String helloMessage;
    private String requestSubject;

    public HelloExampleRequest(String helloMessage, String requestSubject) {
        this.helloMessage = helloMessage;
        this.requestSubject = requestSubject;
    }

    public String getHelloMessage() {
        return helloMessage;
    }

    public void setHelloMessage(String helloMessage) {
        this.helloMessage = helloMessage;
    }

    public String getRequestSubject() {
        return requestSubject;
    }

    public void setRequestSubject(String requestSubject) {
        this.requestSubject = requestSubject;
    }

    @Override
    public String toString() {
        return "HelloExampleRequest{" +
               "helloMessage='" + helloMessage + '\'' +
               ", requestSubject='" + requestSubject + '\'' +
               '}';
    }
}
