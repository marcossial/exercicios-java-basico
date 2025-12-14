public class AmericanClock extends Clock {
    private DayCycle dayCycle;
    public AmericanClock(int hour, int minute, int second) {
        super(hour, minute, second);
        setDayCycle(hour);
    }

    @Override
    public void setTime(Clock clock) {
        this.setHour(clock.getHour());
        this.setMinute(clock.getMinute());
        this.setSecond(clock.getSecond());
        this.setDayCycle(clock.getHour());
    }

    public DayCycle getDayCycle() {
        return dayCycle;
    }

    public void setDayCycle(int hour) {
        this.dayCycle = hour >= 12 ? DayCycle.PM : DayCycle.AM;
    }

    @Override
    public String toString() {
        int newHour = getHour();
        if (newHour != 12) {
            newHour = newHour % 12;
        }
        return String.format("%02d:%02d:%02d%s", newHour, getMinute(), getSecond(), getDayCycle());
    }
}
