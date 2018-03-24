package com.practice;

public interface BillCustomerService {

    void chargePhoneCall(String phoneNumber, double price);

    static BillCustomerService connect(){

        System.out.println("connecting to service .....");

        return new BillCastomerServiceImpl();
    }

}
