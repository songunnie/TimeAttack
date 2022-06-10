package com.example.java0603;

public class RouteTable {
    private Long id;
    private Long gateway;
    private Long[] subnet;

    public RouteTable() {
    }

    public RouteTable(Long id, Long gateway, Long[] subnet) {
        this.id = id;
        this.gateway = gateway;
        this.subnet = subnet;
    }
}
