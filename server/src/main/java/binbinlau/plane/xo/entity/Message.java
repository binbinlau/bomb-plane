package binbinlau.plane.xo.entity;

import binbinlau.plane.xo.enums.EStatus;

import java.util.Date;

public class Message {
    /**
     * 唯一ID
     */
    private String uid;

    /**
     * 来自谁UID
     */
    private String fromuseruid;

    /**
     * 来自谁OID
     */
    private Integer fromuseroid;

    /**
     * 来自谁NAME
     */
    private String fromusername;

    /**
     * 评论给谁的uid
     */
    private String touseruid;

    /**
     * 发给谁OID
     */
    private Integer touseroid;

    /**
     * 发给谁NAME
     */
    private String tousername;

    /**
     * 会员头像or网站头像
     */
    private String useravatar;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 链接
     */
    private String href;

    /**
     * 未读、已读、已删除
     */
    private Boolean state;

    /**
     * 消息类型
     */
    private Boolean type;

    /**
     * 来自哪个项目
     */
    private Boolean site;

    /**
     * 编号
     */
    private String sn;

    /**
     * 其他数据json格式
     */
    private String data;

    /**
     * 状态(0禁用1启用)
     */
    private EStatus status;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 最后更新时间
     */
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

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
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