package main.dtos;

import main.models.RequestStatus;
import main.models.Token;

public class IssueTokenResponseDTO {
    private Token token;
    private RequestStatus requestStatus;

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    private String failureMessage;

}
