public class BrazilianClock extends Clock {
    public BrazilianClock(int hour, int minute, int second) {
        super(hour, minute, second);
    }

    @Override
    public void setTime(Clock clock) {
        int hour = clock.getHour();

        if (clock instanceof AmericanClock ac) {
            if (ac.getDayCycle() == DayCycle.PM) {
                hour += 12;
            }
        }
        this.setHour(hour);
        this.setMinute(getMinute());
        this.setSecond(getSecond());
    }

    @Override
    public void setHour(int hour) {
        if (hour < 0) {
            throw new RuntimeException("Hora não pode ter valor negativo");
        }
        if (hour >= 24) {
            hour -= 24;
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
}
