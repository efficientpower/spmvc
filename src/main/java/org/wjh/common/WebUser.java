package org.wjh.common;

import java.util.Date;

public class WebUser {
    public static ThreadLocal<WebUser> webUserTl = new ThreadLocal<WebUser>();

    private String userId;
    private Date createDate;
    private String ip;
    private String deviceId;

    public static WebUser getWebUser() {
        return webUserTl.get();
    }

    public static void setWebUser(WebUser webUser) {
        webUserTl.set(webUser);
    }

    public String getUserId() {
        WebUser wu = getWebUser();
        if(wu != null){
            return wu.getUserId();
        }
        return null;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
