package edu.psu.liontrail.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="liontrail_user", uniqueConstraints= {
    @UniqueConstraint(columnNames= {"username"})
})
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class User implements Serializable {
  
  private static final long serialVersionUID = -9175115358960589823L;

  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_seq_gen")
  @SequenceGenerator(name = "user_seq_gen", sequenceName = "user_id_seq", allocationSize = 1)
  private int id;
  
  @Column(name="username")
  @NotNull
  @Size(max=50)
  private String username;
  
  @Column(name="first_name")
  @Size(max=255)
  private String firstName;
  
  @Column(name="middle_name")
  @Size(max=255)
  private String middleName;

  @Column(name="last_name")
  @Size(max=255)
  private String lastName;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((username == null) ? 0 : username.hashCode());
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
    User other = (User) obj;
    if (username == null) {
      if (other.username != null)
        return false;
    } else if (!username.equals(other.username))
      return false;
    return true;
  }
  
}
