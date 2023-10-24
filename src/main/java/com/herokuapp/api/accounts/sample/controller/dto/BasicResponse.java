package com.herokuapp.api.accounts.sample.controller.dto;

public abstract class BasicResponse {
    public static <T> BasicResponse withAttributes(T res) {
        return new BasicResponse() {
            public T getAttributes() {
                return res;
            }
        };
    }
}
