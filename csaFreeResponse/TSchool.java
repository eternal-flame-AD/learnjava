package csaFreeResponse;

import java.util.*;

public class TSchool {
	public static void main(String[] args) {
		Elective elec1=new Elective("e1",2);
		Elective elec2=new Elective("e2",1);
		Elective elec3=new Elective("e3",0);
		Student2 stu1=new Student2(elec1,elec2,elec3);
		Student2 stu2=new Student2(elec2,elec3,elec1);
		Student2 stu3=new Student2(elec1,elec2,elec3);
		Student2 stu4=new Student2(elec1,elec2,elec3);
		Student2 stu5=new Student2(elec3,elec2,elec1);
		ArrayList<Elective> elecs=new ArrayList<Elective>();
		elecs.add(elec1);
		elecs.add(elec2);
		elecs.add(elec3);
		ArrayList<Student2> studs=new ArrayList<Student2>();
		studs.add(stu1);
		studs.add(stu2);
		studs.add(stu3);
		studs.add(stu4);
		studs.add(stu5);
		School2 school=new School2(studs,elecs);
		school.assignElectivesToStudents();
		Iterator<Student2> iterstu=studs.iterator();
		while (iterstu.hasNext()) {
			System.out.println(iterstu.next().hasElective());
		}
		Iterator<Elective> iterelec=elecs.iterator();
		while (iterelec.hasNext()) {
			System.out.println(iterelec.next().getClassSize());
		}
		ArrayList<Student2> result=school.studentsWithoutElectives();
		System.out.println(result.size());
	}
}

class School2 {
	private ArrayList<Student2> studentList;
	private ArrayList<Elective> electiveList;
	public School2(ArrayList<Student2> stud,ArrayList<Elective> elec) {
		studentList=stud;
		electiveList=elec;
	}
	private Elective getElectiveByName(String name) {
		/* implemented in part (a) */
		int i=0;
		while (!electiveList.get(i).getName().equals(name)) {
			i++;
		}
		return electiveList.get(i);
	}
	private Elective getElectiveByName_iter(String name) {
		Iterator<Elective> iter=electiveList.iterator();
		Elective now;
		while (true) {
			now=iter.next();
			if (now.getName().equals(name)) {
				break;
			}
		}
		return now;
	}
	private int getElectiveListSize() {
		return electiveList.size();
	}
	private int getStudentListSize() {
		return studentList.size();
	}
	public void assignElectivesToStudents() {
		/* implemented in part (b) */
		Iterator<Student2> stud=studentList.iterator();
		while (stud.hasNext()) {
			Student2 curr=stud.next();
			for (int i=0;i<3;i++) {
				Elective elec=this.getElectiveByName(curr.getChoice(i));
				if (elec.getMaxClassSize()>elec.getClassSize()) {
					elec.addStudent(curr);
					curr.assignElective(elec);
					break;
				}
			}
		}
	}
	public ArrayList<Student2> studentsWithoutElectives() {
		/* implemented in part (c) */
		ArrayList<Student2> result=new ArrayList<Student2>();
		Iterator<Student2> iter=studentList.iterator();
		while (iter.hasNext()) {
			Student2 curr=iter.next();
			if (!curr.hasElective()) {
				result.add(curr);
			}
		}
		return result;
	}
	
}

class Student2 {
	private boolean assigned = false;
	private Elective[] choice = new Elective[3];
	public Student2(Elective e1, Elective e2, Elective e3) {
		choice[0]=e1;
		choice[1]=e2;
		choice[2]=e3;
	}
	public String getChoice(int index) {
		return choice[index].getName();
	}
	public boolean hasElective() {
		return assigned;
	}
	public void assignElective(Elective e) {
		assigned=true;
	}
}

class Elective {
	private String name;
	private int maxSize;
	private int size = 0;
	public Elective(String name,int maxSize) {
		this.name=name;
		this.maxSize=maxSize;
	}
	public String getName() {
		return name;
	}
	public int getMaxClassSize() {
		return maxSize;
	}
	public int getClassSize() {
		return size;
	}
	public void addStudent(Student2 s) {
		size++;
	}
}