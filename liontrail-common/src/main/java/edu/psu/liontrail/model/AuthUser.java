package edu.psu.liontrail.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="auth_user")
public class AuthUser implements Serializable {
  
  private static final long serialVersionUID = -308906158370717809L;

  @Id
  @Column(name="username")
  @Size(max=50)
  private String userName;
  
  @Column(name="password")
  @Size(max=255)
  private String password;
  
}
