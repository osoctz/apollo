package com.ctrip.framework.apollo.biz.entity;

import com.ctrip.framework.apollo.common.entity.BaseEntity;

import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "namespace_lock")
@Where(clause = "is_deleted = 0")
public class NamespaceLock extends BaseEntity{

  @Column(name = "namespace_id")
  private long namespaceId;

  public long getNamespaceId() {
    return namespaceId;
  }

  public void setNamespaceId(long namespaceId) {
    this.namespaceId = namespaceId;
  }
}
