package basic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author xiangjing
 * @version : LocalDateTest, v 0.1 2020-08-19 10:51 xiangjing Exp$
 */
public class LocalDateTest {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.parse("2020-08-19");
        System.out.println(localDate.getYear() + "." + localDate.getMonth().getValue() + "." + localDate.getDayOfMonth());
    }
}
