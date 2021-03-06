// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.ENUM;
import static com.squareup.wire.Message.Datatype.INT32;
import static com.squareup.wire.Message.Datatype.INT64;
import static com.squareup.wire.Message.Datatype.STRING;
import static com.squareup.wire.Message.Label.REQUIRED;

/**
 * ���������͹���Ա���û��Ӽ����޳���Ϣ
 */
public final class PB_RS_GETOUT_FAMILY extends Message {
  private static final long serialVersionUID = 0L;

  public static final eRS_GetOut_Family_Ret DEFAULT_RET = eRS_GetOut_Family_Ret.RS_GOF_SUCC;
  public static final Long DEFAULT_USERID = 0L;
  public static final Long DEFAULT_G_USERID = 0L;
  public static final String DEFAULT_NICKNAME = "";
  public static final String DEFAULT_G_NICKNAME = "";
  public static final Integer DEFAULT_FAMILYID = 0;
  public static final Integer DEFAULT_NEW_ROOMID = 0;

  /**
   * ���
   */
  @ProtoField(tag = 1, type = ENUM, label = REQUIRED)
  public final eRS_GetOut_Family_Ret ret;

  /**
   * UID
   */
  @ProtoField(tag = 2, type = INT64, label = REQUIRED)
  public final Long userid;

  /**
   * ���޳���UID
   */
  @ProtoField(tag = 3, type = INT64, label = REQUIRED)
  public final Long g_userid;

  /**
   * �ɹ��˳���ʱ����д������Ϣ
   * ����Ա�ǳ�
   */
  @ProtoField(tag = 4, type = STRING)
  public final String nickname;

  /**
   * �����û��ǳ�
   */
  @ProtoField(tag = 5, type = STRING)
  public final String g_nickname;

  /**
   * ����ID
   */
  @ProtoField(tag = 6, type = INT32)
  public final Integer familyid;

  /**
   * �û����ߺ��µķ���ID
   */
  @ProtoField(tag = 7, type = INT32)
  public final Integer new_roomid;

  public PB_RS_GETOUT_FAMILY(eRS_GetOut_Family_Ret ret, Long userid, Long g_userid, String nickname, String g_nickname, Integer familyid, Integer new_roomid) {
    this.ret = ret;
    this.userid = userid;
    this.g_userid = g_userid;
    this.nickname = nickname;
    this.g_nickname = g_nickname;
    this.familyid = familyid;
    this.new_roomid = new_roomid;
  }

  private PB_RS_GETOUT_FAMILY(Builder builder) {
    this(builder.ret, builder.userid, builder.g_userid, builder.nickname, builder.g_nickname, builder.familyid, builder.new_roomid);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_RS_GETOUT_FAMILY)) return false;
    PB_RS_GETOUT_FAMILY o = (PB_RS_GETOUT_FAMILY) other;
    return equals(ret, o.ret)
        && equals(userid, o.userid)
        && equals(g_userid, o.g_userid)
        && equals(nickname, o.nickname)
        && equals(g_nickname, o.g_nickname)
        && equals(familyid, o.familyid)
        && equals(new_roomid, o.new_roomid);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = ret != null ? ret.hashCode() : 0;
      result = result * 37 + (userid != null ? userid.hashCode() : 0);
      result = result * 37 + (g_userid != null ? g_userid.hashCode() : 0);
      result = result * 37 + (nickname != null ? nickname.hashCode() : 0);
      result = result * 37 + (g_nickname != null ? g_nickname.hashCode() : 0);
      result = result * 37 + (familyid != null ? familyid.hashCode() : 0);
      result = result * 37 + (new_roomid != null ? new_roomid.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_RS_GETOUT_FAMILY> {

    public eRS_GetOut_Family_Ret ret;
    public Long userid;
    public Long g_userid;
    public String nickname;
    public String g_nickname;
    public Integer familyid;
    public Integer new_roomid;

    public Builder() {
    }

    public Builder(PB_RS_GETOUT_FAMILY message) {
      super(message);
      if (message == null) return;
      this.ret = message.ret;
      this.userid = message.userid;
      this.g_userid = message.g_userid;
      this.nickname = message.nickname;
      this.g_nickname = message.g_nickname;
      this.familyid = message.familyid;
      this.new_roomid = message.new_roomid;
    }

    /**
     * ���
     */
    public Builder ret(eRS_GetOut_Family_Ret ret) {
      this.ret = ret;
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
    public Builder g_userid(Long g_userid) {
      this.g_userid = g_userid;
      return this;
    }

    /**
     * �ɹ��˳���ʱ����д������Ϣ
     * ����Ա�ǳ�
     */
    public Builder nickname(String nickname) {
      this.nickname = nickname;
      return this;
    }

    /**
     * �����û��ǳ�
     */
    public Builder g_nickname(String g_nickname) {
      this.g_nickname = g_nickname;
      return this;
    }

    /**
     * ����ID
     */
    public Builder familyid(Integer familyid) {
      this.familyid = familyid;
      return this;
    }

    /**
     * �û����ߺ��µķ���ID
     */
    public Builder new_roomid(Integer new_roomid) {
      this.new_roomid = new_roomid;
      return this;
    }

    @Override
    public PB_RS_GETOUT_FAMILY build() {
      checkRequiredFields();
      return new PB_RS_GETOUT_FAMILY(this);
    }
  }
}
