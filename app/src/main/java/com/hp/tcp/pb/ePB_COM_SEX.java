// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\commonMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.ProtoEnum;

public enum ePB_COM_SEX
    implements ProtoEnum {
  /**
   * ��
   */
  SEX_BOY(0),
  /**
   * Ů
   */
  SEX_GIRL(1),
  /**
   * δ֪
   */
  SEX_UNKNOWN(2);

  private final int value;

  ePB_COM_SEX(int value) {
    this.value = value;
  }

  @Override
  public int getValue() {
    return value;
  }
}