public class AmericanClock extends Clock {
    private DayCycle dayCycle;
    public AmericanClock(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
        setDayCycle(hour >= 12 ? DayCycle.PM : DayCycle.AM);
    }

    @Override
    public void setTime(Clock clock) {
        this.setHour(clock.getHour());
        this.setMinute(clock.getMinute());
        this.setSecond(clock.getSecond());
    }

    @Override
    public void setHour(int hour) {
        if (hour < 0) {
            throw new RuntimeException("Hora não pode ter valor negativo");
        }
        if (hour == 0) {
            hour = 12;
            dayCycle = DayCycle.AM;
        }
        if (hour > 12) {
            hour = hour % 12;
            dayCycle = DayCycle.PM;
        } else {
            dayCycle = DayCycle.AM;
        }
        super.setHour(hour);
    }

    @Override
    public void setMinute(int minute) {
        if (minute < 0) {
            throw new RuntimeException("Minuto não pode ter valor negativo");
        }
        if (minute >= 60) {
            minute -= 60;
            setHour(getHour() + 1);
        }
        super.setMinute(minute);
    }

    @Override
    public void setSecond(int second) {
        if (second < 0) {
            throw new RuntimeException("Segundo não pode ter valor negativo");
        }
        if (second >= 60) {
            second -= 60;
            setMinute(getMinute() + 1);
        }
        super.setSecond(second);
    }

    public DayCycle getDayCycle() {
        return dayCycle;
    }

    public void setDayCycle(DayCycle dayCycle) {
        this.dayCycle = dayCycle;
    }

    @Override
    public String toString() {
        return super.toString() + dayCycle;
    }
}
