// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

import static com.squareup.wire.Message.Label.REPEATED;

/**
 * web�����Ĺ�ע���ѽṹ
 */
public final class PB_WEB_ADD_FRIEND extends Message {
  private static final long serialVersionUID = 0L;

  public static final List<PB_WEB_FRIENDS> DEFAULT_WEBFRDS = Collections.emptyList();

  @ProtoField(tag = 1, label = REPEATED, messageType = PB_WEB_FRIENDS.class)
  public final List<PB_WEB_FRIENDS> webfrds;

  public PB_WEB_ADD_FRIEND(List<PB_WEB_FRIENDS> webfrds) {
    this.webfrds = immutableCopyOf(webfrds);
  }

  private PB_WEB_ADD_FRIEND(Builder builder) {
    this(builder.webfrds);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_WEB_ADD_FRIEND)) return false;
    return equals(webfrds, ((PB_WEB_ADD_FRIEND) other).webfrds);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    return result != 0 ? result : (hashCode = webfrds != null ? webfrds.hashCode() : 1);
  }

  public static final class Builder extends Message.Builder<PB_WEB_ADD_FRIEND> {

    public List<PB_WEB_FRIENDS> webfrds;

    public Builder() {
    }

    public Builder(PB_WEB_ADD_FRIEND message) {
      super(message);
      if (message == null) return;
      this.webfrds = copyOf(message.webfrds);
    }

    public Builder webfrds(List<PB_WEB_FRIENDS> webfrds) {
      this.webfrds = checkForNulls(webfrds);
      return this;
    }

    @Override
    public PB_WEB_ADD_FRIEND build() {
      return new PB_WEB_ADD_FRIEND(this);
    }
  }
}
