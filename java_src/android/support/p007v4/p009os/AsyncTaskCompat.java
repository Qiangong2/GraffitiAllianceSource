package android.support.p007v4.p009os;

import android.os.AsyncTask;
import android.os.Build;

/* renamed from: android.support.v4.os.AsyncTaskCompat */
public class AsyncTaskCompat {
    public static <Params, Progress, Result> AsyncTask<Params, Progress, Result> executeParallel(AsyncTask<Params, Progress, Result> task, Params... params) {
        if (task == null) {
            throw new IllegalArgumentException("task can not be null");
        }
        if (Build.VERSION.SDK_INT >= 11) {
            AsyncTaskCompatHoneycomb.executeParallel(task, params);
        } else {
            task.execute(params);
        }
        return task;
    }
}
