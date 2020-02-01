package executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadedMaxFinder {
    public static int max(int[] data) throws InterruptedException, ExecutionException {
        FindMaxTask task_1 = new FindMaxTask(data, 0, data.length / 2);
        FindMaxTask task_2 = new FindMaxTask(data, data.length / 2, data.length);

        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> future_1 = service.submit(task_1);
        Future<Integer> future_2 = service.submit(task_2);

        return Math.max(future_1.get(), future_2.get());
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 0, -4, 10050, 80, 30, 540, 38, 51, 1, -1933, 58};
        try {
            System.out.println(MultiThreadedMaxFinder.max(nums));
        } catch (InterruptedException | ExecutionException e) {
            System.err.println(e);
        }
    }
}
