// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.BOOL;
import static com.squareup.wire.Message.Datatype.INT32;
import static com.squareup.wire.Message.Datatype.STRING;
import static com.squareup.wire.Message.Label.REQUIRED;

/**
 * ����
 */
public final class PB_FAMILY extends Message {
  private static final long serialVersionUID = 0L;

  public static final Integer DEFAULT_ID = 0;
  public static final String DEFAULT_NAME = "";
  public static final String DEFAULT_IMG = "";
  public static final Boolean DEFAULT_ISALLOW = false;

  /**
   * ����ID
   */
  @ProtoField(tag = 1, type = INT32, label = REQUIRED)
  public final Integer id;

  /**
   * ��������
   */
  @ProtoField(tag = 2, type = STRING, label = REQUIRED)
  public final String name;

  /**
   * ����ͼƬ
   */
  @ProtoField(tag = 3, type = STRING, label = REQUIRED)
  public final String img;

  /**
   * �Ƿ��������������Ϣ
   */
  @ProtoField(tag = 4, type = BOOL)
  public final Boolean isallow;

  public PB_FAMILY(Integer id, String name, String img, Boolean isallow) {
    this.id = id;
    this.name = name;
    this.img = img;
    this.isallow = isallow;
  }

  private PB_FAMILY(Builder builder) {
    this(builder.id, builder.name, builder.img, builder.isallow);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_FAMILY)) return false;
    PB_FAMILY o = (PB_FAMILY) other;
    return equals(id, o.id)
        && equals(name, o.name)
        && equals(img, o.img)
        && equals(isallow, o.isallow);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = id != null ? id.hashCode() : 0;
      result = result * 37 + (name != null ? name.hashCode() : 0);
      result = result * 37 + (img != null ? img.hashCode() : 0);
      result = result * 37 + (isallow != null ? isallow.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_FAMILY> {

    public Integer id;
    public String name;
    public String img;
    public Boolean isallow;

    public Builder() {
    }

    public Builder(PB_FAMILY message) {
      super(message);
      if (message == null) return;
      this.id = message.id;
      this.name = message.name;
      this.img = message.img;
      this.isallow = message.isallow;
    }

    /**
     * ����ID
     */
    public Builder id(Integer id) {
      this.id = id;
      return this;
    }

    /**
     * ��������
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * ����ͼƬ
     */
    public Builder img(String img) {
      this.img = img;
      return this;
    }

    /**
     * �Ƿ��������������Ϣ
     */
    public Builder isallow(Boolean isallow) {
      this.isallow = isallow;
      return this;
    }

    @Override
    public PB_FAMILY build() {
      checkRequiredFields();
      return new PB_FAMILY(this);
    }
  }
}
