// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.INT32;
import static com.squareup.wire.Message.Datatype.INT64;
import static com.squareup.wire.Message.Label.REQUIRED;

/**
 * �������߳��������Ա
 */
public final class PB_GETOUT_TGUSER extends Message {
  private static final long serialVersionUID = 0L;

  public static final Long DEFAULT_TGID = 0L;
  public static final Integer DEFAULT_ROOMID = 0;
  public static final Long DEFAULT_USERID = 0L;
  public static final Long DEFAULT_TARGET_UID = 0L;

  /**
   * ������ID
   */
  @ProtoField(tag = 1, type = INT64, label = REQUIRED)
  public final Long tgid;

  /**
   * ����ID
   */
  @ProtoField(tag = 2, type = INT32, label = REQUIRED)
  public final Integer roomid;

  /**
   * �������û�UID
   */
  @ProtoField(tag = 3, type = INT64, label = REQUIRED)
  public final Long userid;

  /**
   * ���߳��ĳ�ԱUID
   */
  @ProtoField(tag = 4, type = INT64, label = REQUIRED)
  public final Long target_uid;

  public PB_GETOUT_TGUSER(Long tgid, Integer roomid, Long userid, Long target_uid) {
    this.tgid = tgid;
    this.roomid = roomid;
    this.userid = userid;
    this.target_uid = target_uid;
  }

  private PB_GETOUT_TGUSER(Builder builder) {
    this(builder.tgid, builder.roomid, builder.userid, builder.target_uid);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_GETOUT_TGUSER)) return false;
    PB_GETOUT_TGUSER o = (PB_GETOUT_TGUSER) other;
    return equals(tgid, o.tgid)
        && equals(roomid, o.roomid)
        && equals(userid, o.userid)
        && equals(target_uid, o.target_uid);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = tgid != null ? tgid.hashCode() : 0;
      result = result * 37 + (roomid != null ? roomid.hashCode() : 0);
      result = result * 37 + (userid != null ? userid.hashCode() : 0);
      result = result * 37 + (target_uid != null ? target_uid.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_GETOUT_TGUSER> {

    public Long tgid;
    public Integer roomid;
    public Long userid;
    public Long target_uid;

    public Builder() {
    }

    public Builder(PB_GETOUT_TGUSER message) {
      super(message);
      if (message == null) return;
      this.tgid = message.tgid;
      this.roomid = message.roomid;
      this.userid = message.userid;
      this.target_uid = message.target_uid;
    }

    /**
     * ������ID
     */
    public Builder tgid(Long tgid) {
      this.tgid = tgid;
      return this;
    }

    /**
     * ����ID
     */
    public Builder roomid(Integer roomid) {
      this.roomid = roomid;
      return this;
    }

    /**
     * �������û�UID
     */
    public Builder userid(Long userid) {
      this.userid = userid;
      return this;
    }

    /**
     * ���߳��ĳ�ԱUID
     */
    public Builder target_uid(Long target_uid) {
      this.target_uid = target_uid;
      return this;
    }

    @Override
    public PB_GETOUT_TGUSER build() {
      checkRequiredFields();
      return new PB_GETOUT_TGUSER(this);
    }
  }
}
