package studentCoursesBackup.Extra;

public class SelectOperation{

  public int bNumber;
  public String course;
  public String operation;

  public SelectOperation(int bNumber, String course, String operation){
    this.bNumber = bNumber;
    this.course = course;
    this.operation = operation;
  }

  /**
   * @return course
   */
  public String getCourse() {
	  return course;
	}

  /**
   * @param course
   * set course
   */
	public void setCourse(String course) {
	  this.course = course;
	}

 /**
  * @return operation
  */
  public String getOperation(){
    return operation;
  }

 /**
  * @param operation
  * set operation
  */
  public void setOperation(String operation){
    this.operation = operation;
  }
}
