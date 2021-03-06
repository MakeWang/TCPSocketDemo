// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.INT64;
import static com.squareup.wire.Message.Datatype.STRING;
import static com.squareup.wire.Message.Label.REQUIRED;

public final class PB_ACTIVITY extends Message {
  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_THEME = "";
  public static final String DEFAULT_CONTENT = "";
  public static final String DEFAULT_ACT_IMG = "";
  public static final String DEFAULT_ACT_LINK = "";
  public static final Long DEFAULT_TIME = 0L;
  public static final Long DEFAULT_MSGID = 0L;
  public static final Long DEFAULT_STIME = 0L;

  /**
   * �
   * �����
   */
  @ProtoField(tag = 1, type = STRING)
  public final String theme;

  /**
   * �����
   */
  @ProtoField(tag = 2, type = STRING, label = REQUIRED)
  public final String content;

  /**
   * �ͼƬ
   */
  @ProtoField(tag = 3, type = STRING)
  public String act_img;

  /**
   * ���������
   */
  @ProtoField(tag = 4, type = STRING)
  public String act_link;

  /**
   * �����ʱ��(�ͻ��˸�ֵ)
   */
  @ProtoField(tag = 5, type = INT64, label = REQUIRED)
  public final Long time;

  /**
   * ���ϵͳ��Ϣ���
   */
  @ProtoField(tag = 6, type = INT64)
  public Long msgid;

  /**
   * ����˼�¼�ʱ��
   */
  @ProtoField(tag = 7, type = INT64)
  public final Long stime;

  public PB_ACTIVITY(String theme, String content, String act_img, String act_link, Long time, Long msgid, Long stime) {
    this.theme = theme;
    this.content = content;
    this.act_img = act_img;
    this.act_link = act_link;
    this.time = time;
    this.msgid = msgid;
    this.stime = stime;
  }

  private PB_ACTIVITY(Builder builder) {
    this(builder.theme, builder.content, builder.act_img, builder.act_link, builder.time, builder.msgid, builder.stime);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_ACTIVITY)) return false;
    PB_ACTIVITY o = (PB_ACTIVITY) other;
    return equals(theme, o.theme)
        && equals(content, o.content)
        && equals(act_img, o.act_img)
        && equals(act_link, o.act_link)
        && equals(time, o.time)
        && equals(msgid, o.msgid)
        && equals(stime, o.stime);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = theme != null ? theme.hashCode() : 0;
      result = result * 37 + (content != null ? content.hashCode() : 0);
      result = result * 37 + (act_img != null ? act_img.hashCode() : 0);
      result = result * 37 + (act_link != null ? act_link.hashCode() : 0);
      result = result * 37 + (time != null ? time.hashCode() : 0);
      result = result * 37 + (msgid != null ? msgid.hashCode() : 0);
      result = result * 37 + (stime != null ? stime.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_ACTIVITY> {

    public String theme;
    public String content;
    public String act_img;
    public String act_link;
    public Long time;
    public Long msgid;
    public Long stime;

    public Builder() {
    }

    public Builder(PB_ACTIVITY message) {
      super(message);
      if (message == null) return;
      this.theme = message.theme;
      this.content = message.content;
      this.act_img = message.act_img;
      this.act_link = message.act_link;
      this.time = message.time;
      this.msgid = message.msgid;
      this.stime = message.stime;
    }

    /**
     * �
     * �����
     */
    public Builder theme(String theme) {
      this.theme = theme;
      return this;
    }

    /**
     * �����
     */
    public Builder content(String content) {
      this.content = content;
      return this;
    }

    /**
     * �ͼƬ
     */
    public Builder act_img(String act_img) {
      this.act_img = act_img;
      return this;
    }

    /**
     * ���������
     */
    public Builder act_link(String act_link) {
      this.act_link = act_link;
      return this;
    }

    /**
     * �����ʱ��(�ͻ��˸�ֵ)
     */
    public Builder time(Long time) {
      this.time = time;
      return this;
    }

    /**
     * ���ϵͳ��Ϣ���
     */
    public Builder msgid(Long msgid) {
      this.msgid = msgid;
      return this;
    }

    /**
     * ����˼�¼�ʱ��
     */
    public Builder stime(Long stime) {
      this.stime = stime;
      return this;
    }

    @Override
    public PB_ACTIVITY build() {
      checkRequiredFields();
      return new PB_ACTIVITY(this);
    }
  }
}
