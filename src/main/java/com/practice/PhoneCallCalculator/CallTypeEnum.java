package com.practice.PhoneCallCalculator;

public enum CallTypeEnum {
    LOCAL(0.02), NATIONAL(0.05);

    private double cost;

    CallTypeEnum(double cost){
        this.cost = cost;
    }

    public double calculatePrice(double minutes){
        return minutes * this.cost;
    }


}
