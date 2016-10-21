// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.INT32;
import static com.squareup.wire.Message.Datatype.INT64;
import static com.squareup.wire.Message.Datatype.STRING;
import static com.squareup.wire.Message.Label.REQUIRED;

/**
 * ����Ա���û��Ӽ����޳�
 */
public final class PB_USER_GETOUT_FAMILY extends Message {
  private static final long serialVersionUID = 0L;

  public static final Integer DEFAULT_ROOMID = 0;
  public static final Long DEFAULT_USERID = 0L;
  public static final String DEFAULT_G_ACCOUNT = "";

  /**
   * ����ID
   */
  @ProtoField(tag = 1, type = INT32, label = REQUIRED)
  public final Integer roomid;

  /**
   * UID
   */
  @ProtoField(tag = 2, type = INT64, label = REQUIRED)
  public final Long userid;

  /**
   * ���޳���UID
   */
  @ProtoField(tag = 3, type = STRING, label = REQUIRED)
  public final String g_account;

  public PB_USER_GETOUT_FAMILY(Integer roomid, Long userid, String g_account) {
    this.roomid = roomid;
    this.userid = userid;
    this.g_account = g_account;
  }

  private PB_USER_GETOUT_FAMILY(Builder builder) {
    this(builder.roomid, builder.userid, builder.g_account);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_USER_GETOUT_FAMILY)) return false;
    PB_USER_GETOUT_FAMILY o = (PB_USER_GETOUT_FAMILY) other;
    return equals(roomid, o.roomid)
        && equals(userid, o.userid)
        && equals(g_account, o.g_account);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = roomid != null ? roomid.hashCode() : 0;
      result = result * 37 + (userid != null ? userid.hashCode() : 0);
      result = result * 37 + (g_account != null ? g_account.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_USER_GETOUT_FAMILY> {

    public Integer roomid;
    public Long userid;
    public String g_account;

    public Builder() {
    }

    public Builder(PB_USER_GETOUT_FAMILY message) {
      super(message);
      if (message == null) return;
      this.roomid = message.roomid;
      this.userid = message.userid;
      this.g_account = message.g_account;
    }

    /**
     * ����ID
     */
    public Builder roomid(Integer roomid) {
      this.roomid = roomid;
      return this;
    }

    /**
     * UID
     */
    public Builder userid(Long userid) {
      this.userid = userid;
      return this;
    }

    /**
     * ���޳���UID
     */
    public Builder g_account(String g_account) {
      this.g_account = g_account;
      return this;
    }

    @Override
    public PB_USER_GETOUT_FAMILY build() {
      checkRequiredFields();
      return new PB_USER_GETOUT_FAMILY(this);
    }
  }
}
