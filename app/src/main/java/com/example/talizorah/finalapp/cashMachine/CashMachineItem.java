package com.example.talizorah.finalapp.cashMachine;

import java.util.List;

/**
 * Created by xoll on 19.04.16.
 */
public class CashMachineItem {
    private String address;
    private String place;
    private List<String> schedule;

    public CashMachineItem(){}

    public CashMachineItem(String address, String place, List<String> schedule) {
        this.address = address;
        this.place = place;
        this.schedule = schedule;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public List<String> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<String> schedule) {
        this.schedule = schedule;
    }
}
