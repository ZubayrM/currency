package currency;

import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Curs {

    private static Pattern pattern = Pattern.compile("\\d+\\.+\\d{4}");
    private static double dollar;
    private static double euro;

    public Curs(String url) {
        getCurs(url);
    }

    public static double getDollar() {
        return dollar;
    }

    public static double getEuro() {
        return euro;
    }

    @SneakyThrows
    private static void getCurs(String url) {
        String resources = url;
        Document document = Jsoup.connect(resources).maxBodySize(0).get();
        String path = "indicator_el_value mono-num";
        Elements elementsByAttribute = document.getElementsByClass(path);

        dollar = getResult(elementsByAttribute, 0);
        euro = getResult(elementsByAttribute, 2);
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
