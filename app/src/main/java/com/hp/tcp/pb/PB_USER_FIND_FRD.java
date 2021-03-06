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
 * ���Ҵ��Ӻ����û�
 */
public final class PB_USER_FIND_FRD extends Message {
  private static final long serialVersionUID = 0L;

  public static final Integer DEFAULT_ROOMID = 0;
  public static final Long DEFAULT_USERID = 0L;
  public static final Long DEFAULT_F_PRETTYNUM = 0L;
  public static final String DEFAULT_F_NICKNAME = "";

  @ProtoField(tag = 1, type = INT32, label = REQUIRED)
  public final Integer roomid;

  /**
   * ��ҽ�ɫUID
   */
  @ProtoField(tag = 2, type = INT64, label = REQUIRED)
  public final Long userid;

  /**
   * �����ҵ��û�����
   */
  @ProtoField(tag = 3, type = INT64)
  public final Long f_prettynum;

  /**
   * �����ҵ��û��ǳ�
   */
  @ProtoField(tag = 4, type = STRING)
  public final String f_nickname;

  public PB_USER_FIND_FRD(Integer roomid, Long userid, Long f_prettynum, String f_nickname) {
    this.roomid = roomid;
    this.userid = userid;
    this.f_prettynum = f_prettynum;
    this.f_nickname = f_nickname;
  }

  private PB_USER_FIND_FRD(Builder builder) {
    this(builder.roomid, builder.userid, builder.f_prettynum, builder.f_nickname);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_USER_FIND_FRD)) return false;
    PB_USER_FIND_FRD o = (PB_USER_FIND_FRD) other;
    return equals(roomid, o.roomid)
        && equals(userid, o.userid)
        && equals(f_prettynum, o.f_prettynum)
        && equals(f_nickname, o.f_nickname);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = roomid != null ? roomid.hashCode() : 0;
      result = result * 37 + (userid != null ? userid.hashCode() : 0);
      result = result * 37 + (f_prettynum != null ? f_prettynum.hashCode() : 0);
      result = result * 37 + (f_nickname != null ? f_nickname.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_USER_FIND_FRD> {

    public Integer roomid;
    public Long userid;
    public Long f_prettynum;
    public String f_nickname;

    public Builder() {
    }

    public Builder(PB_USER_FIND_FRD message) {
      super(message);
      if (message == null) return;
      this.roomid = message.roomid;
      this.userid = message.userid;
      this.f_prettynum = message.f_prettynum;
      this.f_nickname = message.f_nickname;
    }

    public Builder roomid(Integer roomid) {
      this.roomid = roomid;
      return this;
    }

    /**
     * ��ҽ�ɫUID
     */
    public Builder userid(Long userid) {
      this.userid = userid;
      return this;
    }

    /**
     * �����ҵ��û�����
     */
    public Builder f_prettynum(Long f_prettynum) {
      this.f_prettynum = f_prettynum;
      return this;
    }

    /**
     * �����ҵ��û��ǳ�
     */
    public Builder f_nickname(String f_nickname) {
      this.f_nickname = f_nickname;
      return this;
    }

    @Override
    public PB_USER_FIND_FRD build() {
      checkRequiredFields();
      return new PB_USER_FIND_FRD(this);
    }
  }
}
