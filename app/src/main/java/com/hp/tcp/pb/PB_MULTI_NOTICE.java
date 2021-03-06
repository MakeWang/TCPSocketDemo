// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

import static com.squareup.wire.Message.Datatype.ENUM;
import static com.squareup.wire.Message.Datatype.INT32;
import static com.squareup.wire.Message.Datatype.INT64;
import static com.squareup.wire.Message.Datatype.STRING;
import static com.squareup.wire.Message.Label.REPEATED;
import static com.squareup.wire.Message.Label.REQUIRED;

/**
 * �û�����ʱ����֪ͨ
 */
public final class PB_MULTI_NOTICE extends Message {
  private static final long serialVersionUID = 0L;

  public static final Long DEFAULT_USERID = 0L;
  public static final String DEFAULT_NOTICE_TITLE = "";
  public static final eNOTICE_MSG_TYPE DEFAULT_NOTICETYPE = eNOTICE_MSG_TYPE.NOTICE_MSG_TYPE_FRD;
  public static final Integer DEFAULT_UNREAD_NUM = 0;
  public static final String DEFAULT_TARGETNAME = "";
  public static final String DEFAULT_SUFFIX_DSC = "";
  public static final List<PB_USER> DEFAULT_USER_LIST = Collections.emptyList();

  /**
   * ������id
   */
  @ProtoField(tag = 1, type = INT64, label = REQUIRED)
  public final Long userid;

  /**
   * ֪ͨ����
   */
  @ProtoField(tag = 2, type = STRING, label = REQUIRED)
  public final String notice_title;

  /**
   * ֪ͨ����
   */
  @ProtoField(tag = 3, type = ENUM, label = REQUIRED)
  public final eNOTICE_MSG_TYPE noticeType;

  /**
   * ������֪ͨ�ṹ
   */
  @ProtoField(tag = 4, label = REQUIRED)
  public final PB_NOTICE_MSG in_notice;

  /**
   * ��Ϣδ����
   */
  @ProtoField(tag = 5, type = INT32)
  public final Integer unread_num;

  /**
   * Ŀ���س�
   */
  @ProtoField(tag = 6, type = STRING)
  public final String targetname;

  /**
   * ��׺��������
   */
  @ProtoField(tag = 7, type = STRING)
  public final String suffix_dsc;

  /**
   * ��Ҫ�·��ĳ�Ա�б���ӳ�Աʱ
   */
  @ProtoField(tag = 8, label = REPEATED, messageType = PB_USER.class)
  public final List<PB_USER> user_list;

  public PB_MULTI_NOTICE(Long userid, String notice_title, eNOTICE_MSG_TYPE noticeType, PB_NOTICE_MSG in_notice, Integer unread_num, String targetname, String suffix_dsc, List<PB_USER> user_list) {
    this.userid = userid;
    this.notice_title = notice_title;
    this.noticeType = noticeType;
    this.in_notice = in_notice;
    this.unread_num = unread_num;
    this.targetname = targetname;
    this.suffix_dsc = suffix_dsc;
    this.user_list = immutableCopyOf(user_list);
  }

  private PB_MULTI_NOTICE(Builder builder) {
    this(builder.userid, builder.notice_title, builder.noticeType, builder.in_notice, builder.unread_num, builder.targetname, builder.suffix_dsc, builder.user_list);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_MULTI_NOTICE)) return false;
    PB_MULTI_NOTICE o = (PB_MULTI_NOTICE) other;
    return equals(userid, o.userid)
        && equals(notice_title, o.notice_title)
        && equals(noticeType, o.noticeType)
        && equals(in_notice, o.in_notice)
        && equals(unread_num, o.unread_num)
        && equals(targetname, o.targetname)
        && equals(suffix_dsc, o.suffix_dsc)
        && equals(user_list, o.user_list);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = userid != null ? userid.hashCode() : 0;
      result = result * 37 + (notice_title != null ? notice_title.hashCode() : 0);
      result = result * 37 + (noticeType != null ? noticeType.hashCode() : 0);
      result = result * 37 + (in_notice != null ? in_notice.hashCode() : 0);
      result = result * 37 + (unread_num != null ? unread_num.hashCode() : 0);
      result = result * 37 + (targetname != null ? targetname.hashCode() : 0);
      result = result * 37 + (suffix_dsc != null ? suffix_dsc.hashCode() : 0);
      result = result * 37 + (user_list != null ? user_list.hashCode() : 1);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_MULTI_NOTICE> {

    public Long userid;
    public String notice_title;
    public eNOTICE_MSG_TYPE noticeType;
    public PB_NOTICE_MSG in_notice;
    public Integer unread_num;
    public String targetname;
    public String suffix_dsc;
    public List<PB_USER> user_list;

    public Builder() {
    }

    public Builder(PB_MULTI_NOTICE message) {
      super(message);
      if (message == null) return;
      this.userid = message.userid;
      this.notice_title = message.notice_title;
      this.noticeType = message.noticeType;
      this.in_notice = message.in_notice;
      this.unread_num = message.unread_num;
      this.targetname = message.targetname;
      this.suffix_dsc = message.suffix_dsc;
      this.user_list = copyOf(message.user_list);
    }

    /**
     * ������id
     */
    public Builder userid(Long userid) {
      this.userid = userid;
      return this;
    }

    /**
     * ֪ͨ����
     */
    public Builder notice_title(String notice_title) {
      this.notice_title = notice_title;
      return this;
    }

    /**
     * ֪ͨ����
     */
    public Builder noticeType(eNOTICE_MSG_TYPE noticeType) {
      this.noticeType = noticeType;
      return this;
    }

    /**
     * ������֪ͨ�ṹ
     */
    public Builder in_notice(PB_NOTICE_MSG in_notice) {
      this.in_notice = in_notice;
      return this;
    }

    /**
     * ��Ϣδ����
     */
    public Builder unread_num(Integer unread_num) {
      this.unread_num = unread_num;
      return this;
    }

    /**
     * Ŀ���س�
     */
    public Builder targetname(String targetname) {
      this.targetname = targetname;
      return this;
    }

    /**
     * ��׺��������
     */
    public Builder suffix_dsc(String suffix_dsc) {
      this.suffix_dsc = suffix_dsc;
      return this;
    }

    /**
     * ��Ҫ�·��ĳ�Ա�б���ӳ�Աʱ
     */
    public Builder user_list(List<PB_USER> user_list) {
      this.user_list = checkForNulls(user_list);
      return this;
    }

    @Override
    public PB_MULTI_NOTICE build() {
      checkRequiredFields();
      return new PB_MULTI_NOTICE(this);
    }
  }
}
