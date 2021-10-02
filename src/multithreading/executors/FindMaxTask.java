package executors;

import java.util.concurrent.Callable;

public class FindMaxTask implements Callable<Integer> {

    private final int[] data;
    private final int start;
    private final int end;

    FindMaxTask(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            int element = data[i];
            if (element > max) {
                max = element;
            }
        }
        return max;
    }
}
