// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.ENUM;
import static com.squareup.wire.Message.Datatype.INT64;
import static com.squareup.wire.Message.Label.REQUIRED;

/**
 * �û��˳���������
 */
public final class PB_EXIT_TALKGROUP_REP extends Message {
  private static final long serialVersionUID = 0L;

  public static final eRS_EXIT_TG_Ret DEFAULT_RET = eRS_EXIT_TG_Ret.eRS_EXIT_TG_SUC;
  public static final Long DEFAULT_TGID = 0L;

  /**
   * ���
   */
  @ProtoField(tag = 1, type = ENUM, label = REQUIRED)
  public final eRS_EXIT_TG_Ret ret;

  /**
   * ������ID
   */
  @ProtoField(tag = 2, type = INT64, label = REQUIRED)
  public final Long tgid;

  public PB_EXIT_TALKGROUP_REP(eRS_EXIT_TG_Ret ret, Long tgid) {
    this.ret = ret;
    this.tgid = tgid;
  }

  private PB_EXIT_TALKGROUP_REP(Builder builder) {
    this(builder.ret, builder.tgid);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_EXIT_TALKGROUP_REP)) return false;
    PB_EXIT_TALKGROUP_REP o = (PB_EXIT_TALKGROUP_REP) other;
    return equals(ret, o.ret)
        && equals(tgid, o.tgid);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = ret != null ? ret.hashCode() : 0;
      result = result * 37 + (tgid != null ? tgid.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_EXIT_TALKGROUP_REP> {

    public eRS_EXIT_TG_Ret ret;
    public Long tgid;

    public Builder() {
    }

    public Builder(PB_EXIT_TALKGROUP_REP message) {
      super(message);
      if (message == null) return;
      this.ret = message.ret;
      this.tgid = message.tgid;
    }

    /**
     * ���
     */
    public Builder ret(eRS_EXIT_TG_Ret ret) {
      this.ret = ret;
      return this;
    }

    /**
     * ������ID
     */
    public Builder tgid(Long tgid) {
      this.tgid = tgid;
      return this;
    }

    @Override
    public PB_EXIT_TALKGROUP_REP build() {
      checkRequiredFields();
      return new PB_EXIT_TALKGROUP_REP(this);
    }
  }
}