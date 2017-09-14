package edu.psu.liontrail.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="auth_user_role")
public class UserRole implements Serializable {

  private static final long serialVersionUID = 5158281233404740370L;

  @Id
  @Column(name="username")
  @Size(max=50)
  private String userName;
  
  @OneToOne
  @PrimaryKeyJoinColumn(name="username", referencedColumnName="username")
  private AuthUser user;
  
  @Column(name="role")
  @Size(max=255)
  @NotNull
  private String role;
}
