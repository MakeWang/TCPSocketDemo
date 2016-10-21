// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: .\\roomMsgs.proto
package com.hp.tcp.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.STRING;
import static com.squareup.wire.Message.Label.REQUIRED;

public final class PB_SELLER extends Message {
  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_SELLERID = "";
  public static final String DEFAULT_IMGURL = "";
  public static final String DEFAULT_NAME = "";

  /**
   * �̼�id
   */
  @ProtoField(tag = 1, type = STRING, label = REQUIRED)
  public final String sellerid;

  /**
   * �̼�ͼƬ
   */
  @ProtoField(tag = 2, type = STRING, label = REQUIRED)
  public final String imgurl;

  /**
   * �̼��س�
   */
  @ProtoField(tag = 3, type = STRING, label = REQUIRED)
  public final String name;

  public PB_SELLER(String sellerid, String imgurl, String name) {
    this.sellerid = sellerid;
    this.imgurl = imgurl;
    this.name = name;
  }

  private PB_SELLER(Builder builder) {
    this(builder.sellerid, builder.imgurl, builder.name);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof PB_SELLER)) return false;
    PB_SELLER o = (PB_SELLER) other;
    return equals(sellerid, o.sellerid)
        && equals(imgurl, o.imgurl)
        && equals(name, o.name);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = sellerid != null ? sellerid.hashCode() : 0;
      result = result * 37 + (imgurl != null ? imgurl.hashCode() : 0);
      result = result * 37 + (name != null ? name.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<PB_SELLER> {

    public String sellerid;
    public String imgurl;
    public String name;

    public Builder() {
    }

    public Builder(PB_SELLER message) {
      super(message);
      if (message == null) return;
      this.sellerid = message.sellerid;
      this.imgurl = message.imgurl;
      this.name = message.name;
    }

    /**
     * �̼�id
     */
    public Builder sellerid(String sellerid) {
      this.sellerid = sellerid;
      return this;
    }

    /**
     * �̼�ͼƬ
     */
    public Builder imgurl(String imgurl) {
      this.imgurl = imgurl;
      return this;
    }

    /**
     * �̼��س�
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    @Override
    public PB_SELLER build() {
      checkRequiredFields();
      return new PB_SELLER(this);
    }
  }
}