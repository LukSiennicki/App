package pl.siennicki;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class TestDateTimeUtils {

    private TestDateTimeUtils() {
    }

    public static String getCurrentExpectedDate(){
        LocalDate aktualnaData = LocalDate.now();
        if(aktualnaData.getDayOfWeek() == DayOfWeek.SATURDAY){
            aktualnaData = aktualnaData.minusDays(1);
        } else if (aktualnaData.getDayOfWeek() == DayOfWeek.SUNDAY){
            aktualnaData = aktualnaData.minusDays(2);
        }

        return aktualnaData.toString();
    }
}
