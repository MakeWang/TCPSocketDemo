// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.INT64;
import static com.squareup.wire.Message.Datatype.STRING;
import static com.squareup.wire.Message.Label.REQUIRED;

/**
 * ��ע��ؽṹ
 */
public final class PB_PAY_ATTENTION extends Message {
  private static final long serialVersionUID = 0L;

  public static final Long DEFAULT_USERID = 0L;
  public static final String DEFAULT_ACCOUNT = "";

  @ProtoField(tag = 1, type = INT64, label = REQUIRED)
  public final Long userid;

  @ProtoField(tag = 2, type = STRING, label = REQUIRED)
  public final String account;

  public PB_PAY_ATTENTION(Long userid, String account) {
    this.userid = userid;
    this.account = account;
  }

  private PB_PAY_ATTENTION(Builder builder) {
    this(builder.userid, builder.account);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_PAY_ATTENTION)) return false;
    PB_PAY_ATTENTION o = (PB_PAY_ATTENTION) other;
    return equals(userid, o.userid)
        && equals(account, o.account);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = userid != null ? userid.hashCode() : 0;
      result = result * 37 + (account != null ? account.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_PAY_ATTENTION> {

    public Long userid;
    public String account;

    public Builder() {
    }

    public Builder(PB_PAY_ATTENTION message) {
      super(message);
      if (message == null) return;
      this.userid = message.userid;
      this.account = message.account;
    }

    public Builder userid(Long userid) {
      this.userid = userid;
      return this;
    }

    public Builder account(String account) {
      this.account = account;
      return this;
    }

    @Override
    public PB_PAY_ATTENTION build() {
      checkRequiredFields();
      return new PB_PAY_ATTENTION(this);
    }
  }
}
