package edu.psu.liontrail.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import edu.psu.liontrail.enumeration.SomeEnum;

@Entity
@Table(name="parent_entity",
	uniqueConstraints={
		//single column unique constraint
	    @UniqueConstraint(columnNames={"other_value"}),
	    //Double column unique constraint
	    @UniqueConstraint(columnNames={"some_value","some_enum"})
	  }

)
@NamedQueries({
	@NamedQuery(name=ParentEntity.BY_SOME_VALUE, query="SELECT p FROM ParentEntity p where p.someValue = :value"),
	@NamedQuery(name=ParentEntity.BY_VALUE_LIST, query="SELECT p FROM ParentEntity p where p.someValue IN (:values)")
	
})
public class ParentEntity implements Serializable {

	private static final long serialVersionUID = -5861515674559630210L;
	
	public static final String BY_SOME_VALUE = "ParentEntity.findBySomeValue";
	public static final String BY_VALUE_LIST = "ParentEntity.findBySomeValuelList";

	@Id
	@Column(name="id")
	//This will use a DB sequence to generate an ID number. Any attmept to this is normal will cause an exception
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "parent_entity_seq_gen")
	@SequenceGenerator(name = "parent_entity_seq_gen", sequenceName = "parent_entity_id_seq", allocationSize = 1)
	private int id;
	
	//Link to children objects. MappedBy refers to object property and not column name
	//Cascade means that any change made to child object will be saved
	@OneToMany(mappedBy="parent", cascade=CascadeType.ALL)
	private List<ChildEntity> children;
	
	@Column(name="some_value", length=30)
	@NotNull
	private String someValue;
	
	@Column(name="some_enum", length=15)
	private SomeEnum enumValue;
	
	@Column(name="other_value", length=40)
	private String otherValue;
}
