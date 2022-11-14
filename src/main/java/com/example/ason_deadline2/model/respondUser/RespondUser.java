package com.example.ason_deadline2.model.respondUser;

import lombok.Data;

@Data
public class RespondUser {
    private String message;
    private Object data;
    private Number totalPage;
    private Number totalElement;
    private  Number activePage;

    public RespondUser(String message, Object data, Number totalPage, Number totalElement, Number activePage) {
        this.message = message;
        this.data = data;
        this.totalPage = totalPage;
        this.totalElement = totalElement;
        this.activePage = activePage;
    }

    public RespondUser(String message) {
        this.message = message;

    }


}
