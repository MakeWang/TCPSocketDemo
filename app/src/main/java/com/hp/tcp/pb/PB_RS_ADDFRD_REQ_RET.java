// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.ENUM;
import static com.squareup.wire.Message.Datatype.INT64;
import static com.squareup.wire.Message.Label.REQUIRED;

/**
 * ����������������
 */
public final class PB_RS_ADDFRD_REQ_RET extends Message {
  private static final long serialVersionUID = 0L;

  public static final ePB_ADDFRD_REQ_RET DEFAULT_RET = ePB_ADDFRD_REQ_RET.ADDFRD_REQ_SUCC;
  public static final Long DEFAULT_TO_USERID = 0L;

  /**
   * ���
   */
  @ProtoField(tag = 1, type = ENUM, label = REQUIRED)
  public final ePB_ADDFRD_REQ_RET ret;

  /**
   * �������UID
   */
  @ProtoField(tag = 4, type = INT64, label = REQUIRED)
  public final Long to_userid;

  public PB_RS_ADDFRD_REQ_RET(ePB_ADDFRD_REQ_RET ret, Long to_userid) {
    this.ret = ret;
    this.to_userid = to_userid;
  }

  private PB_RS_ADDFRD_REQ_RET(Builder builder) {
    this(builder.ret, builder.to_userid);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_RS_ADDFRD_REQ_RET)) return false;
    PB_RS_ADDFRD_REQ_RET o = (PB_RS_ADDFRD_REQ_RET) other;
    return equals(ret, o.ret)
        && equals(to_userid, o.to_userid);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = ret != null ? ret.hashCode() : 0;
      result = result * 37 + (to_userid != null ? to_userid.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_RS_ADDFRD_REQ_RET> {

    public ePB_ADDFRD_REQ_RET ret;
    public Long to_userid;

    public Builder() {
    }

    public Builder(PB_RS_ADDFRD_REQ_RET message) {
      super(message);
      if (message == null) return;
      this.ret = message.ret;
      this.to_userid = message.to_userid;
    }

    /**
     * ���
     */
    public Builder ret(ePB_ADDFRD_REQ_RET ret) {
      this.ret = ret;
      return this;
    }

    /**
     * �������UID
     */
    public Builder to_userid(Long to_userid) {
      this.to_userid = to_userid;
      return this;
    }

    @Override
    public PB_RS_ADDFRD_REQ_RET build() {
      checkRequiredFields();
      return new PB_RS_ADDFRD_REQ_RET(this);
    }
  }
}
