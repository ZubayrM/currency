package currency;

import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class Currency {

    private static Pattern pattern = Pattern.compile("\\d+\\.+\\d{4}");

    @SneakyThrows
    public static void main(String[] args) {
        String resources = "https://www.cbr.ru/";
        Document document = Jsoup.connect(resources).maxBodySize(0).get();
        String path = "indicator_el_value mono-num";
        Elements elementsByAttribute = document.getElementsByClass(path);

        double dollarSale = getResult(elementsByAttribute, 0);
        double dollarPurchase = getResult(elementsByAttribute, 1);
        double euroSale = getResult(elementsByAttribute, 2);
        double euroPurchase = getResult(elementsByAttribute, 3);


        SpringApplication.run(Currency.class, args);


    }


    private static double getResult(Elements elementsByAttribute, int index) {
        String e = elementsByAttribute.get(index).text();
        e = e.replace(",", ".");
        Matcher matcher = pattern.matcher(e);
        if (matcher.find()) {
            return Double.parseDouble(e.substring(matcher.start(), matcher.end()));
        }
        return 0;
    }

}
