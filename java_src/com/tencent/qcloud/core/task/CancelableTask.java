package com.tencent.qcloud.core.task;

import com.tencent.qcloud.core.logger.QCloudLogger;

public abstract class CancelableTask<T> extends Task<T> {
    private boolean canceled;

    /* access modifiers changed from: protected */
    public abstract boolean onCancel();

    public CancelableTask(String identifier, Object tag) {
        super(identifier, tag);
    }

    @Override // com.tencent.qcloud.core.task.Task
    public void run() {
        if (!isCanceled()) {
            super.run();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.qcloud.core.task.Task
    public void onProgress(long complete, long target) {
        if (!isCanceled()) {
            super.onProgress(complete, target);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.qcloud.core.task.Task
    public void onSuccess() {
        if (!isCanceled()) {
            super.onSuccess();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.qcloud.core.task.Task
    public void onFailure() {
        if (!isCanceled()) {
            super.onFailure();
        }
    }

    public synchronized boolean isCanceled() {
        return this.canceled;
    }

    public final synchronized void cancel() {
        if (!this.canceled && !this.completed && onCancel()) {
            if (this.workerExecutor != null) {
                this.workerExecutor.remove(this);
            }
            close();
            this.canceled = true;
            QCloudLogger.m4893d("QCloudTask", "[Call] %s cancel", this);
        }
    }
}
