// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.INT32;
import static com.squareup.wire.Message.Label.REQUIRED;

/**
 * ��������������ļ��峤�����Ա
 */
public final class PB_RS_FAMILY_ADDFAM_REQ extends Message {
  private static final long serialVersionUID = 0L;

  public static final Integer DEFAULT_ROOMID = 0;
  public static final Integer DEFAULT_ADD_FAMILYID = 0;
  public static final Integer DEFAULT_APPLYID = 0;
  public static final Integer DEFAULT_APPLYTIME = 0;

  /**
   * ����ID
   */
  @ProtoField(tag = 1, type = INT32, label = REQUIRED)
  public final Integer roomid;

  /**
   * ������û���Ϣ
   */
  @ProtoField(tag = 2, label = REQUIRED)
  public final PB_USER from_user;

  /**
   * �������ļ���ID
   */
  @ProtoField(tag = 3, type = INT32, label = REQUIRED)
  public final Integer add_familyid;

  /**
   * ������Ϣid
   */
  @ProtoField(tag = 4, type = INT32, label = REQUIRED)
  public final Integer applyid;

  /**
   * ����ʱ�� add by zm 2015/9/7
   */
  @ProtoField(tag = 5, type = INT32)
  public final Integer applytime;

  public PB_RS_FAMILY_ADDFAM_REQ(Integer roomid, PB_USER from_user, Integer add_familyid, Integer applyid, Integer applytime) {
    this.roomid = roomid;
    this.from_user = from_user;
    this.add_familyid = add_familyid;
    this.applyid = applyid;
    this.applytime = applytime;
  }

  private PB_RS_FAMILY_ADDFAM_REQ(Builder builder) {
    this(builder.roomid, builder.from_user, builder.add_familyid, builder.applyid, builder.applytime);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_RS_FAMILY_ADDFAM_REQ)) return false;
    PB_RS_FAMILY_ADDFAM_REQ o = (PB_RS_FAMILY_ADDFAM_REQ) other;
    return equals(roomid, o.roomid)
        && equals(from_user, o.from_user)
        && equals(add_familyid, o.add_familyid)
        && equals(applyid, o.applyid)
        && equals(applytime, o.applytime);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = roomid != null ? roomid.hashCode() : 0;
      result = result * 37 + (from_user != null ? from_user.hashCode() : 0);
      result = result * 37 + (add_familyid != null ? add_familyid.hashCode() : 0);
      result = result * 37 + (applyid != null ? applyid.hashCode() : 0);
      result = result * 37 + (applytime != null ? applytime.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_RS_FAMILY_ADDFAM_REQ> {

    public Integer roomid;
    public PB_USER from_user;
    public Integer add_familyid;
    public Integer applyid;
    public Integer applytime;

    public Builder() {
    }

    public Builder(PB_RS_FAMILY_ADDFAM_REQ message) {
      super(message);
      if (message == null) return;
      this.roomid = message.roomid;
      this.from_user = message.from_user;
      this.add_familyid = message.add_familyid;
      this.applyid = message.applyid;
      this.applytime = message.applytime;
    }

    /**
     * ����ID
     */
    public Builder roomid(Integer roomid) {
      this.roomid = roomid;
      return this;
    }

    /**
     * ������û���Ϣ
     */
    public Builder from_user(PB_USER from_user) {
      this.from_user = from_user;
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
     * ������Ϣid
     */
    public Builder applyid(Integer applyid) {
      this.applyid = applyid;
      return this;
    }

    /**
     * ����ʱ�� add by zm 2015/9/7
     */
    public Builder applytime(Integer applytime) {
      this.applytime = applytime;
      return this;
    }

    @Override
    public PB_RS_FAMILY_ADDFAM_REQ build() {
      checkRequiredFields();
      return new PB_RS_FAMILY_ADDFAM_REQ(this);
    }
  }
}
