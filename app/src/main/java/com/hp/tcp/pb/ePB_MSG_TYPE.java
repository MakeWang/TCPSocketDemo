// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.ProtoEnum;

public enum ePB_MSG_TYPE
    implements ProtoEnum {
  /**
   * ϵͳ��Ϣ
   */
  MSG_TYPE_SYSMSG(1),
  /**
   * ������Ϣ
   */
  MSG_TYPE_CHATMSG(2),
  /**
   * ����Ա����峤������Ϣ
   */
  MSG_TYPE_AT_MSG(3);

  private final int value;

  ePB_MSG_TYPE(int value) {
    this.value = value;
  }

  @Override
  public int getValue() {
    return value;
  }
}