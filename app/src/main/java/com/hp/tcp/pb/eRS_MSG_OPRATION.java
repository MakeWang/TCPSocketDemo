// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.ProtoEnum;

public enum eRS_MSG_OPRATION
    implements ProtoEnum {
  /**
   * ����
   */
  eRS_MSG_HIDE(1),
  /**
   * �ָ�չʾ
   */
  eRS_MSG_DISPLAY(2),
  /**
   * �ջ�
   */
  eRS_MSG_GO_BACK(3),
  /**
   * ɾ��
   */
  eRS_MSG_DEL(4);

  private final int value;

  eRS_MSG_OPRATION(int value) {
    this.value = value;
  }

  @Override
  public int getValue() {
    return value;
  }
}
