// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.ENUM;
import static com.squareup.wire.Message.Datatype.INT64;
import static com.squareup.wire.Message.Datatype.STRING;
import static com.squareup.wire.Message.Label.REQUIRED;

/**
 * �������ظ�
 */
public final class PB_BLACK_REP extends Message {
  private static final long serialVersionUID = 0L;

  public static final Long DEFAULT_PEERID = 0L;
  public static final Long DEFAULT_USERID = 0L;
  public static final eRS_BLACK_ZONE DEFAULT_ZONE = eRS_BLACK_ZONE.eRS_BLACK_SET;
  public static final eRS_COMMON_Ret DEFAULT_RET = eRS_COMMON_Ret.eRS_COMMON_SUC;
  public static final String DEFAULT_PEERNAME = "";
  public static final String DEFAULT_PEERURL = "";
  public static final Long DEFAULT_PRETTYNUM = 0L;

  /**
   * �Է��û�id
   */
  @ProtoField(tag = 1, type = INT64)
  public final Long peerid;

  /**
   * �û�id
   */
  @ProtoField(tag = 2, type = INT64, label = REQUIRED)
  public final Long userid;

  /**
   * ������
   */
  @ProtoField(tag = 3, type = ENUM, label = REQUIRED)
  public final eRS_BLACK_ZONE zone;

  /**
   * �������ظ�ֵ
   */
  @ProtoField(tag = 4, type = ENUM)
  public final eRS_COMMON_Ret ret;

  /**
   * �س�
   */
  @ProtoField(tag = 5, type = STRING)
  public final String peername;

  /**
   * ����
   */
  @ProtoField(tag = 6, type = STRING)
  public final String peerurl;

  @ProtoField(tag = 7, type = INT64)
  public final Long prettynum;

  public PB_BLACK_REP(Long peerid, Long userid, eRS_BLACK_ZONE zone, eRS_COMMON_Ret ret, String peername, String peerurl, Long prettynum) {
    this.peerid = peerid;
    this.userid = userid;
    this.zone = zone;
    this.ret = ret;
    this.peername = peername;
    this.peerurl = peerurl;
    this.prettynum = prettynum;
  }

  private PB_BLACK_REP(Builder builder) {
    this(builder.peerid, builder.userid, builder.zone, builder.ret, builder.peername, builder.peerurl, builder.prettynum);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_BLACK_REP)) return false;
    PB_BLACK_REP o = (PB_BLACK_REP) other;
    return equals(peerid, o.peerid)
        && equals(userid, o.userid)
        && equals(zone, o.zone)
        && equals(ret, o.ret)
        && equals(peername, o.peername)
        && equals(peerurl, o.peerurl)
        && equals(prettynum, o.prettynum);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = peerid != null ? peerid.hashCode() : 0;
      result = result * 37 + (userid != null ? userid.hashCode() : 0);
      result = result * 37 + (zone != null ? zone.hashCode() : 0);
      result = result * 37 + (ret != null ? ret.hashCode() : 0);
      result = result * 37 + (peername != null ? peername.hashCode() : 0);
      result = result * 37 + (peerurl != null ? peerurl.hashCode() : 0);
      result = result * 37 + (prettynum != null ? prettynum.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_BLACK_REP> {

    public Long peerid;
    public Long userid;
    public eRS_BLACK_ZONE zone;
    public eRS_COMMON_Ret ret;
    public String peername;
    public String peerurl;
    public Long prettynum;

    public Builder() {
    }

    public Builder(PB_BLACK_REP message) {
      super(message);
      if (message == null) return;
      this.peerid = message.peerid;
      this.userid = message.userid;
      this.zone = message.zone;
      this.ret = message.ret;
      this.peername = message.peername;
      this.peerurl = message.peerurl;
      this.prettynum = message.prettynum;
    }

    /**
     * �Է��û�id
     */
    public Builder peerid(Long peerid) {
      this.peerid = peerid;
      return this;
    }

    /**
     * �û�id
     */
    public Builder userid(Long userid) {
      this.userid = userid;
      return this;
    }

    /**
     * ������
     */
    public Builder zone(eRS_BLACK_ZONE zone) {
      this.zone = zone;
      return this;
    }

    /**
     * �������ظ�ֵ
     */
    public Builder ret(eRS_COMMON_Ret ret) {
      this.ret = ret;
      return this;
    }

    /**
     * �س�
     */
    public Builder peername(String peername) {
      this.peername = peername;
      return this;
    }

    /**
     * ����
     */
    public Builder peerurl(String peerurl) {
      this.peerurl = peerurl;
      return this;
    }

    public Builder prettynum(Long prettynum) {
      this.prettynum = prettynum;
      return this;
    }

    @Override
    public PB_BLACK_REP build() {
      checkRequiredFields();
      return new PB_BLACK_REP(this);
    }
  }
}
