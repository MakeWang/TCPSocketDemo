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

/**
 * �ظ��б�
 */
public final class PB_RESPONSE_LISTS extends Message {
  private static final long serialVersionUID = 0L;

  public static final List<PB_INVITE_RESPONSE> DEFAULT_RESPONSE_ITEMS = Collections.emptyList();
  public static final Integer DEFAULT_MSG_CNT = 0;

  @ProtoField(tag = 1, label = REPEATED, messageType = PB_INVITE_RESPONSE.class)
  public final List<PB_INVITE_RESPONSE> response_items;

  /**
   * ��Ϣ����
   */
  @ProtoField(tag = 2, type = INT32, label = REQUIRED)
  public final Integer msg_cnt;

  public PB_RESPONSE_LISTS(List<PB_INVITE_RESPONSE> response_items, Integer msg_cnt) {
    this.response_items = immutableCopyOf(response_items);
    this.msg_cnt = msg_cnt;
  }

  private PB_RESPONSE_LISTS(Builder builder) {
    this(builder.response_items, builder.msg_cnt);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_RESPONSE_LISTS)) return false;
    PB_RESPONSE_LISTS o = (PB_RESPONSE_LISTS) other;
    return equals(response_items, o.response_items)
        && equals(msg_cnt, o.msg_cnt);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = response_items != null ? response_items.hashCode() : 1;
      result = result * 37 + (msg_cnt != null ? msg_cnt.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_RESPONSE_LISTS> {

    public List<PB_INVITE_RESPONSE> response_items;
    public Integer msg_cnt;

    public Builder() {
    }

    public Builder(PB_RESPONSE_LISTS message) {
      super(message);
      if (message == null) return;
      this.response_items = copyOf(message.response_items);
      this.msg_cnt = message.msg_cnt;
    }

    public Builder response_items(List<PB_INVITE_RESPONSE> response_items) {
      this.response_items = checkForNulls(response_items);
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
    public PB_RESPONSE_LISTS build() {
      checkRequiredFields();
      return new PB_RESPONSE_LISTS(this);
    }
  }
}
