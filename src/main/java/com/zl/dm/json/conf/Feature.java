package com.zl.dm.json.conf;

public interface Feature {

    boolean enabledByDefault();

    boolean enabled(int flag);

    int getMask();

}
