// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

import static com.squareup.wire.Message.Datatype.BOOL;
import static com.squareup.wire.Message.Datatype.INT64;
import static com.squareup.wire.Message.Label.REPEATED;
import static com.squareup.wire.Message.Label.REQUIRED;

/**
 * �����������̼��б�
 */
public final class PB_SELLERS_SHOW extends Message {
  private static final long serialVersionUID = 0L;

  public static final Long DEFAULT_USERID = 0L;
  public static final List<PB_SELLER_PUBLISH> DEFAULT_PUB_LIST = Collections.emptyList();
  public static final Boolean DEFAULT_IS_END = false;

  /**
   * ������id
   */
  @ProtoField(tag = 1, type = INT64, label = REQUIRED)
  public final Long userid;

  /**
   * ���������̼��б�
   */
  @ProtoField(tag = 2, label = REPEATED, messageType = PB_SELLER_PUBLISH.class)
  public final List<PB_SELLER_PUBLISH> pub_list;

  /**
   * �Ƿ���ȡ��һ����
   */
  @ProtoField(tag = 3, type = BOOL)
  public final Boolean is_end;

  public PB_SELLERS_SHOW(Long userid, List<PB_SELLER_PUBLISH> pub_list, Boolean is_end) {
    this.userid = userid;
    this.pub_list = immutableCopyOf(pub_list);
    this.is_end = is_end;
  }

  private PB_SELLERS_SHOW(Builder builder) {
    this(builder.userid, builder.pub_list, builder.is_end);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_SELLERS_SHOW)) return false;
    PB_SELLERS_SHOW o = (PB_SELLERS_SHOW) other;
    return equals(userid, o.userid)
        && equals(pub_list, o.pub_list)
        && equals(is_end, o.is_end);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = userid != null ? userid.hashCode() : 0;
      result = result * 37 + (pub_list != null ? pub_list.hashCode() : 1);
      result = result * 37 + (is_end != null ? is_end.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_SELLERS_SHOW> {

    public Long userid;
    public List<PB_SELLER_PUBLISH> pub_list;
    public Boolean is_end;

    public Builder() {
    }

    public Builder(PB_SELLERS_SHOW message) {
      super(message);
      if (message == null) return;
      this.userid = message.userid;
      this.pub_list = copyOf(message.pub_list);
      this.is_end = message.is_end;
    }

    /**
     * ������id
     */
    public Builder userid(Long userid) {
      this.userid = userid;
      return this;
    }

    /**
     * ���������̼��б�
     */
    public Builder pub_list(List<PB_SELLER_PUBLISH> pub_list) {
      this.pub_list = checkForNulls(pub_list);
      return this;
    }

    /**
     * �Ƿ���ȡ��һ����
     */
    public Builder is_end(Boolean is_end) {
      this.is_end = is_end;
      return this;
    }

    @Override
    public PB_SELLERS_SHOW build() {
      checkRequiredFields();
      return new PB_SELLERS_SHOW(this);
    }
  }
}
