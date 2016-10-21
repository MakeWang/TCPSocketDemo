// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.BOOL;
import static com.squareup.wire.Message.Datatype.ENUM;
import static com.squareup.wire.Message.Label.REQUIRED;

/**
 * �����������û���Ϣ
 */
public final class PB_RS_GET_USERINFO extends Message {
  private static final long serialVersionUID = 0L;

  public static final Boolean DEFAULT_BFIND = false;
  public static final Boolean DEFAULT_BONLINE = true;
  public static final ePB_COM_USERSTATUS DEFAULT_STATUS = ePB_COM_USERSTATUS.OFFLINE;

  /**
   * �Ƿ��ҵ�
   */
  @ProtoField(tag = 1, type = BOOL, label = REQUIRED)
  public final Boolean bFind;

  /**
   * �û���Ϣ
   */
  @ProtoField(tag = 2)
  public final PB_RS_USERINFO userinfo;

  /**
   * �Ƿ�����
   */
  @ProtoField(tag = 3, type = BOOL)
  public final Boolean bOnline;

  /**
   * ����״̬
   */
  @ProtoField(tag = 4, type = ENUM)
  public final ePB_COM_USERSTATUS status;

  public PB_RS_GET_USERINFO(Boolean bFind, PB_RS_USERINFO userinfo, Boolean bOnline, ePB_COM_USERSTATUS status) {
    this.bFind = bFind;
    this.userinfo = userinfo;
    this.bOnline = bOnline;
    this.status = status;
  }

  private PB_RS_GET_USERINFO(Builder builder) {
    this(builder.bFind, builder.userinfo, builder.bOnline, builder.status);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_RS_GET_USERINFO)) return false;
    PB_RS_GET_USERINFO o = (PB_RS_GET_USERINFO) other;
    return equals(bFind, o.bFind)
        && equals(userinfo, o.userinfo)
        && equals(bOnline, o.bOnline)
        && equals(status, o.status);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = bFind != null ? bFind.hashCode() : 0;
      result = result * 37 + (userinfo != null ? userinfo.hashCode() : 0);
      result = result * 37 + (bOnline != null ? bOnline.hashCode() : 0);
      result = result * 37 + (status != null ? status.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_RS_GET_USERINFO> {

    public Boolean bFind;
    public PB_RS_USERINFO userinfo;
    public Boolean bOnline;
    public ePB_COM_USERSTATUS status;

    public Builder() {
    }

    public Builder(PB_RS_GET_USERINFO message) {
      super(message);
      if (message == null) return;
      this.bFind = message.bFind;
      this.userinfo = message.userinfo;
      this.bOnline = message.bOnline;
      this.status = message.status;
    }

    /**
     * �Ƿ��ҵ�
     */
    public Builder bFind(Boolean bFind) {
      this.bFind = bFind;
      return this;
    }

    /**
     * �û���Ϣ
     */
    public Builder userinfo(PB_RS_USERINFO userinfo) {
      this.userinfo = userinfo;
      return this;
    }

    /**
     * �Ƿ�����
     */
    public Builder bOnline(Boolean bOnline) {
      this.bOnline = bOnline;
      return this;
    }

    /**
     * ����״̬
     */
    public Builder status(ePB_COM_USERSTATUS status) {
      this.status = status;
      return this;
    }

    @Override
    public PB_RS_GET_USERINFO build() {
      checkRequiredFields();
      return new PB_RS_GET_USERINFO(this);
    }
  }
}
