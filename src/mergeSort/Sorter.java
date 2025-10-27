package mergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.lang.Math.*;

public class Sorter implements Callable<List<Integer>> {

    private final List<Integer> arrayToBeSorted;
    private final ExecutorService executorService;

    public Sorter(List<Integer> arrayToBeSorted,ExecutorService executorService){
        this.arrayToBeSorted=arrayToBeSorted;
        this.executorService=executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        //Base case:
        if(arrayToBeSorted.size()<=1){
            return arrayToBeSorted;
        }

        //Divide the array
        int mid= arrayToBeSorted.size()/2;
        List<Integer> left = new ArrayList<>(arrayToBeSorted.subList(0,mid));
        List<Integer> right = new ArrayList<>(arrayToBeSorted.subList(mid,arrayToBeSorted.size()));

        // 2. Create task for each half
        Sorter leftSorter = new Sorter(left,executorService);
        Sorter rightSorter = new Sorter(right,executorService);

        //Is this executing sequentially? yes
//        List<Integer>leftSorted=executorService.submit(leftSorter);
//        List<Integer>rightSorted=executorService.submit(rightSorter);
        // Submit task to executor service, future/promise will process async/parallelly
        Future<List<Integer>>leftFuture=executorService.submit(leftSorter);
        Future<List<Integer>>rightFuture=executorService.submit(rightSorter);

        // 4. wait for results and merge the two sorted array
        List<Integer> sortedLeft = leftFuture.get(); //Blocks until left half is sorted
        List<Integer> sortedRight = rightFuture.get(); // blocks until right half is sorted

        return merge(sortedLeft,sortedRight);
    }

    private List<Integer> merge(List<Integer> left,List<Integer> right){
        List<Integer> merged = new ArrayList<>();
        int i=0,j=0;
        while(i<left.size() && j<right.size()){
            if(left.get(i)<=right.get(j)){
                merged.add(left.get(i));
                i++;
            }
            else{
                merged.add(right.get(j));
                j++;
            }
        }
        while(i<left.size()){
            merged.add(left.get(i));
            i++;
        }
        while (j<right.size()){
            merged.add(right.get(j));
            j++;
        }
        return merged;
    }
}

