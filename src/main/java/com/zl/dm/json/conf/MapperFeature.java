package com.zl.dm.json.conf;

public enum MapperFeature implements Feature{

    ZERO(true),ONE(true),TWO(false),THREE(true),FOUR(false),FIVE(true),SIX(true);

    private boolean state;

    private int mask;

    MapperFeature(boolean state) {
        this.state = state;
        this.mask = (1 << ordinal());
    }

    @Override
    public boolean enabledByDefault() {
        return state;
    }

    @Override
    public boolean enabled(int flag) {
        return (flag & mask) != 0;
    }

    @Override
    public int getMask() {
        return mask;
    }
}
