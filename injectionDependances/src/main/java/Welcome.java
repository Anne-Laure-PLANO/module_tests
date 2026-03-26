import horloge.Horloge;

import java.time.DayOfWeek;

public class Welcome {
    private Horloge horloge; ;


    public Welcome(Horloge horloge) {
        this.horloge = horloge;
    }

    public String getMessage() {
        DayOfWeek dayOfWeek = horloge.now().getDayOfWeek();
        int hour = horloge.now().getHour();
        if ((dayOfWeek == DayOfWeek.FRIDAY && hour >= 18)
                || dayOfWeek == DayOfWeek.SATURDAY
                || dayOfWeek == DayOfWeek.SUNDAY
                || (dayOfWeek == DayOfWeek.MONDAY && hour < 9)) {
            return "Bon week-end !";
        } else if ((hour >=9 && hour <13)){
            return "Bonjour";
        } else if ((hour >= 13 && hour < 19)) {
            return "Bon après-midi";
        } else{
            return "Bonsoir";
        }
    }
}
