package edu.psu.liontrail.data;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import edu.psu.liontrail.enumeration.Role;
import edu.psu.liontrail.model.Name;

public class CreateUserDTO implements Serializable {
  
  private static final long serialVersionUID = 3013539765628517992L;

  @XmlElement
  private Name name;
  
  @XmlElement
  private String password;
  
  @XmlElement
  private Role role;

  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    result = prime * result + ((role == null) ? 0 : role.hashCode());
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
    CreateUserDTO other = (CreateUserDTO) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (password == null) {
      if (other.password != null)
        return false;
    } else if (!password.equals(other.password))
      return false;
    if (role != other.role)
      return false;
    return true;
  }  

}
