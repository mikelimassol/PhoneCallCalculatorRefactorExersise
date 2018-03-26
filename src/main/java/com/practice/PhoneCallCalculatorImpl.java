package com.practice;

public class PhoneCallCalculatorImpl implements PhoneCallCalculator {

    /**
     * Local phone calls cost 2p per minutes
     * National phone calls cost 5p per minute
     * Calls longer than 10 minutes get 10 percent discount
     *
     * @param phoneNumber
     * @param durationInSeconds
     * @param callType
     */
    public void calculateAndBillPhoneCall(String phoneNumber, int durationInSeconds, CallTypeEnum callType) {

        double price = -1;

        int minutes = durationInSeconds/60;

        switch(callType) {
            case LOCAL:
                price = minutes * 0.02;
            case NATIONAL:
                price = minutes * 0.05;
        }

            if(minutes > 10)
              price = price / 0.9;

        try{
            BillCustomerService billCustomerService = BillCustomerService.connect();
            billCustomerService.chargePhoneCall(phoneNumber, price);
        } catch(Exception ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args){

        PhoneCallCalculator phoneCallCalculator = new PhoneCallCalculatorImpl();

        phoneCallCalculator.calculateAndBillPhoneCall("123123123", 1200, CallTypeEnum.LOCAL);



    }

}
