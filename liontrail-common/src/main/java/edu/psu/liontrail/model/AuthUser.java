package edu.psu.liontrail.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import edu.psu.liontrail.converters.RoleConverter;
import edu.psu.liontrail.enumeration.Role;

@Entity
@Table(name="auth_user")
@NamedQueries({
  @NamedQuery(name=AuthUser.NAME_LIKE, query="SELECT a FROM AuthUser a WHERE a.userName LIKE :username")
})
public class AuthUser implements Serializable {
  
  private static final long serialVersionUID = -308906158370717809L;
  
  public static final String NAME_LIKE = "AuthUser.findByNameLike";
  
  public AuthUser() {}

  public AuthUser(String userName, String password, Set<Role> roles) {
    super();
    this.userName = userName;
    this.password = password;
    this.roles = roles;
  }

  @Id
  @Column(name="username")
  @Size(max=50)
  private String userName;
  
  @Column(name="password")
  @Size(max=255)
  private String password;
  
  @ElementCollection
  @CollectionTable(name="auth_user_role", joinColumns=@JoinColumn(name="username"))
  @Column(name="role")
  @Convert(converter=RoleConverter.class)
  private Set<Role> roles;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    result = prime * result + ((userName == null) ? 0 : userName.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    AuthUser other = (AuthUser) obj;
    if (password == null) {
      if (other.password != null)
        return false;
    } else if (!password.equals(other.password))
      return false;
    if (userName == null) {
      if (other.userName != null)
        return false;
    } else if (!userName.equals(other.userName))
      return false;
    return true;
  }
}
