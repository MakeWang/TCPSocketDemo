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
 * ��������������Ӻ��ѻظ�
 */
public final class PB_RS_ADDFRD_REP extends Message {
  private static final long serialVersionUID = 0L;

  public static final Integer DEFAULT_ROOMID = 0;
  public static final Long DEFAULT_REQUST_USERID = 0L;
  public static final ePB_ADDFRD_REPCMD DEFAULT_CTRL = ePB_ADDFRD_REPCMD.AFR_ACCEPT;

  /**
   * ����ID
   */
  @ProtoField(tag = 1, type = INT32, label = REQUIRED)
  public final Integer roomid;

  /**
   * ��������û���Ϣ
   */
  @ProtoField(tag = 2, label = REQUIRED)
  public final PB_USER to_user;

  /**
   * �������ҽ�ɫUID
   */
  @ProtoField(tag = 3, type = INT64, label = REQUIRED)
  public final Long requst_userid;

  /**
   * �ظ�����ֵ
   */
  @ProtoField(tag = 4, type = ENUM, label = REQUIRED)
  public final ePB_ADDFRD_REPCMD ctrl;

  public PB_RS_ADDFRD_REP(Integer roomid, PB_USER to_user, Long requst_userid, ePB_ADDFRD_REPCMD ctrl) {
    this.roomid = roomid;
    this.to_user = to_user;
    this.requst_userid = requst_userid;
    this.ctrl = ctrl;
  }

  private PB_RS_ADDFRD_REP(Builder builder) {
    this(builder.roomid, builder.to_user, builder.requst_userid, builder.ctrl);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_RS_ADDFRD_REP)) return false;
    PB_RS_ADDFRD_REP o = (PB_RS_ADDFRD_REP) other;
    return equals(roomid, o.roomid)
        && equals(to_user, o.to_user)
        && equals(requst_userid, o.requst_userid)
        && equals(ctrl, o.ctrl);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = roomid != null ? roomid.hashCode() : 0;
      result = result * 37 + (to_user != null ? to_user.hashCode() : 0);
      result = result * 37 + (requst_userid != null ? requst_userid.hashCode() : 0);
      result = result * 37 + (ctrl != null ? ctrl.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_RS_ADDFRD_REP> {

    public Integer roomid;
    public PB_USER to_user;
    public Long requst_userid;
    public ePB_ADDFRD_REPCMD ctrl;

    public Builder() {
    }

    public Builder(PB_RS_ADDFRD_REP message) {
      super(message);
      if (message == null) return;
      this.roomid = message.roomid;
      this.to_user = message.to_user;
      this.requst_userid = message.requst_userid;
      this.ctrl = message.ctrl;
    }

    /**
     * ����ID
     */
    public Builder roomid(Integer roomid) {
      this.roomid = roomid;
      return this;
    }

    /**
     * ��������û���Ϣ
     */
    public Builder to_user(PB_USER to_user) {
      this.to_user = to_user;
      return this;
    }

    /**
     * �������ҽ�ɫUID
     */
    public Builder requst_userid(Long requst_userid) {
      this.requst_userid = requst_userid;
      return this;
    }

    /**
     * �ظ�����ֵ
     */
    public Builder ctrl(ePB_ADDFRD_REPCMD ctrl) {
      this.ctrl = ctrl;
      return this;
    }

    @Override
    public PB_RS_ADDFRD_REP build() {
      checkRequiredFields();
      return new PB_RS_ADDFRD_REP(this);
    }
  }
}