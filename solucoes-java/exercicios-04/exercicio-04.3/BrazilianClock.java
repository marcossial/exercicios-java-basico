public class BrazilianClock extends Clock {
    public BrazilianClock(int hour, int minute, int second) {
        super(hour, minute, second);
    }

    @Override
    public void setTime(Clock clock) {
        this.setHour(getHour());
        this.setMinute(getMinute());
        this.setSecond(getSecond());
    }
}
