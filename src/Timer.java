import java.util.concurrent.TimeUnit;

public class Timer {
    private long startTime;
    private long stopTime;

    public long start() {
        startTime = System.currentTimeMillis();
        return startTime;
    }

    public long stop() {
        stopTime = System.currentTimeMillis() ;
        return stopTime;
    }

    public long duration() {
        long duration = startTime - stopTime;
        return duration;
    }

    public long getMins() {
        return TimeUnit.MILLISECONDS.toMinutes(stopTime);
    }

    public long getSecs() {
        long secs = stopTime - getMins() * 60000L;
        return TimeUnit.MILLISECONDS.toSeconds(secs);
    }

    public long getMs() {
        return stopTime - getMins() * 60000L - getSecs() * 1000L;
    }
}
