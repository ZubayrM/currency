package currency.Beans;

import currency.Curs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class CurrencyBeans {

    @Bean
    public Curs getCurs(){
        return new Curs("https://www.cbr.ru/");
    }


}
