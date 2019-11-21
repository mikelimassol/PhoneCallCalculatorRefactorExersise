package com.practice.PhoneCallCalculator;

public class PhoneCallCalculatorImpl implements PhoneCallCalculator {

    private  BillCustomerService billCustomerService;

    public PhoneCallCalculatorImpl() {
        BillCustomerService.connect();
    }


    public PhoneCallCalculatorImpl(BillCustomerService billCustomerService) {
        this.billCustomerService = billCustomerService;
    }

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

        double minutes = this.calculateMinutes(durationInSeconds);
        double price = this.calculateCost(minutes, callType);
        price = this.calculateDiscount(minutes, price);

        try{
            billCustomerService.chargePhoneCall(phoneNumber, price);
        } catch(Exception ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args){

        PhoneCallCalculator phoneCallCalculator = new PhoneCallCalculatorImpl();

        phoneCallCalculator.calculateAndBillPhoneCall("123123123", 1200, CallTypeEnum.LOCAL);

    }

    double calculateMinutes(int durationInSeconds) {
        return durationInSeconds/60;
    }

    double calculateCost(double minutes, CallTypeEnum callType) {
        return callType.calculatePrice(minutes);
    }

    double calculateDiscount(double minutes, double price) {
        if(minutes > 10)
            price = price * 0.9;

        return price;
    }
}
