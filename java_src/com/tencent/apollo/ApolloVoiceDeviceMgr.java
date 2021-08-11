package com.tencent.apollo;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.support.p007v4.app.ActivityCompat;
import android.support.p007v4.content.ContextCompat;
import android.util.Log;
import com.wanmei.push.bean.AppState;

public class ApolloVoiceDeviceMgr {
    private static AudioManager audioManager = null;
    private static boolean isUsedBlue = false;
    private static boolean isblueConnect = false;
    private static boolean mCurrVoipState = false;
    private static BroadcastReceiver mHeadSetReceiver = new BroadcastReceiver() {
        /* class com.tencent.apollo.ApolloVoiceDeviceMgr.C13091 */

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                if (intExtra == 2) {
                    boolean unused = ApolloVoiceDeviceMgr.isblueConnect = true;
                    Log.i(ApolloVoiceDeviceMgr.tag, "bluetooth connect ,cur state is " + intExtra);
                } else if (intExtra == 0) {
                    boolean unused2 = ApolloVoiceDeviceMgr.isblueConnect = false;
                    if (ApolloVoiceDeviceMgr.isUsedBlue) {
                        ApolloVoiceDeviceMgr.audioManager.stopBluetoothSco();
                        ApolloVoiceDeviceMgr.audioManager.setBluetoothScoOn(false);
                        ApolloVoiceEngine.StopBlueTooth();
                        boolean unused3 = ApolloVoiceDeviceMgr.isUsedBlue = false;
                    }
                    ApolloVoiceDeviceMgr.audioManager.setSpeakerphoneOn(ApolloVoiceDeviceMgr.mSpeakerphoneOn);
                    Log.i(ApolloVoiceDeviceMgr.tag, "bluetooth disconnect,cur state is " + intExtra);
                }
            } else if (intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
                if (intent.hasExtra(AppState.STATE)) {
                    switch (intent.getIntExtra(AppState.STATE, -1)) {
                        case 0:
                            Log.i("HeadSet Callback", "ACTION_HEADSET_PLUG Out! Mode  " + ApolloVoiceDeviceMgr.preState);
                            if (!ApolloVoiceDeviceMgr.preState) {
                                if (ApolloVoiceDeviceMgr.mSpeakerphoneOn) {
                                    ApolloVoiceDeviceMgr.audioManager.setSpeakerphoneOn(ApolloVoiceDeviceMgr.mSpeakerphoneOn);
                                    break;
                                }
                            } else {
                                ApolloVoiceDeviceMgr.ApolloVoiceDeviceEnterVoipMode(1);
                                break;
                            }
                            break;
                        case 1:
                            Log.i("HeadSet Callback", "ACTION_HEADSET_PLUG In! The currVoip Mode is " + ApolloVoiceDeviceMgr.preState);
                            if (!ApolloVoiceDeviceMgr.preState) {
                                if (ApolloVoiceDeviceMgr.mSpeakerphoneOn) {
                                    ApolloVoiceDeviceMgr.audioManager.setSpeakerphoneOn(false);
                                    break;
                                }
                            } else {
                                ApolloVoiceDeviceMgr.ApolloVoiceDeviceExitVoipMode();
                                break;
                            }
                            break;
                    }
                    Log.e("framework", "BroadcastReceiver ACTION_HEADSET_PLUG onReceive bSetValue=" + ApolloVoiceDeviceMgr.mSpeakerphoneOn);
                }
            } else if (intent.getAction().equals("android.media.ACTION_SCO_AUDIO_STATE_UPDATED")) {
                int intExtra2 = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", 0);
                Log.i(ApolloVoiceDeviceMgr.tag, "ApolloVoiceDeviceManager ::SCO cur state is " + intExtra2);
                if (intExtra2 == 1) {
                    ApolloVoiceDeviceMgr.audioManager.setBluetoothScoOn(true);
                    ApolloVoiceEngine.StartBlueTooth();
                    boolean unused4 = ApolloVoiceDeviceMgr.isUsedBlue = true;
                } else if (intExtra2 == 0) {
                    ApolloVoiceDeviceMgr.audioManager.stopBluetoothSco();
                    ApolloVoiceDeviceMgr.audioManager.setBluetoothScoOn(false);
                    if (!ApolloVoiceDeviceMgr.IsHeadSet()) {
                        ApolloVoiceDeviceMgr.audioManager.setSpeakerphoneOn(ApolloVoiceDeviceMgr.mSpeakerphoneOn);
                    }
                    if (ApolloVoiceDeviceMgr.isUsedBlue) {
                        boolean unused5 = ApolloVoiceDeviceMgr.isUsedBlue = false;
                        boolean unused6 = ApolloVoiceDeviceMgr.isblueConnect = false;
                        ApolloVoiceEngine.StopBlueTooth();
                    }
                }
            }
        }
    };
    protected static boolean mIsOpenCommuntication = false;
    protected static boolean mSpeakerphoneOn = true;
    private static BluetoothAdapter m_blueAdapt = null;
    private static Activity mainActivity = null;
    private static int maxVolCall = 0;
    private static int maxVolMusic = 0;
    private static Context mctx = null;
    private static boolean preState = false;
    private static final String tag = "GCloudVoiceTag";

    static {
        try {
            System.loadLibrary("GCloudVoice");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("load library failed!!!");
        }
    }

    public static void ApolloVoiceDeviceInit(Context context, Activity activity) {
        Log.i(tag, "GCloudVoice ApolloVoiceDeviceInit");
        if (mctx == null) {
            mctx = context;
            mainActivity = activity;
            if (audioManager == null) {
                audioManager = (AudioManager) context.getSystemService("audio");
            }
            if (audioManager != null) {
                audioManager.setSpeakerphoneOn(true);
                mSpeakerphoneOn = true;
                AudioManager audioManager2 = audioManager;
                AudioManager audioManager3 = audioManager;
                maxVolMusic = audioManager2.getStreamMaxVolume(3);
                AudioManager audioManager4 = audioManager;
                AudioManager audioManager5 = audioManager;
                maxVolCall = audioManager4.getStreamMaxVolume(0);
                Log.i(tag, "GCloudVoice::max music " + maxVolMusic + "max call =  " + maxVolCall);
            }
            registerHeadsetPlugReceiver();
            ApolloVoiceConfig.SetContext(context);
            ApolloVoiceUDID.SetContext(context);
            ApolloVoiceNetStatus.SetContext(context);
            if (audioManager.isBluetoothScoAvailableOffCall()) {
                m_blueAdapt = BluetoothAdapter.getDefaultAdapter();
                isblueConnect = audioManager.isBluetoothA2dpOn();
                Log.i(tag, "apollovoicemanager:: cur bluetooth state is: " + isblueConnect);
            }
        }
    }

    public static void ApolloVoiceDeviceUninit() {
        mainActivity = null;
        if (mctx != null) {
            unregisterHeadsetPlugReceiver();
            audioManager.setMode(0);
            audioManager = null;
            mctx = null;
        }
    }

    public static void ApolloVoiceDeviceRefresh() {
        Log.i(tag, "apolloVoice ApolloVoiceDeviceRefresh");
        if (mctx != null && audioManager != null) {
            if (audioManager.isWiredHeadsetOn()) {
                audioManager.setSpeakerphoneOn(false);
            } else {
                audioManager.setSpeakerphoneOn(mSpeakerphoneOn);
            }
        }
    }

    public static void ApolloVoiceDeviceExitVoipMode() {
        Log.i(tag, "apolloVoice ApolloVoiceDeviceExitVoipMode");
        if (mctx != null && audioManager != null) {
            audioManager.setMode(0);
            if (IsHeadSet()) {
                audioManager.setSpeakerphoneOn(false);
            } else {
                audioManager.setSpeakerphoneOn(mSpeakerphoneOn);
            }
        }
    }

    private static boolean IsBlueSet() {
        return isblueConnect;
    }

    private static void ApolloVoiceDeviceStartBlue() {
        if (audioManager != null) {
            Log.i(tag, "ApolloVoiceDeviceManager::set blue  ...\n");
            if (isblueConnect) {
                mSpeakerphoneOn = audioManager.isSpeakerphoneOn();
                if (mSpeakerphoneOn) {
                    audioManager.setSpeakerphoneOn(false);
                }
                boolean isBluetoothScoOn = audioManager.isBluetoothScoOn();
                int mode = audioManager.getMode();
                Log.i(tag, "set bluetoothSco ..." + isBluetoothScoOn);
                Log.i(tag, "blue cur mode ..." + mode);
                if (!isBluetoothScoOn) {
                    if (mode != 3) {
                        audioManager.setMode(3);
                    }
                    audioManager.startBluetoothSco();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean IsHeadSet() {
        if (audioManager == null || !audioManager.isWiredHeadsetOn()) {
            return false;
        }
        return true;
    }

    public static int ApolloVoiceGetCurrMode() {
        if (audioManager != null) {
            return audioManager.getMode();
        }
        return -2;
    }

    public static void ApolloVoiceDeviceEnterVoipMode(int i) {
        Log.i(tag, "apolloVoice ApolloVoiceDeviceEnterVoipMode nMode=" + i);
        if (audioManager != null) {
            audioManager.setMode(3);
            audioManager.setSpeakerphoneOn(mSpeakerphoneOn);
        }
    }

    private static void unregisterHeadsetPlugReceiver() {
        if (mctx != null) {
            try {
                mctx.unregisterReceiver(mHeadSetReceiver);
                mctx.unregisterReceiver(mHeadSetReceiver);
            } catch (Exception e) {
                Log.i(tag, "Registe headset failed!!! The exception is " + e.toString());
            }
        }
    }

    private static void registerHeadsetPlugReceiver() {
        if (mctx != null) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.HEADSET_PLUG");
                intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
                intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
                mctx.registerReceiver(mHeadSetReceiver, intentFilter);
            } catch (Exception e) {
                Log.i(tag, "Registe headset failed!!! The exception is " + e.toString());
            }
        }
    }

    public static void SetpreVoipMode(int i) {
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        mCurrVoipState = z;
    }

    public static void ApolloVoiceSetSpeakerOn(boolean z) {
        Log.i(tag, "apolloVoiceDevice::SetSpeakerOn is " + z);
        if (audioManager != null) {
            if (IsHeadSet() || IsBlueSet()) {
                audioManager.setSpeakerphoneOn(false);
                return;
            }
            audioManager.setSpeakerphoneOn(z);
            mSpeakerphoneOn = z;
        }
    }

    public static boolean ApolloVoiceDeviceSetMode(int i) {
        int i2;
        int i3;
        int i4;
        if (audioManager == null) {
            Log.i(tag, "apolloVoiceDevice::audioManager is null ..\n");
            if (mctx != null) {
                audioManager = (AudioManager) mctx.getSystemService("audio");
                if (audioManager == null) {
                    Log.i(tag, "apolloVoiceDevice::get audioManager null....\n");
                    return false;
                }
            } else {
                Log.i(tag, "apolloVoiceDevice::context is null....\n");
                return false;
            }
        }
        int mode = audioManager.getMode();
        if (mode != i) {
            AudioManager audioManager2 = audioManager;
            if (i == 0) {
                AudioManager audioManager3 = audioManager;
                AudioManager audioManager4 = audioManager;
                int streamVolume = audioManager3.getStreamVolume(0);
                i2 = (maxVolMusic * streamVolume) / maxVolCall;
                preState = false;
                AudioManager audioManager5 = audioManager;
                i3 = streamVolume;
                i4 = 3;
            } else {
                AudioManager audioManager6 = audioManager;
                AudioManager audioManager7 = audioManager;
                int streamVolume2 = audioManager6.getStreamVolume(3);
                int i5 = (maxVolCall * streamVolume2) / maxVolMusic;
                preState = true;
                AudioManager audioManager8 = audioManager;
                Log.i(tag, "apolloVoiceDevice::cur phone mode " + mode + "cur vol =  " + streamVolume2);
                i2 = i5;
                i3 = streamVolume2;
                i4 = 0;
            }
            Log.i(tag, "apolloVoiceDevice::set phone mode " + i + "set vol =  " + i2 + "pre vol =  " + i3);
            audioManager.setMode(i);
            audioManager.setStreamVolume(i4, i2, 0);
        }
        ApolloVoiceSetSpeakerOn(mSpeakerphoneOn);
        Log.i(tag, "apolloVoiceDevice::set phone mode " + i);
        return true;
    }

    public static boolean HaveMicrophonePermission() {
        if (mctx == null) {
            return false;
        }
        Log.i(tag, "buildVersion = " + Build.VERSION.SDK_INT);
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        if (ContextCompat.checkSelfPermission(mctx, "android.permission.RECORD_AUDIO") != 0) {
            Log.e(tag, "No microphone permission");
            ActivityCompat.requestPermissions(mainActivity, new String[]{"android.permission.RECORD_AUDIO"}, 100);
            return false;
        }
        Log.e(tag, "Hava microphone permission");
        return true;
    }
}
