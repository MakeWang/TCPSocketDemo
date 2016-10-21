// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.ENUM;
import static com.squareup.wire.Message.Datatype.INT32;
import static com.squareup.wire.Message.Label.REQUIRED;

public final class PB_CREATE_FAMILY_REP extends Message {
  private static final long serialVersionUID = 0L;

  public static final eRS_Create_Family_Ret DEFAULT_CRET = eRS_Create_Family_Ret.RS_CF_SUCC;
  public static final Integer DEFAULT_ROOMID = 0;

  /**
   * �������巵��ֵ
   */
  @ProtoField(tag = 1, type = ENUM, label = REQUIRED)
  public final eRS_Create_Family_Ret cRet;

  /**
   * ���صļ�����Ϣ
   */
  @ProtoField(tag = 2)
  public final PB_FAMILY familyinfo;

  /**
   * ����id
   */
  @ProtoField(tag = 3, type = INT32)
  public final Integer roomid;

  public PB_CREATE_FAMILY_REP(eRS_Create_Family_Ret cRet, PB_FAMILY familyinfo, Integer roomid) {
    this.cRet = cRet;
    this.familyinfo = familyinfo;
    this.roomid = roomid;
  }

  private PB_CREATE_FAMILY_REP(Builder builder) {
    this(builder.cRet, builder.familyinfo, builder.roomid);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_CREATE_FAMILY_REP)) return false;
    PB_CREATE_FAMILY_REP o = (PB_CREATE_FAMILY_REP) other;
    return equals(cRet, o.cRet)
        && equals(familyinfo, o.familyinfo)
        && equals(roomid, o.roomid);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = cRet != null ? cRet.hashCode() : 0;
      result = result * 37 + (familyinfo != null ? familyinfo.hashCode() : 0);
      result = result * 37 + (roomid != null ? roomid.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_CREATE_FAMILY_REP> {

    public eRS_Create_Family_Ret cRet;
    public PB_FAMILY familyinfo;
    public Integer roomid;

    public Builder() {
    }

    public Builder(PB_CREATE_FAMILY_REP message) {
      super(message);
      if (message == null) return;
      this.cRet = message.cRet;
      this.familyinfo = message.familyinfo;
      this.roomid = message.roomid;
    }

    /**
     * �������巵��ֵ
     */
    public Builder cRet(eRS_Create_Family_Ret cRet) {
      this.cRet = cRet;
      return this;
    }

    /**
     * ���صļ�����Ϣ
     */
    public Builder familyinfo(PB_FAMILY familyinfo) {
      this.familyinfo = familyinfo;
      return this;
    }

    /**
     * ����id
     */
    public Builder roomid(Integer roomid) {
      this.roomid = roomid;
      return this;
    }

    @Override
    public PB_CREATE_FAMILY_REP build() {
      checkRequiredFields();
      return new PB_CREATE_FAMILY_REP(this);
    }
  }
}
