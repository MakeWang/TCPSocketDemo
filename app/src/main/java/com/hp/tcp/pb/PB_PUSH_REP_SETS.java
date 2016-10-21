// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

import static com.squareup.wire.Message.Datatype.BOOL;
import static com.squareup.wire.Message.Label.REPEATED;
import static com.squareup.wire.Message.Label.REQUIRED;

/**
 * ������Ϣ�ظ�����
 */
public final class PB_PUSH_REP_SETS extends Message {
  private static final long serialVersionUID = 0L;

  public static final List<PB_PUSH_NOTICE_REP> DEFAULT_PUSHREP = Collections.emptyList();
  public static final Boolean DEFAULT_IFFIRST = false;
  public static final Boolean DEFAULT_IFEND = false;

  /**
   * ���ͻظ�����
   */
  @ProtoField(tag = 1, label = REPEATED, messageType = PB_PUSH_NOTICE_REP.class)
  public final List<PB_PUSH_NOTICE_REP> pushrep;

  /**
   * �Ƿ�����ʼ��
   */
  @ProtoField(tag = 2, type = BOOL, label = REQUIRED)
  public final Boolean iffirst;

  /**
   * �Ƿ��ǽ�����
   */
  @ProtoField(tag = 3, type = BOOL, label = REQUIRED)
  public final Boolean ifend;

  public PB_PUSH_REP_SETS(List<PB_PUSH_NOTICE_REP> pushrep, Boolean iffirst, Boolean ifend) {
    this.pushrep = immutableCopyOf(pushrep);
    this.iffirst = iffirst;
    this.ifend = ifend;
  }

  private PB_PUSH_REP_SETS(Builder builder) {
    this(builder.pushrep, builder.iffirst, builder.ifend);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_PUSH_REP_SETS)) return false;
    PB_PUSH_REP_SETS o = (PB_PUSH_REP_SETS) other;
    return equals(pushrep, o.pushrep)
        && equals(iffirst, o.iffirst)
        && equals(ifend, o.ifend);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = pushrep != null ? pushrep.hashCode() : 1;
      result = result * 37 + (iffirst != null ? iffirst.hashCode() : 0);
      result = result * 37 + (ifend != null ? ifend.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_PUSH_REP_SETS> {

    public List<PB_PUSH_NOTICE_REP> pushrep;
    public Boolean iffirst;
    public Boolean ifend;

    public Builder() {
    }

    public Builder(PB_PUSH_REP_SETS message) {
      super(message);
      if (message == null) return;
      this.pushrep = copyOf(message.pushrep);
      this.iffirst = message.iffirst;
      this.ifend = message.ifend;
    }

    /**
     * ���ͻظ�����
     */
    public Builder pushrep(List<PB_PUSH_NOTICE_REP> pushrep) {
      this.pushrep = checkForNulls(pushrep);
      return this;
    }

    /**
     * �Ƿ�����ʼ��
     */
    public Builder iffirst(Boolean iffirst) {
      this.iffirst = iffirst;
      return this;
    }

    /**
     * �Ƿ��ǽ�����
     */
    public Builder ifend(Boolean ifend) {
      this.ifend = ifend;
      return this;
    }

    @Override
    public PB_PUSH_REP_SETS build() {
      checkRequiredFields();
      return new PB_PUSH_REP_SETS(this);
    }
  }
}