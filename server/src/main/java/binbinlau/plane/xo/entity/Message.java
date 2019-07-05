package binbinlau.plane.xo.entity;

import java.util.Date;

public class Message {
    private String uid;

    private String fromuseruid;

    private Integer fromuseroid;

    private String fromusername;

    private String touseruid;

    private Integer touseroid;

    private String tousername;

    private String useravatar;

    private String title;

    private String content;

    private String href;

    private Boolean state;

    private Boolean type;

    private Boolean site;

    private String sn;

    private String data;

    private Boolean status;

    private Date createtime;

    private Date updatetime;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getFromuseruid() {
        return fromuseruid;
    }

    public void setFromuseruid(String fromuseruid) {
        this.fromuseruid = fromuseruid == null ? null : fromuseruid.trim();
    }

    public Integer getFromuseroid() {
        return fromuseroid;
    }

    public void setFromuseroid(Integer fromuseroid) {
        this.fromuseroid = fromuseroid;
    }

    public String getFromusername() {
        return fromusername;
    }

    public void setFromusername(String fromusername) {
        this.fromusername = fromusername == null ? null : fromusername.trim();
    }

    public String getTouseruid() {
        return touseruid;
    }

    public void setTouseruid(String touseruid) {
        this.touseruid = touseruid == null ? null : touseruid.trim();
    }

    public Integer getTouseroid() {
        return touseroid;
    }

    public void setTouseroid(Integer touseroid) {
        this.touseroid = touseroid;
    }

    public String getTousername() {
        return tousername;
    }

    public void setTousername(String tousername) {
        this.tousername = tousername == null ? null : tousername.trim();
    }

    public String getUseravatar() {
        return useravatar;
    }

    public void setUseravatar(String useravatar) {
        this.useravatar = useravatar == null ? null : useravatar.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Boolean getSite() {
        return site;
    }

    public void setSite(Boolean site) {
        this.site = site;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}