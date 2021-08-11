package com.wanmei.sdk.core.config;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.wanmei.sdk.core.param.Param;
import com.wanmei.sdk.core.util.C1843d;
import com.wanmei.sdk.core.util.C1845f;
import com.wanmei.sdk.core.util.LogUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ConfigReader {
    private static final String CHANNEL = "channel";
    private static final String CHANNEL_ID = "channelId";
    private static final String COMMON = "common";
    private static final String CUSTOM_SERVICE = "customService";
    private static final String INIT = "init";
    private static final String LOGIN = "login";
    private static final String META = "meta";
    private static final String PACKAGE_NAME = "packageName";
    private static final String PAY = "pay";
    private static final String PLATFORM = "platform";
    private static final String SHARE_WEIXIN_ID = "shareWeixinId";
    private static final String TAG = "ConfigReader";
    private static final String VERSION = "version";
    private int mAppId;
    private String mAppKey;
    private Context mContext;
    private HashMap<String, Param> mInitConfig;
    private HashMap<String, Param> mLoginConfig;
    private HashMap<String, Param> mMeta;
    private HashMap<String, Param> mPayConfig;
    private String mVersion;

    public ConfigReader(Context context) {
        this.mContext = context;
    }

    private String decodeFromString(String body) {
        String str = this.mAppKey;
        return new String(C1843d.m6688a(Base64.decode(body, 2), str.substring(str.length() - 16, str.length())));
    }

    private HashMap<String, Param> getMeta(String meta) throws JSONException {
        HashMap<String, Param> hashMap = new HashMap<>();
        JSONObject jSONObject = new JSONObject(meta);
        hashMap.put(VERSION, new Param(VERSION, jSONObject.getString(VERSION), true));
        hashMap.put(PLATFORM, new Param(PLATFORM, String.valueOf(jSONObject.getInt(PLATFORM)), true));
        hashMap.put(CHANNEL_ID, new Param(CHANNEL_ID, String.valueOf(jSONObject.getInt(CHANNEL_ID)), true));
        hashMap.put(PACKAGE_NAME, new Param(PACKAGE_NAME, jSONObject.getString(PACKAGE_NAME), true));
        return hashMap;
    }

    private HashMap<String, String> getMetaString(String raw) throws JSONException {
        HashMap<String, String> hashMap = new HashMap<>(4);
        JSONObject jSONObject = new JSONObject(raw);
        hashMap.put(META, jSONObject.getString(META));
        hashMap.put(INIT, jSONObject.getString(INIT));
        hashMap.put(LOGIN, jSONObject.getString(LOGIN));
        hashMap.put(PAY, jSONObject.getString(PAY));
        return hashMap;
    }

    private void readConfig(String preDecode) throws JSONException {
        if (TextUtils.isEmpty(preDecode)) {
            LogUtil.m6673e(TAG, "ConfigFile's content is null or \"\"");
            return;
        }
        String decodeFromString = decodeFromString(preDecode);
        LogUtil.m6672d(TAG, "File raw: " + decodeFromString);
        HashMap<String, String> metaString = getMetaString(decodeFromString);
        this.mMeta = getMeta(metaString.get(META));
        this.mInitConfig = readInitParams(metaString.get(INIT));
        this.mLoginConfig = readLoginParams(metaString.get(LOGIN));
        this.mPayConfig = readPayParams(metaString.get(PAY));
        validatePackageName();
        validateVersion();
        validateParams();
    }

    private String readFile(String configFileName) {
        try {
            return C1845f.m6693b(this.mContext.getAssets().open(configFileName));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String readFilePath(String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                return C1845f.m6693b(new FileInputStream(file));
            }
            throw new FileNotFoundException("file not fond: " + filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private HashMap<String, Param> readInitParams(String initStr) throws JSONException {
        JSONObject jSONObject = new JSONObject(initStr);
        HashMap<String, Param> readChannelInitParams = readChannelInitParams(jSONObject.getJSONObject("channel"));
        jSONObject.getJSONObject(COMMON);
        return readChannelInitParams;
    }

    private HashMap<String, Param> readLoginParams(String loginStr) throws JSONException {
        return readChannelLoginParams(new JSONObject(loginStr).getJSONObject("channel"));
    }

    private HashMap<String, Param> readPayParams(String payStr) throws JSONException {
        return readChannelPayParams(new JSONObject(payStr).getJSONObject("channel"));
    }

    private void validate(HashMap<String, Param> paramMap) {
        for (Param param : paramMap.values()) {
            if (param != null && param.isNotNull() && param.getValue() == null) {
                throw new ConfigFileException("param: " + param.getName() + " is empty");
            }
        }
    }

    private void validatePackageName() {
        if (!this.mContext.getPackageName().startsWith((String) this.mMeta.get(PACKAGE_NAME).getValue())) {
            throw new ConfigFileException("package error, packageName in config is: " + this.mMeta.get(PACKAGE_NAME).getValue() + " while packageName in game is: " + this.mContext.getPackageName());
        }
    }

    private void validateParams() {
        validate(this.mMeta);
        validate(this.mInitConfig);
        validate(this.mLoginConfig);
        validate(this.mPayConfig);
    }

    private void validateVersion() {
        if (!this.mMeta.get(VERSION).getValue().equals(this.mVersion)) {
            throw new ConfigFileException("version error, config version is: " + this.mMeta.get(VERSION).getValue() + " while the sdk's version is" + this.mVersion);
        }
    }

    public HashMap<String, Param> getInitConfig() {
        return this.mInitConfig;
    }

    public HashMap<String, Param> getLoginConfig() {
        return this.mLoginConfig;
    }

    public HashMap<String, Param> getPayConfig() {
        return this.mPayConfig;
    }

    /* access modifiers changed from: protected */
    public HashMap<String, Param> readChannelInitParams(JSONObject initJson) throws JSONException {
        return new HashMap<>();
    }

    /* access modifiers changed from: protected */
    public HashMap<String, Param> readChannelLoginParams(JSONObject loginJson) throws JSONException {
        return new HashMap<>();
    }

    /* access modifiers changed from: protected */
    public HashMap<String, Param> readChannelPayParams(JSONObject payJson) throws JSONException {
        return new HashMap<>();
    }

    public void readConfigFileName(String configFileName) throws JSONException {
        readConfig(readFile(configFileName));
    }

    public void readConfigFilePath(String configFilePath) throws JSONException {
        readConfig(readFilePath(configFilePath));
    }

    public void setBasic(int appId, String appKey, String version) {
        this.mAppId = appId;
        this.mAppKey = appKey;
        this.mVersion = version;
    }
}
