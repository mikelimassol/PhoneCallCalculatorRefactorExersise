package com.practice.PhoneCallCalculator;

public interface BillCustomerService {

    void chargePhoneCall(String phoneNumber, double price);

    static BillCustomerService connect(){

        System.out.println("connecting to service .....");

        return new BillCastomerServiceImpl();
    }

}
