package com.practice.PhoneCallCalculator;

public class BillCastomerServiceImpl implements BillCustomerService {
    @Override
    public void chargePhoneCall(String phoneNumber, double price) {

        System.out.println(String.format("Charging phone number %s the amount %s", phoneNumber, price));

    }
}
