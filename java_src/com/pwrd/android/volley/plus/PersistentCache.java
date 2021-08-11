package com.pwrd.android.volley.plus;

import java.io.IOException;

public interface PersistentCache {
    void setBrittle(String str) throws IOException;

    void setPersistent(String str) throws IOException;
}
