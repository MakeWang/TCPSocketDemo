// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

import static com.squareup.wire.Message.Datatype.INT32;
import static com.squareup.wire.Message.Label.REPEATED;
import static com.squareup.wire.Message.Label.REQUIRED;

public final class PB_INVITE_LISTS extends Message {
  private static final long serialVersionUID = 0L;

  public static final List<PB_OPRATE_DATA_REP> DEFAULT_INVITE_ITEMS = Collections.emptyList();
  public static final Integer DEFAULT_MSG_CNT = 0;

  /**
   * �����б�
   */
  @ProtoField(tag = 1, label = REPEATED, messageType = PB_OPRATE_DATA_REP.class)
  public final List<PB_OPRATE_DATA_REP> invite_items;

  /**
   * ��Ϣ����
   */
  @ProtoField(tag = 2, type = INT32, label = REQUIRED)
  public final Integer msg_cnt;

  public PB_INVITE_LISTS(List<PB_OPRATE_DATA_REP> invite_items, Integer msg_cnt) {
    this.invite_items = immutableCopyOf(invite_items);
    this.msg_cnt = msg_cnt;
  }

  private PB_INVITE_LISTS(Builder builder) {
    this(builder.invite_items, builder.msg_cnt);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_INVITE_LISTS)) return false;
    PB_INVITE_LISTS o = (PB_INVITE_LISTS) other;
    return equals(invite_items, o.invite_items)
        && equals(msg_cnt, o.msg_cnt);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = invite_items != null ? invite_items.hashCode() : 1;
      result = result * 37 + (msg_cnt != null ? msg_cnt.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_INVITE_LISTS> {

    public List<PB_OPRATE_DATA_REP> invite_items;
    public Integer msg_cnt;

    public Builder() {
    }

    public Builder(PB_INVITE_LISTS message) {
      super(message);
      if (message == null) return;
      this.invite_items = copyOf(message.invite_items);
      this.msg_cnt = message.msg_cnt;
    }

    /**
     * �����б�
     */
    public Builder invite_items(List<PB_OPRATE_DATA_REP> invite_items) {
      this.invite_items = checkForNulls(invite_items);
      return this;
    }

    /**
     * ��Ϣ����
     */
    public Builder msg_cnt(Integer msg_cnt) {
      this.msg_cnt = msg_cnt;
      return this;
    }

    @Override
    public PB_INVITE_LISTS build() {
      checkRequiredFields();
      return new PB_INVITE_LISTS(this);
    }
  }
}
