package hdss.io;

import java.util.List;

public class DailyIrrigationSchedulePublicData {

    private String myDay;
    private List<HourlyIrrigationSchedulePublicData> schedule;

    public DailyIrrigationSchedulePublicData(String day) {
        myDay = day;
        schedule = null;
    }

    public String getMyDay() {
        return myDay;
    }

    public List<HourlyIrrigationSchedulePublicData> getSchedule() {
        return schedule;
    }

}
