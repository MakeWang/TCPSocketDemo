// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.ENUM;
import static com.squareup.wire.Message.Datatype.INT32;
import static com.squareup.wire.Message.Label.REQUIRED;

/**
 * ����Ӽ���(����)��Ϣ
 */
public final class PB_ADD_INFO extends Message {
  private static final long serialVersionUID = 0L;

  public static final eADD_TYPE DEFAULT_TYPE = eADD_TYPE.ADD_TYPE_ASK;
  public static final eADD_RESULT DEFAULT_RESULT = eADD_RESULT.ADD_AGREE;
  public static final Integer DEFAULT_TIME = 0;

  /**
   * ������
   */
  @ProtoField(tag = 1, label = REQUIRED)
  public final PB_USER req_user;

  /**
   * ����
   */
  @ProtoField(tag = 2, type = ENUM, label = REQUIRED)
  public final eADD_TYPE type;

  /**
   * ���
   */
  @ProtoField(tag = 3, type = ENUM)
  public final eADD_RESULT result;

  /**
   * �ظ���
   */
  @ProtoField(tag = 4)
  public final PB_USER rep_user;

  /**
   * ����(�ظ�)ʱ�� add by zm 2015/9/7
   */
  @ProtoField(tag = 5, type = INT32)
  public final Integer time;

  public PB_ADD_INFO(PB_USER req_user, eADD_TYPE type, eADD_RESULT result, PB_USER rep_user, Integer time) {
    this.req_user = req_user;
    this.type = type;
    this.result = result;
    this.rep_user = rep_user;
    this.time = time;
  }

  private PB_ADD_INFO(Builder builder) {
    this(builder.req_user, builder.type, builder.result, builder.rep_user, builder.time);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_ADD_INFO)) return false;
    PB_ADD_INFO o = (PB_ADD_INFO) other;
    return equals(req_user, o.req_user)
        && equals(type, o.type)
        && equals(result, o.result)
        && equals(rep_user, o.rep_user)
        && equals(time, o.time);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = req_user != null ? req_user.hashCode() : 0;
      result = result * 37 + (type != null ? type.hashCode() : 0);
      result = result * 37 + (this.result != null ? this.result.hashCode() : 0);
      result = result * 37 + (rep_user != null ? rep_user.hashCode() : 0);
      result = result * 37 + (time != null ? time.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_ADD_INFO> {

    public PB_USER req_user;
    public eADD_TYPE type;
    public eADD_RESULT result;
    public PB_USER rep_user;
    public Integer time;

    public Builder() {
    }

    public Builder(PB_ADD_INFO message) {
      super(message);
      if (message == null) return;
      this.req_user = message.req_user;
      this.type = message.type;
      this.result = message.result;
      this.rep_user = message.rep_user;
      this.time = message.time;
    }

    /**
     * ������
     */
    public Builder req_user(PB_USER req_user) {
      this.req_user = req_user;
      return this;
    }

    /**
     * ����
     */
    public Builder type(eADD_TYPE type) {
      this.type = type;
      return this;
    }

    /**
     * ���
     */
    public Builder result(eADD_RESULT result) {
      this.result = result;
      return this;
    }

    /**
     * �ظ���
     */
    public Builder rep_user(PB_USER rep_user) {
      this.rep_user = rep_user;
      return this;
    }

    /**
     * ����(�ظ�)ʱ�� add by zm 2015/9/7
     */
    public Builder time(Integer time) {
      this.time = time;
      return this;
    }

    @Override
    public PB_ADD_INFO build() {
      checkRequiredFields();
      return new PB_ADD_INFO(this);
    }
  }
}