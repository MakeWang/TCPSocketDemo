// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.INT32;
import static com.squareup.wire.Message.Datatype.INT64;
import static com.squareup.wire.Message.Datatype.STRING;
import static com.squareup.wire.Message.Label.REQUIRED;

/**
 * �û�
 */
public final class PB_USER extends Message {
  private static final long serialVersionUID = 0L;

  public static final Long DEFAULT_USERID = 0L;
  public static final String DEFAULT_NICKNAME = "";
  public static final String DEFAULT_HEAD = "";
  public static final String DEFAULT_ACCOUNT = "";
  public static final Integer DEFAULT_VIP = 0;
  public static final Integer DEFAULT_LEVEL = 0;
  public static final Long DEFAULT_PRETTYNUM = 0L;

  /**
   * ID
   */
  @ProtoField(tag = 1, type = INT64, label = REQUIRED)
  public final Long userid;

  /**
   * �ǳ�
   */
  @ProtoField(tag = 2, type = STRING, label = REQUIRED)
  public final String nickname;

  /**
   * ͷ��
   */
  @ProtoField(tag = 3, type = STRING, label = REQUIRED)
  public final String head;

  /**
   * �û��˺�
   */
  @ProtoField(tag = 4, type = STRING)
  public final String account;

  /**
   * VIP
   */
  @ProtoField(tag = 5, type = INT32)
  public final Integer vip;

  /**
   * �ȼ�
   */
  @ProtoField(tag = 6, type = INT32)
  public final Integer level;

  /**
   * ����
   */
  @ProtoField(tag = 7, type = INT64)
  public final Long prettynum;

  public PB_USER(Long userid, String nickname, String head, String account, Integer vip, Integer level, Long prettynum) {
    this.userid = userid;
    this.nickname = nickname;
    this.head = head;
    this.account = account;
    this.vip = vip;
    this.level = level;
    this.prettynum = prettynum;
  }

  private PB_USER(Builder builder) {
    this(builder.userid, builder.nickname, builder.head, builder.account, builder.vip, builder.level, builder.prettynum);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_USER)) return false;
    PB_USER o = (PB_USER) other;
    return equals(userid, o.userid)
        && equals(nickname, o.nickname)
        && equals(head, o.head)
        && equals(account, o.account)
        && equals(vip, o.vip)
        && equals(level, o.level)
        && equals(prettynum, o.prettynum);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = userid != null ? userid.hashCode() : 0;
      result = result * 37 + (nickname != null ? nickname.hashCode() : 0);
      result = result * 37 + (head != null ? head.hashCode() : 0);
      result = result * 37 + (account != null ? account.hashCode() : 0);
      result = result * 37 + (vip != null ? vip.hashCode() : 0);
      result = result * 37 + (level != null ? level.hashCode() : 0);
      result = result * 37 + (prettynum != null ? prettynum.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_USER> {

    public Long userid;
    public String nickname;
    public String head;
    public String account;
    public Integer vip;
    public Integer level;
    public Long prettynum;

    public Builder() {
    }

    public Builder(PB_USER message) {
      super(message);
      if (message == null) return;
      this.userid = message.userid;
      this.nickname = message.nickname;
      this.head = message.head;
      this.account = message.account;
      this.vip = message.vip;
      this.level = message.level;
      this.prettynum = message.prettynum;
    }

    /**
     * ID
     */
    public Builder userid(Long userid) {
      this.userid = userid;
      return this;
    }

    /**
     * �ǳ�
     */
    public Builder nickname(String nickname) {
      this.nickname = nickname;
      return this;
    }

    /**
     * ͷ��
     */
    public Builder head(String head) {
      this.head = head;
      return this;
    }

    /**
     * �û��˺�
     */
    public Builder account(String account) {
      this.account = account;
      return this;
    }

    /**
     * VIP
     */
    public Builder vip(Integer vip) {
      this.vip = vip;
      return this;
    }

    /**
     * �ȼ�
     */
    public Builder level(Integer level) {
      this.level = level;
      return this;
    }

    /**
     * ����
     */
    public Builder prettynum(Long prettynum) {
      this.prettynum = prettynum;
      return this;
    }

    @Override
    public PB_USER build() {
      checkRequiredFields();
      return new PB_USER(this);
    }
  }
}