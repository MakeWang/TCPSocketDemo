// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.ProtoEnum;

public enum eRS_BLACK_ZONE
    implements ProtoEnum {
  /**
   * ���ú�����
   */
  eRS_BLACK_SET(1),
  /**
   * ȡ��������
   */
  eRS_CANCEL_BLACK(2);

  private final int value;

  eRS_BLACK_ZONE(int value) {
    this.value = value;
  }

  @Override
  public int getValue() {
    return value;
  }
}