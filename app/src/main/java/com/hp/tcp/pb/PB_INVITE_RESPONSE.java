// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.INT64;
import static com.squareup.wire.Message.Datatype.STRING;
import static com.squareup.wire.Message.Label.REQUIRED;

/**
 * �ظ�����Ϣ
 */
public final class PB_INVITE_RESPONSE extends Message {
  private static final long serialVersionUID = 0L;

  public static final Long DEFAULT_USERID = 0L;
  public static final String DEFAULT_HEADURL = "";
  public static final String DEFAULT_NICKNAME = "";

  @ProtoField(tag = 1, type = INT64, label = REQUIRED)
  public final Long userid;

  @ProtoField(tag = 2, type = STRING, label = REQUIRED)
  public final String headurl;

  @ProtoField(tag = 3, type = STRING, label = REQUIRED)
  public final String nickname;

  public PB_INVITE_RESPONSE(Long userid, String headurl, String nickname) {
    this.userid = userid;
    this.headurl = headurl;
    this.nickname = nickname;
  }

  private PB_INVITE_RESPONSE(Builder builder) {
    this(builder.userid, builder.headurl, builder.nickname);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_INVITE_RESPONSE)) return false;
    PB_INVITE_RESPONSE o = (PB_INVITE_RESPONSE) other;
    return equals(userid, o.userid)
        && equals(headurl, o.headurl)
        && equals(nickname, o.nickname);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = userid != null ? userid.hashCode() : 0;
      result = result * 37 + (headurl != null ? headurl.hashCode() : 0);
      result = result * 37 + (nickname != null ? nickname.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_INVITE_RESPONSE> {

    public Long userid;
    public String headurl;
    public String nickname;

    public Builder() {
    }

    public Builder(PB_INVITE_RESPONSE message) {
      super(message);
      if (message == null) return;
      this.userid = message.userid;
      this.headurl = message.headurl;
      this.nickname = message.nickname;
    }

    public Builder userid(Long userid) {
      this.userid = userid;
      return this;
    }

    public Builder headurl(String headurl) {
      this.headurl = headurl;
      return this;
    }

    public Builder nickname(String nickname) {
      this.nickname = nickname;
      return this;
    }

    @Override
    public PB_INVITE_RESPONSE build() {
      checkRequiredFields();
      return new PB_INVITE_RESPONSE(this);
    }
  }
}
