package test.java.rxjava;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.TestScheduler;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSchedulerTest {

    private TestScheduler scheduler;
    private List<Long> result;

    @Test
    public void testEmpty() {
        scheduler = new TestScheduler();;
        result = new ArrayList<>();
        Observable.interval(1, TimeUnit.SECONDS, scheduler).take(5).subscribe(result::add);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testAfter2Seconds() {
        scheduler = new TestScheduler();;
        result = new ArrayList<>();
        Observable.interval(1, TimeUnit.SECONDS, scheduler).take(5).subscribe(result::add);

        scheduler.advanceTimeBy(2, TimeUnit.SECONDS);
        assertEquals(2, result.size());
    }

    @Test
    public void testAfter10Seconds() {
        scheduler = new TestScheduler();;
        result = new ArrayList<>();
        Disposable subscribe = Observable.interval(1, TimeUnit.SECONDS, scheduler).take(5).subscribe(result::add);

        scheduler.advanceTimeBy(10, TimeUnit.SECONDS);
        assertEquals(5, result.size());
    }
}
