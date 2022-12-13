package example.hibernate.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="course")
public class Course 
{
	@Id
	@Column(name="course_Id")
	private String id;
	@Column(name="course_name")
	private String name;
	@Column(name="course_duration")
	private int duration;
	@Column(name="course_fees")
	private int fees;
	

	public Course() {
		// TODO Auto-generated constructor stub
	}


	public Course(String id, String name, int duration, int fees) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.fees = fees;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public int getFees() {
		return fees;
	}


	public void setFees(int fees) {
		this.fees = fees;
	}


	@Override
	public int hashCode() {
		return Objects.hash(duration, fees, id, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return duration == other.duration && fees == other.fees && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", duration=" + duration + ", fees=" + fees + "]";
	}

	
}
