// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.ENUM;
import static com.squareup.wire.Message.Datatype.INT32;
import static com.squareup.wire.Message.Datatype.INT64;
import static com.squareup.wire.Message.Label.REQUIRED;

/**
 * ��ȡ��Ӧ���͵�zone�б�
 */
public final class PB_ZONE_LIST extends Message {
  private static final long serialVersionUID = 0L;

  public static final Long DEFAULT_USERID = 0L;
  public static final Integer DEFAULT_BEGNUM = 0;
  public static final Integer DEFAULT_MAXNUM = 0;
  public static final eRS_COMMON_ZONE DEFAULT_ZONE = eRS_COMMON_ZONE.eRS_COMMON_ZONE_AT;

  /**
   * �û�id
   */
  @ProtoField(tag = 1, type = INT64, label = REQUIRED)
  public final Long userid;

  /**
   * ��ʼ��Ϣ��
   */
  @ProtoField(tag = 2, type = INT32, label = REQUIRED)
  public final Integer begnum;

  /**
   * ������Ϣ��
   */
  @ProtoField(tag = 3, type = INT32, label = REQUIRED)
  public final Integer maxnum;

  /**
   * zone����
   */
  @ProtoField(tag = 4, type = ENUM, label = REQUIRED)
  public final eRS_COMMON_ZONE zone;

  public PB_ZONE_LIST(Long userid, Integer begnum, Integer maxnum, eRS_COMMON_ZONE zone) {
    this.userid = userid;
    this.begnum = begnum;
    this.maxnum = maxnum;
    this.zone = zone;
  }

  private PB_ZONE_LIST(Builder builder) {
    this(builder.userid, builder.begnum, builder.maxnum, builder.zone);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_ZONE_LIST)) return false;
    PB_ZONE_LIST o = (PB_ZONE_LIST) other;
    return equals(userid, o.userid)
        && equals(begnum, o.begnum)
        && equals(maxnum, o.maxnum)
        && equals(zone, o.zone);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = userid != null ? userid.hashCode() : 0;
      result = result * 37 + (begnum != null ? begnum.hashCode() : 0);
      result = result * 37 + (maxnum != null ? maxnum.hashCode() : 0);
      result = result * 37 + (zone != null ? zone.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_ZONE_LIST> {

    public Long userid;
    public Integer begnum;
    public Integer maxnum;
    public eRS_COMMON_ZONE zone;

    public Builder() {
    }

    public Builder(PB_ZONE_LIST message) {
      super(message);
      if (message == null) return;
      this.userid = message.userid;
      this.begnum = message.begnum;
      this.maxnum = message.maxnum;
      this.zone = message.zone;
    }

    /**
     * �û�id
     */
    public Builder userid(Long userid) {
      this.userid = userid;
      return this;
    }

    /**
     * ��ʼ��Ϣ��
     */
    public Builder begnum(Integer begnum) {
      this.begnum = begnum;
      return this;
    }

    /**
     * ������Ϣ��
     */
    public Builder maxnum(Integer maxnum) {
      this.maxnum = maxnum;
      return this;
    }

    /**
     * zone����
     */
    public Builder zone(eRS_COMMON_ZONE zone) {
      this.zone = zone;
      return this;
    }

    @Override
    public PB_ZONE_LIST build() {
      checkRequiredFields();
      return new PB_ZONE_LIST(this);
    }
  }
}
