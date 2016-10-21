// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.STRING;
import static com.squareup.wire.Message.Label.REQUIRED;

/**
 * web���ͻ�Ϊ�����˺�
 */
public final class PB_WEB_FRIENDS extends Message {
  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_ACCOUNT_ONE = "";
  public static final String DEFAULT_ACCOUNT_TWO = "";

  /**
   * �����˺�1
   */
  @ProtoField(tag = 1, type = STRING, label = REQUIRED)
  public final String account_one;

  /**
   * �����˺�2
   */
  @ProtoField(tag = 2, type = STRING, label = REQUIRED)
  public final String account_two;

  public PB_WEB_FRIENDS(String account_one, String account_two) {
    this.account_one = account_one;
    this.account_two = account_two;
  }

  private PB_WEB_FRIENDS(Builder builder) {
    this(builder.account_one, builder.account_two);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_WEB_FRIENDS)) return false;
    PB_WEB_FRIENDS o = (PB_WEB_FRIENDS) other;
    return equals(account_one, o.account_one)
        && equals(account_two, o.account_two);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = account_one != null ? account_one.hashCode() : 0;
      result = result * 37 + (account_two != null ? account_two.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_WEB_FRIENDS> {

    public String account_one;
    public String account_two;

    public Builder() {
    }

    public Builder(PB_WEB_FRIENDS message) {
      super(message);
      if (message == null) return;
      this.account_one = message.account_one;
      this.account_two = message.account_two;
    }

    /**
     * �����˺�1
     */
    public Builder account_one(String account_one) {
      this.account_one = account_one;
      return this;
    }

    /**
     * �����˺�2
     */
    public Builder account_two(String account_two) {
      this.account_two = account_two;
      return this;
    }

    @Override
    public PB_WEB_FRIENDS build() {
      checkRequiredFields();
      return new PB_WEB_FRIENDS(this);
    }
  }
}
