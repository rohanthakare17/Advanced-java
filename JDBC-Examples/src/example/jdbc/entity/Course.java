package example.jdbc.entity;

public class Course {

	private String course_id;
	private String course_title;
	private int course_duration;
	private int course_fees;
	
	public Course() 
	{
		
	}

	public Course(String course_id, String course_title, int course_duration, int course_fees) {
		super();
		this.course_id = course_id;
		this.course_title = course_title;
		this.course_duration = course_duration;
		this.course_fees = course_fees;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getCourse_title() {
		return course_title;
	}

	public void setCourse_title(String course_title) {
		this.course_title = course_title;
	}

	public int getCourse_duration() {
		return course_duration;
	}

	public void setCourse_duration(int course_duration) {
		this.course_duration = course_duration;
	}

	public int getCourse_fees() {
		return course_fees;
	}

	public void setCourse_fees(int course_fees) {
		this.course_fees = course_fees;
	}

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_title=" + course_title + ", course_duration="
				+ course_duration + ", course_fees=" + course_fees + "]";
	}

}
