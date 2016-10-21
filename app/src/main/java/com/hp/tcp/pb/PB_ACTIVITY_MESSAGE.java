// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.ENUM;
import static com.squareup.wire.Message.Datatype.INT64;
import static com.squareup.wire.Message.Datatype.STRING;
import static com.squareup.wire.Message.Label.REQUIRED;

public final class PB_ACTIVITY_MESSAGE extends Message {
  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_SELLERID = "";
  public static final eRS_COMMON_ZONE DEFAULT_ZONE = eRS_COMMON_ZONE.eRS_COMMON_ZONE_AT;
  public static final String DEFAULT_NAME = "";
  public static final Long DEFAULT_MSGID = 0L;

  /**
   * ���ϵͳ��Ϣ,����������
   * �̼�id
   */
  @ProtoField(tag = 1, type = STRING, label = REQUIRED)
  public final String sellerid;

  /**
   * �
   */
  @ProtoField(tag = 2, label = REQUIRED)
  public final PB_ACTIVITY activity;

  /**
   * ����
   */
  @ProtoField(tag = 3, type = ENUM, label = REQUIRED)
  public final eRS_COMMON_ZONE zone;

  /**
   * �̼���
   */
  @ProtoField(tag = 4, type = STRING)
  public final String name;

  /**
   * ��Ϣ��
   */
  @ProtoField(tag = 5, type = INT64)
  public final Long msgid;

  public PB_ACTIVITY_MESSAGE(String sellerid, PB_ACTIVITY activity, eRS_COMMON_ZONE zone, String name, Long msgid) {
    this.sellerid = sellerid;
    this.activity = activity;
    this.zone = zone;
    this.name = name;
    this.msgid = msgid;
  }

  private PB_ACTIVITY_MESSAGE(Builder builder) {
    this(builder.sellerid, builder.activity, builder.zone, builder.name, builder.msgid);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_ACTIVITY_MESSAGE)) return false;
    PB_ACTIVITY_MESSAGE o = (PB_ACTIVITY_MESSAGE) other;
    return equals(sellerid, o.sellerid)
        && equals(activity, o.activity)
        && equals(zone, o.zone)
        && equals(name, o.name)
        && equals(msgid, o.msgid);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = sellerid != null ? sellerid.hashCode() : 0;
      result = result * 37 + (activity != null ? activity.hashCode() : 0);
      result = result * 37 + (zone != null ? zone.hashCode() : 0);
      result = result * 37 + (name != null ? name.hashCode() : 0);
      result = result * 37 + (msgid != null ? msgid.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_ACTIVITY_MESSAGE> {

    public String sellerid;
    public PB_ACTIVITY activity;
    public eRS_COMMON_ZONE zone;
    public String name;
    public Long msgid;

    public Builder() {
    }

    public Builder(PB_ACTIVITY_MESSAGE message) {
      super(message);
      if (message == null) return;
      this.sellerid = message.sellerid;
      this.activity = message.activity;
      this.zone = message.zone;
      this.name = message.name;
      this.msgid = message.msgid;
    }

    /**
     * ���ϵͳ��Ϣ,����������
     * �̼�id
     */
    public Builder sellerid(String sellerid) {
      this.sellerid = sellerid;
      return this;
    }

    /**
     * �
     */
    public Builder activity(PB_ACTIVITY activity) {
      this.activity = activity;
      return this;
    }

    /**
     * ����
     */
    public Builder zone(eRS_COMMON_ZONE zone) {
      this.zone = zone;
      return this;
    }

    /**
     * �̼���
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * ��Ϣ��
     */
    public Builder msgid(Long msgid) {
      this.msgid = msgid;
      return this;
    }

    @Override
    public PB_ACTIVITY_MESSAGE build() {
      checkRequiredFields();
      return new PB_ACTIVITY_MESSAGE(this);
    }
  }
}
