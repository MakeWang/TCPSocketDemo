// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.ProtoEnum;

public enum eADD_TYPE
    implements ProtoEnum {
  /**
   * ������Ϣ
   */
  ADD_TYPE_ASK(1),
  /**
   * �ظ���Ϣ
   */
  ADD_TYPE_REP(2);

  private final int value;

  eADD_TYPE(int value) {
    this.value = value;
  }

  @Override
  public int getValue() {
    return value;
  }
}