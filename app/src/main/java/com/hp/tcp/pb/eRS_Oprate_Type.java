// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.ProtoEnum;

public enum eRS_Oprate_Type
    implements ProtoEnum {
  /**
   * ��Ϊ����Ա
   */
  RS_OT_SET_MANAGER(1),
  /**
   * ȡ������Ա
   */
  RS_OT_CANCEL_MANAGER(2),
  /**
   * ��Ϊ������
   */
  RS_OT_SET_BLACK(3),
  /**
   * ȡ��������
   */
  RS_OT_CANCEL_BLACK(4),
  /**
   * �������
   */
  RS_OT_INVITE_FRIEND(5),
  /**
   * �ٱ�����ɧ��
   */
  RS_OT_VOTE_DISDURB(6);

  private final int value;

  eRS_Oprate_Type(int value) {
    this.value = value;
  }

  @Override
  public int getValue() {
    return value;
  }
}
