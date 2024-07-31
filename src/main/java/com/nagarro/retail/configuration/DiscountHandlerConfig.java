package com.nagarro.retail.configuration;

import com.nagarro.retail.discount.chain.DiscountHandler;
import com.nagarro.retail.discount.chain.FlatDiscountHandler;
import com.nagarro.retail.discount.chain.PercentageDiscountHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiscountHandlerConfig {


    @Bean
    public PercentageDiscountHandler percentageDiscountHandler(){
        return new PercentageDiscountHandler();
    }
    @Bean
    public FlatDiscountHandler flatDiscountHandler(){
        return new FlatDiscountHandler();
    }


    @Bean
    public DiscountHandler discountHandlerChain(PercentageDiscountHandler percentageDiscountHandler,
                                                FlatDiscountHandler flatDiscountHandler) {
        percentageDiscountHandler.nextHandler(flatDiscountHandler);
        return percentageDiscountHandler;
    }
}
