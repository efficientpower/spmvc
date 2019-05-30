package org.wjh.common;

import com.google.common.base.Strings;

import java.util.Date;

public class WebUser {
    public static ThreadLocal<WebUser> webUserThreadLocal = new ThreadLocal<WebUser>();

    private String userId;
    private String userName;
    private long createTimeStamp;
    private long expireTime;
    private String ip;
    private String deviceId;

    public static WebUser getWebUser() {
        return webUserThreadLocal.get();
    }

    public static void setWebUser(WebUser webUser) {
        webUserThreadLocal.set(webUser);
    }

    public static boolean hasLogin(){
        WebUser wu = getWebUser();
        return wu != null && !Strings.isNullOrEmpty(wu.getUserId());
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getCreateTimeStamp() {
        return createTimeStamp;
    }

    public void setCreateTimeStamp(long createTimeStamp) {
        this.createTimeStamp = createTimeStamp;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
