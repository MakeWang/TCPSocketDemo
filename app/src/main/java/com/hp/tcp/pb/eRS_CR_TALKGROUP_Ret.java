// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.ProtoEnum;

public enum eRS_CR_TALKGROUP_Ret
    implements ProtoEnum {
  eRS_CR_TG_SUC(0),
  eRS_CR_TG_FAIL(1);

  private final int value;

  eRS_CR_TALKGROUP_Ret(int value) {
    this.value = value;
  }

  @Override
  public int getValue() {
    return value;
  }
}
