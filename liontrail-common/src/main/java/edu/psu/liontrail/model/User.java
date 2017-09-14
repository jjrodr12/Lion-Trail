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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="liontrail_user")
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
}
