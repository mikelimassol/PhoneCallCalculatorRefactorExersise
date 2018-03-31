package com.practice;

import com.practice.PhoneCallCalculator.CallTypeEnum;
import com.practice.PhoneCallCalculator.PhoneCallCalculator;
import com.practice.PhoneCallCalculator.PhoneCallCalculatorImpl;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class PhoneCallCalculatorImplTest {


    private PhoneCallCalculator phoneCallCalculator = new PhoneCallCalculatorImpl();

    @Test
    public void calculateCost_localPhoneCallCostsTwoPencePerMinute() {
        assertThat(phoneCallCalculator.calculateCost(60, CallTypeEnum.LOCAL), is(equalTo(0.02)) );
    }

    @Test
    public void calculateCost_localPhoneCallCostsFivePencePerMinute() {
        assertThat(phoneCallCalculator.calculateCost(60, CallTypeEnum.NATIONAL), is(equalTo(0.05)) );
    }


}