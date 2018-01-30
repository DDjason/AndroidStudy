package com.jason.firework.rxjavastudy;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2018/1/29$ 16:57$
 * <p/>
 */
public class ReadMeTest {
    public static void testHelloWorld(String... names){
        Flowable.just("Hello World").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        });

        Observable.fromArray(names).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("Hello "+ s + "!");
            }
        });

    }

    public static void testCommonUse() throws Exception{
        Flowable.fromCallable(() -> {
            Thread.sleep(1000); //  imitate expensive computation
            return "Done";
        })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(System.out::println, Throwable::printStackTrace);

        Thread.sleep(2000); // <--- wait for the flow to finish
    }

    public static void testCommonUseOne()throws Exception{
        //源
        Flowable<String> source = Flowable.fromCallable(()-> {
            Thread.sleep(1000);
            return "Done";
        });
        //运行线程
        Flowable<String> runBackGround = source.subscribeOn(Schedulers.io());

        //展示前台
        Flowable<String> showForeGround = runBackGround.observeOn(Schedulers.single());

        //前台操作
        showForeGround.subscribe(System.out::println,Throwable::printStackTrace);

        Thread.sleep(2000);

    }

    public static void testFlows(){
        Flowable.range(1,10)
                .observeOn(Schedulers.computation())
                .map(v-> v*v)
                .blockingSubscribe(System.out::println);
    }

    public static void testFlowsOne(){
        Flowable.range(1,10)
                .flatMap(v -> Flowable.just(v)
                        .subscribeOn(Schedulers.computation())
                        .map(w -> w*w))
                .blockingSubscribe(System.out::println);
    }


}
