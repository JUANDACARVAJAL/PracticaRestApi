package com.lulo.utils;

public enum EndPoints {
    GET_EMPLOYEES("api/v1/employees"),
    GET_EMPLOYEE("api/v1/employee/{id}"),
    POST_CREATE("api/v1/create")

    ;

    private final String url;


    EndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
