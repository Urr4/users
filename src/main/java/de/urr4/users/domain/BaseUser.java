package de.urr4.users.domain;

import java.util.Objects;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;


@NodeEntity(label = "BaseUser")
public class BaseUser {

	@Id
	@GeneratedValue
	private Long id;

	@Property(name = "name")
	@Index(unique = true)
	private String name;

	@Property(name = "isActive")
	private boolean isActive = true;


	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean active) {
		isActive = active;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseUser user = (BaseUser) o;
        return isActive == user.isActive &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, isActive);
    }
}
