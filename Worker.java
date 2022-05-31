public class Worker {

    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 33)
                error(i);
            else
                callback.onDone("Task " + i + " is done");
        }
    }

    public void error(int i) {
        errorCallback.onError("Task " + i + " is not done");
    }
}
