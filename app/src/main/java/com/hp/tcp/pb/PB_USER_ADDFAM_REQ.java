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
 * /////////////�������
 * ����������������Ϣ
 */
public final class PB_USER_ADDFAM_REQ extends Message {
  private static final long serialVersionUID = 0L;

  public static final Integer DEFAULT_ROOMID = 0;
  public static final Long DEFAULT_USERID = 0L;
  public static final Integer DEFAULT_ADD_FAMILYID = 0;
  public static final String DEFAULT_APPACCOUNT = "";
  public static final String DEFAULT_DEMOTEXT = "";

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
   * �������ļ���ID
   */
  @ProtoField(tag = 3, type = INT32, label = REQUIRED)
  public final Integer add_familyid;

  /**
   * �û�ƽ̨�˺�
   */
  @ProtoField(tag = 4, type = STRING)
  public final String appaccount;

  /**
   * ������Ϣ����JSON
   */
  @ProtoField(tag = 5, type = STRING)
  public final String demotext;

  public PB_USER_ADDFAM_REQ(Integer roomid, Long userid, Integer add_familyid, String appaccount, String demotext) {
    this.roomid = roomid;
    this.userid = userid;
    this.add_familyid = add_familyid;
    this.appaccount = appaccount;
    this.demotext = demotext;
  }

  private PB_USER_ADDFAM_REQ(Builder builder) {
    this(builder.roomid, builder.userid, builder.add_familyid, builder.appaccount, builder.demotext);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_USER_ADDFAM_REQ)) return false;
    PB_USER_ADDFAM_REQ o = (PB_USER_ADDFAM_REQ) other;
    return equals(roomid, o.roomid)
        && equals(userid, o.userid)
        && equals(add_familyid, o.add_familyid)
        && equals(appaccount, o.appaccount)
        && equals(demotext, o.demotext);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = roomid != null ? roomid.hashCode() : 0;
      result = result * 37 + (userid != null ? userid.hashCode() : 0);
      result = result * 37 + (add_familyid != null ? add_familyid.hashCode() : 0);
      result = result * 37 + (appaccount != null ? appaccount.hashCode() : 0);
      result = result * 37 + (demotext != null ? demotext.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_USER_ADDFAM_REQ> {

    public Integer roomid;
    public Long userid;
    public Integer add_familyid;
    public String appaccount;
    public String demotext;

    public Builder() {
    }

    public Builder(PB_USER_ADDFAM_REQ message) {
      super(message);
      if (message == null) return;
      this.roomid = message.roomid;
      this.userid = message.userid;
      this.add_familyid = message.add_familyid;
      this.appaccount = message.appaccount;
      this.demotext = message.demotext;
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
     * �������ļ���ID
     */
    public Builder add_familyid(Integer add_familyid) {
      this.add_familyid = add_familyid;
      return this;
    }

    /**
     * �û�ƽ̨�˺�
     */
    public Builder appaccount(String appaccount) {
      this.appaccount = appaccount;
      return this;
    }

    /**
     * ������Ϣ����JSON
     */
    public Builder demotext(String demotext) {
      this.demotext = demotext;
      return this;
    }

    @Override
    public PB_USER_ADDFAM_REQ build() {
      checkRequiredFields();
      return new PB_USER_ADDFAM_REQ(this);
    }
  }
}