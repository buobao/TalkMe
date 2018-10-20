package com.king.turman.talkme;

/**
 * save app current status
 */
public class AppCurrentStatus {
    /**
     * Jpush alias sat
     */
    private boolean isJPushAliasSet;
    private String jPushAlias; //极光别名
    private String jPushTag;  //极光标签

    private AppCurrentStatus() {

    }

    private static class SingletonInner {
        private static AppCurrentStatus singletonStaticInner = new AppCurrentStatus();
    }

    public static AppCurrentStatus getInstance() {
        return SingletonInner.singletonStaticInner;
    }

    public boolean isJPushAliasSet() {
        return isJPushAliasSet;
    }

    public void setJPushAliasSet(boolean JPushAliasSet) {
        isJPushAliasSet = JPushAliasSet;
    }

    public String getjPushAlias() {
        return jPushAlias;
    }

    public void setjPushAlias(String jPushAlias) {
        this.jPushAlias = jPushAlias;
    }

    public String getjPushTag() {
        return jPushTag;
    }

    public void setjPushTag(String jPushTag) {
        this.jPushTag = jPushTag;
    }
}
