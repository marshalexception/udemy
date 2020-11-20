package main.java.rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.subjects.PublishSubject;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * https://www.baeldung.com/rx-java
 */
public class Introduction {

    private static Integer[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static long longResult = 0;

    private static String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
    private static String[] titles = {"title"};
    private static List<String> titleList = Arrays.asList(titles);
    private static String stringResult = "";

    private static Integer subscriberOne = 0;
    private static Integer subscriberTwo = 0;

    public static void main (String[] args) throws InterruptedException {

        // just
        Observable<String> observable = Observable.just("Hello");
        observable.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed"));

        // different methods

        // Map
        System.out.println();
        System.out.println("-----> Map");
        Observable.fromArray(letters).map(String::toUpperCase).subscribe(System.out::print);

        // FlatMap
        System.out.println();
        System.out.println("-----> FlatMap");
        Observable.just("bookA", "bookB").flatMap(s -> getTitle()).subscribe(System.out::print);

        // Scan
        System.out.println();
        System.out.println("-----> Scan");
        Observable.fromArray(letters).scan(new StringBuilder(), StringBuilder::append).subscribe(System.out::print);

        // GroupBy
        System.out.println();
        System.out.println("-----> GroupBy");
        Observable.fromArray(numbers)
                .groupBy(number -> (number % 2) == 0 ? "EVEN" : "ODD")
                .subscribe((group) -> group.subscribe((number) -> {
                    System.out.println(group.getKey() + " : " + number);
                }));

        // Filter
        System.out.println();
        System.out.println("-----> Filter");
        Observable.fromArray(numbers)
                .filter(number -> (number % 2) == 0)
                .subscribe(System.out::print);

        // DefaultIfEmpty
        System.out.println();
        System.out.println("-----> DefaultIfEmpty");
        Observable.empty().defaultIfEmpty("Observable is empty").subscribe(System.out::print);

        // TakeWhile
        System.out.println();
        System.out.println("-----> TakeWhile");
        Observable.fromArray(numbers)
                .takeWhile(number -> number < 5)
                .subscribe(System.out::print);

        // ConnectableObservable
        System.out.println();
        System.out.println("-----> ConnectableObservable");
        ConnectableObservable<Long> connectableObservable = Observable.interval(500, TimeUnit.MILLISECONDS).publish();
        connectableObservable.subscribe(l -> longResult += l);
        System.out.println("Result before connect: " + longResult);
        connectableObservable.connect();
        Thread.sleep(2000);
        System.out.println("Result after connect: " + longResult);

        // Single
        System.out.println();
        System.out.println("-----> Single");
        Single<String> single = Observable.just("Hello")
                .singleOrError()
                .doOnSuccess(string -> stringResult += string)
                .doOnError(throwable -> {
                    throw new RuntimeException("Error when creating SingleObservable: " + throwable.getMessage());
                });
        single.subscribe();
        System.out.println(stringResult);

        // Subjects
        System.out.println();
        System.out.println("-----> Subjects");
        PublishSubject<Integer> subject = PublishSubject.create();
        subject.subscribe(getFirstObserver());
        subject.onNext(1);
        subject.onNext(2);
        subject.onNext(3);
        subject.subscribe(getSecondObserver());
        subject.onNext(4);
        subject.onComplete();
        System.out.println(subscriberOne + subscriberTwo);

    }

    private static Observable<String> getTitle() {
        return Observable.fromIterable(titleList);
    }

    private static Observer<Integer> getFirstObserver() {
        return new Observer<Integer>() {

            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Integer integer) {
                subscriberOne += integer;
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("ObserverOne completed");
            }
        };
    }

    private static Observer<Integer> getSecondObserver() {
        return new Observer<Integer>() {

            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Integer integer) {
                subscriberTwo += integer;
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("ObserverTwo completed");
            }
        };
    }

}
