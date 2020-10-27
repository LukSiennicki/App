package pl.siennicki;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateProvider {

    private DateProvider() {

    }

    public static LocalDate getLastWorkingDate(LocalDate currentDate){
        if(currentDate == null || currentDate.isAfter(LocalDate.now())){
            currentDate = LocalDate.now();
        }
        LocalDate aktualnaData = currentDate;
        if (aktualnaData.getDayOfWeek() == DayOfWeek.SATURDAY){
            aktualnaData = aktualnaData.minusDays(1);
        } else if (aktualnaData.getDayOfWeek() == DayOfWeek.SUNDAY) {
            aktualnaData = aktualnaData.minusDays(2);
        }

        return aktualnaData;
    }

    public static String getLastWorkingDateAsString(LocalDate currentDate){
        return getLastWorkingDate(currentDate).toString();
    }
}
