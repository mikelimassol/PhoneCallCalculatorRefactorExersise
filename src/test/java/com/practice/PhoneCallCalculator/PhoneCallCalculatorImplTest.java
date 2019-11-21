package com.practice.PhoneCallCalculator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PhoneCallCalculatorImplTest {

    static class BillCustomerServiceStub implements BillCustomerService{

        public double price = 0;

        @Override
        public void chargePhoneCall(String phoneNumber, double price) {
            this.price = price;
        }
    };

    BillCustomerServiceStub billCustomerService = new BillCustomerServiceStub();
    private PhoneCallCalculatorImpl phoneCallCalculator = new PhoneCallCalculatorImpl(billCustomerService);


    @Test
    public void calculateMinutesFromSeconds(){
       double minutes = phoneCallCalculator.calculateMinutes(60);
       assertThat(minutes, is(1D));
    }

    @Test
    public void calculatePriceWhenCallTypeIsLocal(){
        double minutes = 1;
        double price = phoneCallCalculator.calculateCost(minutes, CallTypeEnum.LOCAL);
        assertThat(price, is(0.02));
    }


    @Test
    public void calculatePriceWhenCallTypeIsNational(){
        double minutes = 20;
        double price = phoneCallCalculator.calculateCost(minutes, CallTypeEnum.NATIONAL);
        assertThat(price, is(1D));
    }


    @Test
    public void calculateDiscount(){
        double minutes = 20;
        double price = 1.0;
        double discountedPrice = phoneCallCalculator.calculateDiscount(minutes, price);
        assertThat(discountedPrice, is(0.90));
    }

    @Test
    public void calculateAndBillPhoneCall_calculatePriceWhenCallTypeIsNational(){
        phoneCallCalculator.calculateAndBillPhoneCall("123123123", 1200, CallTypeEnum.NATIONAL);
        assertThat(billCustomerService.price, is(0.90));
    }



}