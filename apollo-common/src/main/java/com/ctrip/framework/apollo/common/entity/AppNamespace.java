package com.ctrip.framework.apollo.common.entity;


import com.ctrip.framework.apollo.common.utils.InputValidator;
import com.ctrip.framework.apollo.core.enums.ConfigFileFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "app_namespace")
@SQLDelete(sql = "Update app_namespace set is_deleted = '1' where id = ?")
@Where(clause = "is_deleted = '0'")
public class AppNamespace extends BaseEntity {

  @NotBlank(message = "AppNamespace Name cannot be blank")
  @Pattern(
      regexp = InputValidator.CLUSTER_NAMESPACE_VALIDATOR,
      message = "Invalid Namespace format: " + InputValidator.INVALID_CLUSTER_NAMESPACE_MESSAGE + " & " + InputValidator.INVALID_NAMESPACE_NAMESPACE_MESSAGE
  )
  @Column(name = "name", nullable = false)
  private String name;

  @NotBlank(message = "AppId cannot be blank")
  @Column(name = "app_id", nullable = false)
  private String appId;

  @Column(name = "format", nullable = false)
  private String format;

  @Column(name = "is_public", columnDefinition = "Bit default '0'")
  private boolean isPublic = false;

  @Column(name = "comment")
  private String comment;

  public String getAppId() {
    return appId;
  }

  public String getComment() {
    return comment;
  }

  public String getName() {
    return name;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isPublic() {
    return isPublic;
  }

  public void setPublic(boolean aPublic) {
    isPublic = aPublic;
  }

  public ConfigFileFormat formatAsEnum() {
    return ConfigFileFormat.fromString(this.format);
  }

  public String getFormat() {
    return format;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public String toString() {
    return toStringHelper().add("name", name).add("appId", appId).add("comment", comment)
        .add("format", format).add("isPublic", isPublic).toString();
  }
}
