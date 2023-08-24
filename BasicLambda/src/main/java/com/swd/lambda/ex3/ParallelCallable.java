package com.swd.lambda.ex3;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ParallelCallable {

    public static int[] numbers = IntStream.rangeClosed(1,1000).toArray();
    public static int sumResult = IntStream.rangeClosed(1,1000).sum();


    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Callable<Integer> firstHalf = () -> {
            int sum = 0;

            for(int i=0;i < numbers.length/2;i++)
                sum += numbers[i];

            return sum;
        };

        Callable<Integer> secondtHalf = () -> {
            int sum = 0;

            for(int i=numbers.length/2;i < numbers.length;i++)
                sum += numbers[i];

            return sum;
        };

        List<Callable<Integer>> calls = Arrays.asList(firstHalf, secondtHalf);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<Integer>> results = executorService.invokeAll(calls);

        int k=0;
        int s=0;
        for(Future<Integer> f : results){
            System.out.println("The result of the call " + ++k + " is: " + f.get() );
            s += f.get();
        }

        System.out.println("The result should be: " + sumResult);
        System.out.println("The result was: " + s);
        executorService.shutdown();
    }

}
