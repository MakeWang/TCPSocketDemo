// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.BOOL;
import static com.squareup.wire.Message.Datatype.INT64;
import static com.squareup.wire.Message.Label.REQUIRED;

/**
 * �����������¼Ӻ�����Ϣ
 */
public final class PB_RS_ADDFRD extends Message {
  private static final long serialVersionUID = 0L;

  public static final Long DEFAULT_USERID = 0L;
  public static final Boolean DEFAULT_IS_REQUEST = false;

  /**
   * UID
   */
  @ProtoField(tag = 1, type = INT64, label = REQUIRED)
  public final Long userid;

  /**
   * �û��Ƿ����뷽
   */
  @ProtoField(tag = 2, type = BOOL, label = REQUIRED)
  public final Boolean is_request;

  /**
   * �Է����ѵ���Ϣ
   */
  @ProtoField(tag = 3)
  public final PB_FRIEND_ITEM frd_info;

  public PB_RS_ADDFRD(Long userid, Boolean is_request, PB_FRIEND_ITEM frd_info) {
    this.userid = userid;
    this.is_request = is_request;
    this.frd_info = frd_info;
  }

  private PB_RS_ADDFRD(Builder builder) {
    this(builder.userid, builder.is_request, builder.frd_info);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_RS_ADDFRD)) return false;
    PB_RS_ADDFRD o = (PB_RS_ADDFRD) other;
    return equals(userid, o.userid)
        && equals(is_request, o.is_request)
        && equals(frd_info, o.frd_info);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = userid != null ? userid.hashCode() : 0;
      result = result * 37 + (is_request != null ? is_request.hashCode() : 0);
      result = result * 37 + (frd_info != null ? frd_info.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_RS_ADDFRD> {

    public Long userid;
    public Boolean is_request;
    public PB_FRIEND_ITEM frd_info;

    public Builder() {
    }

    public Builder(PB_RS_ADDFRD message) {
      super(message);
      if (message == null) return;
      this.userid = message.userid;
      this.is_request = message.is_request;
      this.frd_info = message.frd_info;
    }

    /**
     * UID
     */
    public Builder userid(Long userid) {
      this.userid = userid;
      return this;
    }

    /**
     * �û��Ƿ����뷽
     */
    public Builder is_request(Boolean is_request) {
      this.is_request = is_request;
      return this;
    }

    /**
     * �Է����ѵ���Ϣ
     */
    public Builder frd_info(PB_FRIEND_ITEM frd_info) {
      this.frd_info = frd_info;
      return this;
    }

    @Override
    public PB_RS_ADDFRD build() {
      checkRequiredFields();
      return new PB_RS_ADDFRD(this);
    }
  }
}
