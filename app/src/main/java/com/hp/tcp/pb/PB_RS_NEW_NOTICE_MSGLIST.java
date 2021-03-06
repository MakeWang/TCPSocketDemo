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

public final class PB_RS_NEW_NOTICE_MSGLIST extends Message {
  private static final long serialVersionUID = 0L;

  public static final Integer DEFAULT_ALLCNT = 0;
  public static final List<PB_NEW_NOTICE_MSG> DEFAULT_ITEMS = Collections.emptyList();

  /**
   * ��Ϣ����
   */
  @ProtoField(tag = 1, type = INT32, label = REQUIRED)
  public final Integer allcnt;

  /**
   * δ����Ϣ�б�
   */
  @ProtoField(tag = 2, label = REPEATED, messageType = PB_NEW_NOTICE_MSG.class)
  public final List<PB_NEW_NOTICE_MSG> items;

  public PB_RS_NEW_NOTICE_MSGLIST(Integer allcnt, List<PB_NEW_NOTICE_MSG> items) {
    this.allcnt = allcnt;
    this.items = immutableCopyOf(items);
  }

  private PB_RS_NEW_NOTICE_MSGLIST(Builder builder) {
    this(builder.allcnt, builder.items);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_RS_NEW_NOTICE_MSGLIST)) return false;
    PB_RS_NEW_NOTICE_MSGLIST o = (PB_RS_NEW_NOTICE_MSGLIST) other;
    return equals(allcnt, o.allcnt)
        && equals(items, o.items);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = allcnt != null ? allcnt.hashCode() : 0;
      result = result * 37 + (items != null ? items.hashCode() : 1);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_RS_NEW_NOTICE_MSGLIST> {

    public Integer allcnt;
    public List<PB_NEW_NOTICE_MSG> items;

    public Builder() {
    }

    public Builder(PB_RS_NEW_NOTICE_MSGLIST message) {
      super(message);
      if (message == null) return;
      this.allcnt = message.allcnt;
      this.items = copyOf(message.items);
    }

    /**
     * ��Ϣ����
     */
    public Builder allcnt(Integer allcnt) {
      this.allcnt = allcnt;
      return this;
    }

    /**
     * δ����Ϣ�б�
     */
    public Builder items(List<PB_NEW_NOTICE_MSG> items) {
      this.items = checkForNulls(items);
      return this;
    }

    @Override
    public PB_RS_NEW_NOTICE_MSGLIST build() {
      checkRequiredFields();
      return new PB_RS_NEW_NOTICE_MSGLIST(this);
    }
  }
}
