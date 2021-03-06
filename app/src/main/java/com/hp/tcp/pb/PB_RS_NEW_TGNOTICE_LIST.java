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
 * ����������δ��������֪ͨ��Ϣ�б�
 */
public final class PB_RS_NEW_TGNOTICE_LIST extends Message {
  private static final long serialVersionUID = 0L;

  public static final Integer DEFAULT_COUNT = 0;
  public static final List<PB_TALKGROUP_NOTICE> DEFAULT_ITEMS = Collections.emptyList();

  /**
   * ����
   */
  @ProtoField(tag = 1, type = INT32, label = REQUIRED)
  public final Integer count;

  /**
   * ������֪ͨ��Ϣ�б�
   */
  @ProtoField(tag = 2, label = REPEATED, messageType = PB_TALKGROUP_NOTICE.class)
  public final List<PB_TALKGROUP_NOTICE> items;

  public PB_RS_NEW_TGNOTICE_LIST(Integer count, List<PB_TALKGROUP_NOTICE> items) {
    this.count = count;
    this.items = immutableCopyOf(items);
  }

  private PB_RS_NEW_TGNOTICE_LIST(Builder builder) {
    this(builder.count, builder.items);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_RS_NEW_TGNOTICE_LIST)) return false;
    PB_RS_NEW_TGNOTICE_LIST o = (PB_RS_NEW_TGNOTICE_LIST) other;
    return equals(count, o.count)
        && equals(items, o.items);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = count != null ? count.hashCode() : 0;
      result = result * 37 + (items != null ? items.hashCode() : 1);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_RS_NEW_TGNOTICE_LIST> {

    public Integer count;
    public List<PB_TALKGROUP_NOTICE> items;

    public Builder() {
    }

    public Builder(PB_RS_NEW_TGNOTICE_LIST message) {
      super(message);
      if (message == null) return;
      this.count = message.count;
      this.items = copyOf(message.items);
    }

    /**
     * ����
     */
    public Builder count(Integer count) {
      this.count = count;
      return this;
    }

    /**
     * ������֪ͨ��Ϣ�б�
     */
    public Builder items(List<PB_TALKGROUP_NOTICE> items) {
      this.items = checkForNulls(items);
      return this;
    }

    @Override
    public PB_RS_NEW_TGNOTICE_LIST build() {
      checkRequiredFields();
      return new PB_RS_NEW_TGNOTICE_LIST(this);
    }
  }
}
