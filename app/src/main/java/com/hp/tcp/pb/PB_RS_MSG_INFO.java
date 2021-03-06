// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.INT64;
import static com.squareup.wire.Message.Label.REQUIRED;

public final class PB_RS_MSG_INFO extends Message {
  private static final long serialVersionUID = 0L;

  public static final Long DEFAULT_MSG_ID = 0L;

  /**
   * �������Ϣ���
   */
  @ProtoField(tag = 1, type = INT64, label = REQUIRED)
  public final Long msg_id;

  /**
   * ��Ϣ����
   */
  @ProtoField(tag = 2, label = REQUIRED)
  public final PB_MESSAGE msg_data;

  /**
   * ������
   */
  @ProtoField(tag = 3)
  public final PB_USER from_user;

  /**
   * ������
   */
  @ProtoField(tag = 4)
  public final PB_USER to_user;

  public PB_RS_MSG_INFO(Long msg_id, PB_MESSAGE msg_data, PB_USER from_user, PB_USER to_user) {
    this.msg_id = msg_id;
    this.msg_data = msg_data;
    this.from_user = from_user;
    this.to_user = to_user;
  }

  private PB_RS_MSG_INFO(Builder builder) {
    this(builder.msg_id, builder.msg_data, builder.from_user, builder.to_user);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_RS_MSG_INFO)) return false;
    PB_RS_MSG_INFO o = (PB_RS_MSG_INFO) other;
    return equals(msg_id, o.msg_id)
        && equals(msg_data, o.msg_data)
        && equals(from_user, o.from_user)
        && equals(to_user, o.to_user);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = msg_id != null ? msg_id.hashCode() : 0;
      result = result * 37 + (msg_data != null ? msg_data.hashCode() : 0);
      result = result * 37 + (from_user != null ? from_user.hashCode() : 0);
      result = result * 37 + (to_user != null ? to_user.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_RS_MSG_INFO> {

    public Long msg_id;
    public PB_MESSAGE msg_data;
    public PB_USER from_user;
    public PB_USER to_user;

    public Builder() {
    }

    public Builder(PB_RS_MSG_INFO message) {
      super(message);
      if (message == null) return;
      this.msg_id = message.msg_id;
      this.msg_data = message.msg_data;
      this.from_user = message.from_user;
      this.to_user = message.to_user;
    }

    /**
     * �������Ϣ���
     */
    public Builder msg_id(Long msg_id) {
      this.msg_id = msg_id;
      return this;
    }

    /**
     * ��Ϣ����
     */
    public Builder msg_data(PB_MESSAGE msg_data) {
      this.msg_data = msg_data;
      return this;
    }

    /**
     * ������
     */
    public Builder from_user(PB_USER from_user) {
      this.from_user = from_user;
      return this;
    }

    /**
     * ������
     */
    public Builder to_user(PB_USER to_user) {
      this.to_user = to_user;
      return this;
    }

    @Override
    public PB_RS_MSG_INFO build() {
      checkRequiredFields();
      return new PB_RS_MSG_INFO(this);
    }
  }
}
