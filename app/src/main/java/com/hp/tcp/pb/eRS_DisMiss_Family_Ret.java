// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.ProtoEnum;

public enum eRS_DisMiss_Family_Ret
    implements ProtoEnum {
  /**
   * �ɹ�
   */
  RS_DMF_SUCC(0),
  /**
   * ʧ��
   */
  RS_DMF_ERR_FAIL(1);

  private final int value;

  eRS_DisMiss_Family_Ret(int value) {
    this.value = value;
  }

  @Override
  public int getValue() {
    return value;
  }
}