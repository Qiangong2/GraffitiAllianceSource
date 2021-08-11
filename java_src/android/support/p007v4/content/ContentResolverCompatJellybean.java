package android.support.p007v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;

/* renamed from: android.support.v4.content.ContentResolverCompatJellybean */
class ContentResolverCompatJellybean {
    ContentResolverCompatJellybean() {
    }

    public static Cursor query(ContentResolver resolver, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, Object cancellationSignalObj) {
        return resolver.query(uri, projection, selection, selectionArgs, sortOrder, (CancellationSignal) cancellationSignalObj);
    }

    static boolean isFrameworkOperationCanceledException(Exception e) {
        return e instanceof OperationCanceledException;
    }
}
