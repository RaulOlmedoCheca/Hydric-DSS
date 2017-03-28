package hdss.io;

import java.util.List;

public class IrrigationDemandPublicData {

    private String watershedName;
    private List<DailyIrrigationSchedulePublicData> schedule;

    public IrrigationDemandPublicData(String name) {
        watershedName = name;
        schedule = null;
    }

    public String getWatershedName() {
        return watershedName;
    }

    public List<DailyIrrigationSchedulePublicData> getSchedule() {
        return schedule;
    }
}
