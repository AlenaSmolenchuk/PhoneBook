import java.util.concurrent.TimeUnit;

public class Timer {
    private long startTime;
    private long elapsed;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        elapsed = System.currentTimeMillis() - startTime;
    }

    public long getMins() {
        return TimeUnit.MILLISECONDS.toMinutes(elapsed);
    }

    public long getSecs() {
        long secs = elapsed - getMins() * 60000L;
        return TimeUnit.MILLISECONDS.toSeconds(secs);
    }

    public long getMs() {
        return elapsed - getMins() * 60000L - getSecs() * 1000L;
    }

}
