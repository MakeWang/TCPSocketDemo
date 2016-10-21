// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.ENUM;
import static com.squareup.wire.Message.Datatype.INT32;
import static com.squareup.wire.Message.Datatype.INT64;
import static com.squareup.wire.Message.Datatype.STRING;
import static com.squareup.wire.Message.Label.REQUIRED;

public final class PB_RS_USER_BASIC extends Message {
  private static final long serialVersionUID = 0L;

  public static final Long DEFAULT_USERID = 0L;
  public static final String DEFAULT_NICKNAME = "";
  public static final ePB_COM_SEX DEFAULT_SEX = ePB_COM_SEX.SEX_BOY;
  public static final String DEFAULT_HEADURL = "";
  public static final Long DEFAULT_COIN = 0L;
  public static final Integer DEFAULT_LEVEL = 0;
  public static final Integer DEFAULT_VIP = 0;
  public static final Long DEFAULT_PRETTYNUM = 0L;
  public static final ePB_COM_JOB DEFAULT_JOB = ePB_COM_JOB.PLAYER;

  /**
   * user id  in chat system
   */
  @ProtoField(tag = 1, type = INT64, label = REQUIRED)
  public final Long userid;

  /**
   * �س�
   */
  @ProtoField(tag = 2, type = STRING, label = REQUIRED)
  public final String nickname;

  /**
   * �Ա�
   */
  @ProtoField(tag = 3, type = ENUM)
  public final ePB_COM_SEX sex;

  /**
   * ͷ��
   */
  @ProtoField(tag = 4, type = STRING)
  public final String headurl;

  /**
   * ���ֵ
   */
  @ProtoField(tag = 5, type = INT64)
  public final Long coin;

  /**
   * �ȼ�
   */
  @ProtoField(tag = 6, type = INT32)
  public final Integer level;

  /**
   * VIP
   */
  @ProtoField(tag = 7, type = INT32)
  public final Integer vip;

  /**
   * ����
   */
  @ProtoField(tag = 8, type = INT64)
  public final Long prettynum;

  /**
   * ְҵ
   */
  @ProtoField(tag = 9, type = ENUM)
  public final ePB_COM_JOB job;

  public PB_RS_USER_BASIC(Long userid, String nickname, ePB_COM_SEX sex, String headurl, Long coin, Integer level, Integer vip, Long prettynum, ePB_COM_JOB job) {
    this.userid = userid;
    this.nickname = nickname;
    this.sex = sex;
    this.headurl = headurl;
    this.coin = coin;
    this.level = level;
    this.vip = vip;
    this.prettynum = prettynum;
    this.job = job;
  }

  private PB_RS_USER_BASIC(Builder builder) {
    this(builder.userid, builder.nickname, builder.sex, builder.headurl, builder.coin, builder.level, builder.vip, builder.prettynum, builder.job);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_RS_USER_BASIC)) return false;
    PB_RS_USER_BASIC o = (PB_RS_USER_BASIC) other;
    return equals(userid, o.userid)
        && equals(nickname, o.nickname)
        && equals(sex, o.sex)
        && equals(headurl, o.headurl)
        && equals(coin, o.coin)
        && equals(level, o.level)
        && equals(vip, o.vip)
        && equals(prettynum, o.prettynum)
        && equals(job, o.job);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = userid != null ? userid.hashCode() : 0;
      result = result * 37 + (nickname != null ? nickname.hashCode() : 0);
      result = result * 37 + (sex != null ? sex.hashCode() : 0);
      result = result * 37 + (headurl != null ? headurl.hashCode() : 0);
      result = result * 37 + (coin != null ? coin.hashCode() : 0);
      result = result * 37 + (level != null ? level.hashCode() : 0);
      result = result * 37 + (vip != null ? vip.hashCode() : 0);
      result = result * 37 + (prettynum != null ? prettynum.hashCode() : 0);
      result = result * 37 + (job != null ? job.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_RS_USER_BASIC> {

    public Long userid;
    public String nickname;
    public ePB_COM_SEX sex;
    public String headurl;
    public Long coin;
    public Integer level;
    public Integer vip;
    public Long prettynum;
    public ePB_COM_JOB job;

    public Builder() {
    }

    public Builder(PB_RS_USER_BASIC message) {
      super(message);
      if (message == null) return;
      this.userid = message.userid;
      this.nickname = message.nickname;
      this.sex = message.sex;
      this.headurl = message.headurl;
      this.coin = message.coin;
      this.level = message.level;
      this.vip = message.vip;
      this.prettynum = message.prettynum;
      this.job = message.job;
    }

    /**
     * user id  in chat system
     */
    public Builder userid(Long userid) {
      this.userid = userid;
      return this;
    }

    /**
     * �س�
     */
    public Builder nickname(String nickname) {
      this.nickname = nickname;
      return this;
    }

    /**
     * �Ա�
     */
    public Builder sex(ePB_COM_SEX sex) {
      this.sex = sex;
      return this;
    }

    /**
     * ͷ��
     */
    public Builder headurl(String headurl) {
      this.headurl = headurl;
      return this;
    }

    /**
     * ���ֵ
     */
    public Builder coin(Long coin) {
      this.coin = coin;
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
     * VIP
     */
    public Builder vip(Integer vip) {
      this.vip = vip;
      return this;
    }

    /**
     * ����
     */
    public Builder prettynum(Long prettynum) {
      this.prettynum = prettynum;
      return this;
    }

    /**
     * ְҵ
     */
    public Builder job(ePB_COM_JOB job) {
      this.job = job;
      return this;
    }

    @Override
    public PB_RS_USER_BASIC build() {
      checkRequiredFields();
      return new PB_RS_USER_BASIC(this);
    }
  }
}
