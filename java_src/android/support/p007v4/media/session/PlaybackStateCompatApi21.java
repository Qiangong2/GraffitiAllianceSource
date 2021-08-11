package android.support.p007v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;

/* access modifiers changed from: package-private */
/* renamed from: android.support.v4.media.session.PlaybackStateCompatApi21 */
public class PlaybackStateCompatApi21 {
    PlaybackStateCompatApi21() {
    }

    public static int getState(Object stateObj) {
        return ((PlaybackState) stateObj).getState();
    }

    public static long getPosition(Object stateObj) {
        return ((PlaybackState) stateObj).getPosition();
    }

    public static long getBufferedPosition(Object stateObj) {
        return ((PlaybackState) stateObj).getBufferedPosition();
    }

    public static float getPlaybackSpeed(Object stateObj) {
        return ((PlaybackState) stateObj).getPlaybackSpeed();
    }

    public static long getActions(Object stateObj) {
        return ((PlaybackState) stateObj).getActions();
    }

    public static CharSequence getErrorMessage(Object stateObj) {
        return ((PlaybackState) stateObj).getErrorMessage();
    }

    public static long getLastPositionUpdateTime(Object stateObj) {
        return ((PlaybackState) stateObj).getLastPositionUpdateTime();
    }

    public static List<Object> getCustomActions(Object stateObj) {
        return ((PlaybackState) stateObj).getCustomActions();
    }

    public static long getActiveQueueItemId(Object stateObj) {
        return ((PlaybackState) stateObj).getActiveQueueItemId();
    }

    public static Object newInstance(int state, long position, long bufferedPosition, float speed, long actions, CharSequence errorMessage, long updateTime, List<Object> customActions, long activeItemId) {
        PlaybackState.Builder stateObj = new PlaybackState.Builder();
        stateObj.setState(state, position, speed, updateTime);
        stateObj.setBufferedPosition(bufferedPosition);
        stateObj.setActions(actions);
        stateObj.setErrorMessage(errorMessage);
        Iterator i$ = customActions.iterator();
        while (i$.hasNext()) {
            stateObj.addCustomAction((PlaybackState.CustomAction) i$.next());
        }
        stateObj.setActiveQueueItemId(activeItemId);
        return stateObj.build();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: android.support.v4.media.session.PlaybackStateCompatApi21$CustomAction */
    public static final class CustomAction {
        CustomAction() {
        }

        public static String getAction(Object customActionObj) {
            return ((PlaybackState.CustomAction) customActionObj).getAction();
        }

        public static CharSequence getName(Object customActionObj) {
            return ((PlaybackState.CustomAction) customActionObj).getName();
        }

        public static int getIcon(Object customActionObj) {
            return ((PlaybackState.CustomAction) customActionObj).getIcon();
        }

        public static Bundle getExtras(Object customActionObj) {
            return ((PlaybackState.CustomAction) customActionObj).getExtras();
        }

        public static Object newInstance(String action, CharSequence name, int icon, Bundle extras) {
            PlaybackState.CustomAction.Builder customActionObj = new PlaybackState.CustomAction.Builder(action, name, icon);
            customActionObj.setExtras(extras);
            return customActionObj.build();
        }
    }
}
