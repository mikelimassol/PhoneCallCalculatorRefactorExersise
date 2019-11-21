package com.practice;

import com.practice.PhoneCallCalculator.BillCustomerService;
import com.practice.PhoneCallCalculator.CallTypeEnum;
import com.practice.PhoneCallCalculator.PhoneCallCalculator;
import com.practice.PhoneCallCalculator.PhoneCallCalculatorImpl;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PhoneCallCalculatorImplTest {

    static class BillCustomerServiceStub implements BillCustomerService {

        public double price;

        @Override
        public void chargePhoneCall(String phoneNumber, double price) {

            this.price = price;

        }
    }

    BillCustomerServiceStub billCustomerService = new BillCustomerServiceStub();


    private  PhoneCallCalculator phoneCallCalculator = new PhoneCallCalculatorImpl(billCustomerService);


    @Test
    public void calculateAndBillPhoneCall_localPhoneCallsShouldCostTwoPencePerMinute(){
        Integer durationInSeconds = 60;
        CallTypeEnum callType = CallTypeEnum.LOCAL;
        phoneCallCalculator.calculateAndBillPhoneCall("12345", durationInSeconds, callType);
        assertThat(billCustomerService.price, equalTo(0.02));
    }


    @Test
    public void calculatePhoneCall_localPhoneCallsShouldCostTwoPencePerMinute(){
        Integer durationInSeconds = 60;
        CallTypeEnum callType = CallTypeEnum.LOCAL;
        double price = phoneCallCalculator.calculatePhoneCall(durationInSeconds, callType);
        assertThat(price, equalTo(0.02));
    }

    @Test
    public void calculatePhoneCall_localPhoneCallsShouldCostTwoPencePerMinute2(){

        Integer durationInSeconds = 180;
        CallTypeEnum callType = CallTypeEnum.LOCAL;
        double price = phoneCallCalculator.calculatePhoneCall(durationInSeconds, callType);
        assertThat(price, equalTo(0.06));

    }

    @Test
    public void calculatePhoneCall_nationalPhoneCallsShouldCostFivePencePerMinute(){
        Integer durationInSeconds = 60;
        CallTypeEnum callType = CallTypeEnum.NATIONAL;
        double price = phoneCallCalculator.calculatePhoneCall(durationInSeconds, callType);
        assertThat(price, equalTo(0.05));
    }

    @Test
    public void calculatePhoneCall_callsLongerThanTenminutesGetTenPercentDiscount(){

        Integer durationInSeconds = 1200;
        CallTypeEnum callType = CallTypeEnum.NATIONAL;
        double price = phoneCallCalculator.calculatePhoneCall(durationInSeconds, callType);
        assertThat(price, equalTo(0.90));
    }


}