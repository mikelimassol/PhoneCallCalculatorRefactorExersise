package com.practice.PhoneCallCalculator;

public interface PhoneCallCalculator {

    void calculateAndBillPhoneCall(String phoneNumber, int durationInSeconds, CallTypeEnum callType);

    double calculatePhoneCall(Integer durationInSecondes, CallTypeEnum callType);
}
