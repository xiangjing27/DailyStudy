package concurrent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author xiangjing
 * @version : BeeperScheduleControl, v 0.1 2020-11-10 10:56 xiangjing Exp$
 */
public class BeeperScheduleControl {
    public static void main(String[] args) {
        final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);

        final Runnable beeper = () -> System.out.println( LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)+" beep");

        final ScheduledFuture<?> beeperHandle =
            scheduler.scheduleAtFixedRate(beeper, 10, 10, SECONDS);


        //scheduler.schedule(() -> { beeperHandle.cancel(true); }, 1 * 60, SECONDS);
    }
}
