package studentCoursesBackup.myTree;

import studentCoursesBackup.Extra.SelectOperation;

public interface SubjectI {

	public void registerObserver(Node observer);
  public void notifyAll(SelectOperation s);
	
}
