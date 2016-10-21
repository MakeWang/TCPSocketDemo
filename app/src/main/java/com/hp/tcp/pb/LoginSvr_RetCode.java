// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\loginMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.ProtoEnum;

public enum LoginSvr_RetCode
    implements ProtoEnum {
  /**
   * success
   */
  GC_LOGIN_SUCC(0),
  /**
   * no user
   */
  GC_LOGIN_NOUSER(1),
  /**
   * user token error
   */
  GC_LOGIN_TOKENERROR(2),
  /**
   * app token error
   */
  GC_LOGIN_APPTOKENERROR(3),
  /**
   * unknow
   */
  GC_LOGIN_UNKNOW(100),
  /**
   * open web fail
   */
  GC_LOGIN_WEB_OPEN_FAIL(101),
  /**
   * web reply txt error
   */
  GC_LOGIN_WEB_REP_ERROR(102),
  /**
   * visit db save family fail
   */
  GC_LOGIN_DB_SAVEFAMILY_FAIL(103),
  /**
   * visit db save user info fail
   */
  GC_LOGIN_DB_SAVEUI_FAIL(104),
  /**
   * visit db get chat svr info fail
   */
  GC_LOGIN_DB_GETCHATSVR_FAIL(105),
  /**
   * visit memcached svr create enter room token fail
   */
  GC_LOGIN_MC_CREATETOKEN_FAIL(106);

  private final int value;

  LoginSvr_RetCode(int value) {
    this.value = value;
  }

  @Override
  public int getValue() {
    return value;
  }
}