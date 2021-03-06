// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.ENUM;
import static com.squareup.wire.Message.Datatype.INT32;
import static com.squareup.wire.Message.Datatype.STRING;
import static com.squareup.wire.Message.Label.REQUIRED;

/**
 * message
 */
public final class PB_MESSAGE extends Message {
  private static final long serialVersionUID = 0L;

  public static final ePB_MSG_TYPE DEFAULT_TYPE = ePB_MSG_TYPE.MSG_TYPE_SYSMSG;
  public static final ePB_MSG_STYLE DEFAULT_STYLE = ePB_MSG_STYLE.CHAT_MSG_STYLE_TEXT;
  public static final ePB_CHAT_ZONE DEFAULT_ZONE = ePB_CHAT_ZONE.CM_ZONE_FAM_NORMAL;
  public static final Integer DEFAULT_SENDTIME = 0;
  public static final String DEFAULT_CONTENT = "";
  public static final String DEFAULT_MEDIA_URL = "";

  /**
   * ��Ϣ����
   */
  @ProtoField(tag = 1, type = ENUM, label = REQUIRED)
  public final ePB_MSG_TYPE type;

  /**
   * ��Ϣ��ʽ
   */
  @ProtoField(tag = 2, type = ENUM, label = REQUIRED)
  public final ePB_MSG_STYLE style;

  /**
   * ��Ϣ����
   */
  @ProtoField(tag = 3, type = ENUM, label = REQUIRED)
  public final ePB_CHAT_ZONE zone;

  /**
   * ������Ϣʱ��
   */
  @ProtoField(tag = 4, type = INT32, label = REQUIRED)
  public final Integer sendtime;

  /**
   * �ı���Ϣ����
   */
  @ProtoField(tag = 5, type = STRING)
  public final String content;

  /**
   * ý���ַ��ͼƬ����������Ƶ��
   */
  @ProtoField(tag = 6, type = STRING)
  public final String media_url;

  public PB_MESSAGE(ePB_MSG_TYPE type, ePB_MSG_STYLE style, ePB_CHAT_ZONE zone, Integer sendtime, String content, String media_url) {
    this.type = type;
    this.style = style;
    this.zone = zone;
    this.sendtime = sendtime;
    this.content = content;
    this.media_url = media_url;
  }

  private PB_MESSAGE(Builder builder) {
    this(builder.type, builder.style, builder.zone, builder.sendtime, builder.content, builder.media_url);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_MESSAGE)) return false;
    PB_MESSAGE o = (PB_MESSAGE) other;
    return equals(type, o.type)
        && equals(style, o.style)
        && equals(zone, o.zone)
        && equals(sendtime, o.sendtime)
        && equals(content, o.content)
        && equals(media_url, o.media_url);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = type != null ? type.hashCode() : 0;
      result = result * 37 + (style != null ? style.hashCode() : 0);
      result = result * 37 + (zone != null ? zone.hashCode() : 0);
      result = result * 37 + (sendtime != null ? sendtime.hashCode() : 0);
      result = result * 37 + (content != null ? content.hashCode() : 0);
      result = result * 37 + (media_url != null ? media_url.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_MESSAGE> {

    public ePB_MSG_TYPE type;
    public ePB_MSG_STYLE style;
    public ePB_CHAT_ZONE zone;
    public Integer sendtime;
    public String content;
    public String media_url;

    public Builder() {
    }

    public Builder(PB_MESSAGE message) {
      super(message);
      if (message == null) return;
      this.type = message.type;
      this.style = message.style;
      this.zone = message.zone;
      this.sendtime = message.sendtime;
      this.content = message.content;
      this.media_url = message.media_url;
    }

    /**
     * ��Ϣ����
     */
    public Builder type(ePB_MSG_TYPE type) {
      this.type = type;
      return this;
    }

    /**
     * ��Ϣ��ʽ
     */
    public Builder style(ePB_MSG_STYLE style) {
      this.style = style;
      return this;
    }

    /**
     * ��Ϣ����
     */
    public Builder zone(ePB_CHAT_ZONE zone) {
      this.zone = zone;
      return this;
    }

    /**
     * ������Ϣʱ��
     */
    public Builder sendtime(Integer sendtime) {
      this.sendtime = sendtime;
      return this;
    }

    /**
     * �ı���Ϣ����
     */
    public Builder content(String content) {
      this.content = content;
      return this;
    }

    /**
     * ý���ַ��ͼƬ����������Ƶ��
     */
    public Builder media_url(String media_url) {
      this.media_url = media_url;
      return this;
    }

    @Override
    public PB_MESSAGE build() {
      checkRequiredFields();
      return new PB_MESSAGE(this);
    }
  }
}
