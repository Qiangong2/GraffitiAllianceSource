package com.tencent.qcloud.core.task;

import com.tencent.qcloud.core.logger.QCloudLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class TaskManager {
    static final String TASK_LOG_TAG = "QCloudTask";
    private static volatile TaskManager instance;
    private Map<String, Task> taskPool = new ConcurrentHashMap(30);

    public static TaskManager getInstance() {
        if (instance == null) {
            synchronized (TaskManager.class) {
                if (instance == null) {
                    instance = new TaskManager();
                }
            }
        }
        return instance;
    }

    private TaskManager() {
    }

    /* access modifiers changed from: package-private */
    public void add(Task task) {
        this.taskPool.put(task.getIdentifier(), task);
        QCloudLogger.m4893d(TASK_LOG_TAG, "[Pool] ADD %s, %d cached", task.getIdentifier(), Integer.valueOf(this.taskPool.size()));
    }

    /* access modifiers changed from: package-private */
    public void remove(Task task) {
        if (this.taskPool.remove(task.getIdentifier()) != null) {
            QCloudLogger.m4893d(TASK_LOG_TAG, "[Pool] REMOVE %s, %d cached", task.getIdentifier(), Integer.valueOf(this.taskPool.size()));
        }
    }

    public Task get(String identifier) {
        return this.taskPool.get(identifier);
    }

    public List<Task> snapshot() {
        return new ArrayList(this.taskPool.values());
    }

    /* access modifiers changed from: package-private */
    public void evict() {
        QCloudLogger.m4893d(TASK_LOG_TAG, "[Pool] CLEAR %d", Integer.valueOf(this.taskPool.size()));
        this.taskPool.clear();
    }
}
