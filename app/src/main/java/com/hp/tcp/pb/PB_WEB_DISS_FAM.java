// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.INT32;
import static com.squareup.wire.Message.Datatype.STRING;
import static com.squareup.wire.Message.Label.REQUIRED;

/**
 * web��̨�������
 */
public final class PB_WEB_DISS_FAM extends Message {
  private static final long serialVersionUID = 0L;

  public static final Integer DEFAULT_FAMILYID = 0;
  public static final String DEFAULT_WEBUID = "";
  public static final String DEFAULT_NAME = "";
  public static final String DEFAULT_DISS_REASON = "";

  /**
   * ����id
   */
  @ProtoField(tag = 1, type = INT32, label = REQUIRED)
  public final Integer familyid;

  /**
   * web�����û���ʶ
   */
  @ProtoField(tag = 2, type = STRING, label = REQUIRED)
  public final String webuid;

  /**
   * web�����û��س�
   */
  @ProtoField(tag = 3, type = STRING)
  public final String name;

  /**
   * ���ԭ��
   */
  @ProtoField(tag = 4, type = STRING)
  public final String diss_reason;

  public PB_WEB_DISS_FAM(Integer familyid, String webuid, String name, String diss_reason) {
    this.familyid = familyid;
    this.webuid = webuid;
    this.name = name;
    this.diss_reason = diss_reason;
  }

  private PB_WEB_DISS_FAM(Builder builder) {
    this(builder.familyid, builder.webuid, builder.name, builder.diss_reason);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_WEB_DISS_FAM)) return false;
    PB_WEB_DISS_FAM o = (PB_WEB_DISS_FAM) other;
    return equals(familyid, o.familyid)
        && equals(webuid, o.webuid)
        && equals(name, o.name)
        && equals(diss_reason, o.diss_reason);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = familyid != null ? familyid.hashCode() : 0;
      result = result * 37 + (webuid != null ? webuid.hashCode() : 0);
      result = result * 37 + (name != null ? name.hashCode() : 0);
      result = result * 37 + (diss_reason != null ? diss_reason.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_WEB_DISS_FAM> {

    public Integer familyid;
    public String webuid;
    public String name;
    public String diss_reason;

    public Builder() {
    }

    public Builder(PB_WEB_DISS_FAM message) {
      super(message);
      if (message == null) return;
      this.familyid = message.familyid;
      this.webuid = message.webuid;
      this.name = message.name;
      this.diss_reason = message.diss_reason;
    }

    /**
     * ����id
     */
    public Builder familyid(Integer familyid) {
      this.familyid = familyid;
      return this;
    }

    /**
     * web�����û���ʶ
     */
    public Builder webuid(String webuid) {
      this.webuid = webuid;
      return this;
    }

    /**
     * web�����û��س�
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * ���ԭ��
     */
    public Builder diss_reason(String diss_reason) {
      this.diss_reason = diss_reason;
      return this;
    }

    @Override
    public PB_WEB_DISS_FAM build() {
      checkRequiredFields();
      return new PB_WEB_DISS_FAM(this);
    }
  }
}