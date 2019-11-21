package com.practice.PhoneCallCalculator;

public class PhoneCallCalculatorImpl implements PhoneCallCalculator {

    private BillCustomerService billCustomerService;

    public PhoneCallCalculatorImpl(){
        billCustomerService = BillCustomerService.connect();
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

        double price = calculatePhoneCall(durationInSeconds, callType);

        try{
            billCustomerService.chargePhoneCall(phoneNumber, price);
        } catch(Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public double calculatePhoneCall(Integer durationInSeconds, CallTypeEnum callType) {

        double minutes = durationInSeconds/60;

        double price = minutes * callType.getCost() ;

        price = getDisountedPrice(minutes, price);

        return price;

    }

    private double getDisountedPrice(double minutes, double price) {
        if(minutes > 10)
            price = price * 0.9;
        return price;
    }

    public static void main(String[] args){

        PhoneCallCalculator phoneCallCalculator = new PhoneCallCalculatorImpl();

        phoneCallCalculator.calculateAndBillPhoneCall("123123123", 1200, CallTypeEnum.LOCAL);

    }

}
