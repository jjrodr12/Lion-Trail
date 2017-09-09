package edu.psu.liontrail.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.psu.liontrail.enumeration.SomeEnum;

@Entity
@Table(name="some_entity")
public class SomeEntity {
  
  @Id
  @Column(name="id", length=45)
  private String id;
  
  @Column(name="enum_val", length=15)
  @Enumerated(EnumType.STRING)
  private SomeEnum enumVal;

}
