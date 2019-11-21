package com.practice.PhoneCallCalculator;

public enum CallTypeEnum {

    LOCAL(0.02), NATIONAL(0.05);

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    double cost;

    CallTypeEnum(double cost){
        this.cost = cost;
    }


}
