// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.ProtoEnum;

public enum eRS_RelateFamily_Ret
    implements ProtoEnum {
  /**
   * �ɹ�
   */
  RS_RF_SUCC(0),
  /**
   * �������ύ
   */
  RS_RF_APPLY_POST(1),
  /**
   * �ȴ������
   */
  RS_RF_VERIFYING(2),
  /**
   * ���Ǹü����Ա
   */
  RS_RF_ERR_MEMBER(3),
  /**
   * ��ֹ�������
   */
  RS_RF_ERR_DENY(4),
  /**
   * ��������Ա��ͬ��,
   */
  RS_RF_ERR_OTHER_ALLOW(5),
  /**
   * ��������Ա�Ѿܾ�
   */
  RS_RF_ERR_OTHER_REFUSE(6),
  /**
   * ����Ա����峤ͬ���ܾ�����ʧ��
   */
  RS_RF_ERR_OPERATE_FAIL(7),
  /**
   * �������ʧ��
   */
  RS_RF_ERR_ADD_FAIL(8),
  /**
   * �������Ѿ��м�����
   */
  RS_RF_HAS_FAMILY(9);

  private final int value;

  eRS_RelateFamily_Ret(int value) {
    this.value = value;
  }

  @Override
  public int getValue() {
    return value;
  }
}
