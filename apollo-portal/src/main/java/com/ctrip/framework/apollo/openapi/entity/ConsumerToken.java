package com.ctrip.framework.apollo.openapi.entity;

import com.ctrip.framework.apollo.common.entity.BaseEntity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Jason Song(song_s@ctrip.com)
 */
@Entity
@Table(name = "consumer_token")
@SQLDelete(sql = "Update consumer_token set is_deleted = '1' where id = ?")
@Where(clause = "is_deleted = '0'")
public class ConsumerToken extends BaseEntity {
  @Column(name = "consumer_id", nullable = false)
  private long consumerId;

  @Column(name = "token", nullable = false)
  private String token;

  @Column(name = "expires", nullable = false)
  private Date expires;

  public long getConsumerId() {
    return consumerId;
  }

  public void setConsumerId(long consumerId) {
    this.consumerId = consumerId;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Date getExpires() {
    return expires;
  }

  public void setExpires(Date expires) {
    this.expires = expires;
  }

  @Override
  public String toString() {
    return toStringHelper().add("consumerId", consumerId).add("token", token)
        .add("expires", expires).toString();
  }
}
