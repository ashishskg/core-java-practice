package com.ashish.java.java8.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class App00CompletableFutureMethods {

    public static void main(String[] args) {

        // 1. runAsync(): runs without result
        CompletableFuture<Void> runTask = CompletableFuture.runAsync(() -> {
            System.out.println("runAsync -> Task executed");
        });
        runTask.join();

        // 2. supplyAsync(): runs with result
        CompletableFuture<String> supplyTask = CompletableFuture.supplyAsync(() -> {
            return "Hello from supplyAsync";
        });
        System.out.println(supplyTask.join());

        // 3. thenApply(): transform result
        CompletableFuture<Integer> lengthTask = supplyTask.thenApply(String::length);
        System.out.println("thenApply -> Length = " + lengthTask.join());

        // 4. thenAccept(): consume result, no return
        lengthTask.thenAccept(len -> System.out.println("thenAccept -> Length printed: " + len)).join();

        // 5. thenRun(): run something after completion, no input or output
        lengthTask.thenRun(() -> System.out.println("thenRun -> Task finished")).join();

        // 6. thenCombine(): combine two futures results
        CompletableFuture<Integer> price1 = CompletableFuture.supplyAsync(() -> 100);
        CompletableFuture<Integer> price2 = CompletableFuture.supplyAsync(() -> 80);
        CompletableFuture<Integer> bestPrice = price1.thenCombine(price2, Integer::min);
        System.out.println("thenCombine -> Best price = " + bestPrice.join());

        // 7. thenCompose(): chain dependent futures
        CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(() -> "Ashish");
        CompletableFuture<String> greeting = userFuture.thenCompose(name ->
                CompletableFuture.supplyAsync(() -> "Hello " + name));
        System.out.println("thenCompose -> " + greeting.join());

        // 8. allOf(): wait for all futures
        CompletableFuture<Void> all = CompletableFuture.allOf(price1, price2, bestPrice);
        all.join();
        System.out.println("allOf -> All tasks completed");

        // 9. anyOf(): wait for first future
        CompletableFuture<Object> any = CompletableFuture.anyOf(price1, price2);
        System.out.println("anyOf -> First completed = " + any.join());

        // 10. exceptionally(): handle exception
        CompletableFuture<String> errorFuture = CompletableFuture.supplyAsync(() -> {
            if (true) throw new RuntimeException("Oops!");
            return "Success";
        }).exceptionally(ex -> "Handled error: " + ex.getMessage());
        System.out.println("exceptionally -> " + errorFuture.join());

        // 11. handle(): process result or error
        CompletableFuture<String> handleFuture = CompletableFuture.supplyAsync(() -> {
            if (true) throw new RuntimeException("Boom!");
            return "OK";
        }).handle((result, ex) -> ex != null ? "Recovered: " + ex.getMessage() : result);
        System.out.println("handle -> " + handleFuture.join());

        // 12. complete(): manually complete a future
        CompletableFuture<String> manual = new CompletableFuture<>();
        manual.complete("Manually completed");
        System.out.println("complete -> " + manual.join());

        // 13. completeExceptionally(): manually fail a future
        CompletableFuture<String> failed = new CompletableFuture<>();
        failed.completeExceptionally(new RuntimeException("Manual error"));
        try {
            System.out.println(failed.join());
        } catch (Exception e) {
            System.out.println("completeExceptionally -> " + e.getMessage());
        }

        // 14. orTimeout(): auto-fail after timeout
        CompletableFuture<String> timeoutFuture = CompletableFuture.supplyAsync(() -> {
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) {}
            return "Finished";
        }).orTimeout(1, TimeUnit.SECONDS).exceptionally(ex -> "Timeout occurred");
        System.out.println("orTimeout -> " + timeoutFuture.join());

        // 15. completeOnTimeout(): fallback if timeout
        CompletableFuture<String> timeoutFallback = CompletableFuture.supplyAsync(() -> {
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) {}
            return "Finished";
        }).completeOnTimeout("Default Value", 1, TimeUnit.SECONDS);
        System.out.println("completeOnTimeout -> " + timeoutFallback.join());
    }
}

/*
| Method                                        | Returns                     | Description                                             | Example Usage                                                   |
| --------------------------------------------- | --------------------------- | ------------------------------------------------------- | --------------------------------------------------------------- |
| `runAsync(Runnable)`                          | `CompletableFuture<Void>`   | Runs a task asynchronously without returning a result.  | `CompletableFuture.runAsync(() -> System.out.println("Task"));` |
| `supplyAsync(Supplier<T>)`                    | `CompletableFuture<T>`      | Runs a task asynchronously and returns a result.        | `CompletableFuture.supplyAsync(() -> 42);`                      |
| `thenApply(Function<T,R>)`                    | `CompletableFuture<R>`      | Transforms result of a future into another value.       | `future.thenApply(val -> val * 2);`                             |
| `thenAccept(Consumer<T>)`                     | `CompletableFuture<Void>`   | Consumes the result (no return).                        | `future.thenAccept(val -> System.out.println(val));`            |
| `thenRun(Runnable)`                           | `CompletableFuture<Void>`   | Runs extra code after completion, doesn’t use result.   | `future.thenRun(() -> System.out.println("Done"));`             |
| `thenCombine(future, BiFunction<T,U,R>)`      | `CompletableFuture<R>`      | Combines results of two futures.                        | `f1.thenCombine(f2, (a, b) -> a+b);`                            |
| `thenCompose(Function<T,CompletionStage<U>>)` | `CompletableFuture<U>`      | Chains dependent async tasks (flattened).               | `getUser().thenCompose(this::getOrders);`                       |
| `allOf(futures…)`                             | `CompletableFuture<Void>`   | Waits for all futures to finish.                        | `CompletableFuture.allOf(f1,f2).join();`                        |
| `anyOf(futures…)`                             | `CompletableFuture<Object>` | Returns when any one future completes.                  | `CompletableFuture.anyOf(f1,f2).join();`                        |
| `exceptionally(Function<Throwable,T>)`        | `CompletableFuture<T>`      | Handles exception and provides fallback.                | `future.exceptionally(ex -> -1);`                               |
| `handle(BiFunction<T,Throwable,R>)`           | `CompletableFuture<R>`      | Handles both result and exception.                      | `future.handle((res, ex) -> res!=null?res:0);`                  |
| `whenComplete(BiConsumer<T,Throwable>)`       | `CompletableFuture<T>`      | Runs side-effect after completion (success or failure). | `future.whenComplete((res, ex) -> log.info(res));`              |
| `complete(T value)`                           | `boolean`                   | Manually completes a future with value.                 | `future.complete("OK");`                                        |
| `completeExceptionally(Throwable)`            | `boolean`                   | Manually complete with error.                           | `future.completeExceptionally(new RuntimeException());`         |
| `orTimeout(long, TimeUnit)`                   | `CompletableFuture<T>`      | Auto-fails if not done within time.                     | `future.orTimeout(1, TimeUnit.SECONDS);`                        |
| `completeOnTimeout(T, long, TimeUnit)`        | `CompletableFuture<T>`      | Provides default value on timeout.                      | `future.completeOnTimeout("Default",1,TimeUnit.SECONDS);`       |
| `join()`                                      | `T`                         | Waits and gets result, throws unchecked exception.      | `future.join();`                                                |
| `get()`                                       | `T`                         | Waits and gets result, throws checked exceptions.       | `future.get();`                                                 |
| `getNow(T valueIfAbsent)`                     | `T`                         | Returns result if ready, else default.                  | `future.getNow(-1);`                                            |
| `isDone()`                                    | `boolean`                   | Checks if task completed.                               | `future.isDone();`                                              |
| `isCompletedExceptionally()`                  | `boolean`                   | Checks if future completed with error.                  | `future.isCompletedExceptionally();`                            |
| `cancel(boolean mayInterrupt)`                | `boolean`                   | Cancels task execution.                                 | `future.cancel(true);`                                          |


Creation → runAsync, supplyAsync

Transformation → thenApply, thenAccept, thenRun

Combination → thenCombine, thenCompose, allOf, anyOf

Error Handling → exceptionally, handle, whenComplete

Manual Control → complete, completeExceptionally

Timeouts → orTimeout, completeOnTimeout

Inspection → join, get, isDone, etc.
* */
