package currency;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.regex.Pattern;

@SpringBootApplication
public class Currency {

    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(Currency.class, args);
    }


}
