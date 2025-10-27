package mergeSort;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    static void main() throws ExecutionException, InterruptedException {
        List<Integer> list = List.of(43,4,3,25,2,1,4,7,99);

        ExecutorService executorService = Executors.newCachedThreadPool();
        Sorter mainSorterTask = new Sorter(list,executorService);

        //submit the main task and get the final result
        Future<List<Integer>>sortedListFuture = executorService.submit(mainSorterTask);

        List<Integer>sortedList = sortedListFuture.get();

        System.out.println("Original list: "+list);
        System.out.println("Sorted list: "+sortedList);

        executorService.shutdown();
    }
}
