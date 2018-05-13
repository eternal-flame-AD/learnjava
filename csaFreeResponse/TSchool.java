package csaFreeResponse;

import java.util.*;

public class TSchool {
	public static void main(String[] args) {
		Elective elec1=new Elective("e1",2);
		Elective elec2=new Elective("e2",1);
		Elective elec3=new Elective("e3",0);
		Student stu1=new Student(elec1,elec2,elec3);
		Student stu2=new Student(elec2,elec3,elec1);
		Student stu3=new Student(elec1,elec2,elec3);
		Student stu4=new Student(elec1,elec2,elec3);
		Student stu5=new Student(elec3,elec2,elec1);
		ArrayList<Elective> elecs=new ArrayList<Elective>();
		elecs.add(elec1);
		elecs.add(elec2);
		elecs.add(elec3);
		ArrayList<Student> studs=new ArrayList<Student>();
		studs.add(stu1);
		studs.add(stu2);
		studs.add(stu3);
		studs.add(stu4);
		studs.add(stu5);
		School school=new School(studs,elecs);
		school.assignElectivesToStudents();
		Iterator<Student> iterstu=studs.iterator();
		while (iterstu.hasNext()) {
			System.out.println(iterstu.next().hasElective());
		}
		Iterator<Elective> iterelec=elecs.iterator();
		while (iterelec.hasNext()) {
			System.out.println(iterelec.next().getClassSize());
		}
		ArrayList<Student> result=school.studentsWithoutElectives();
		System.out.println(result.size());
	}
}

class School {
	private ArrayList<Student> studentList;
	private ArrayList<Elective> electiveList;
	public School(ArrayList<Student> stud,ArrayList<Elective> elec) {
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
		Iterator<Student> stud=studentList.iterator();
		while (stud.hasNext()) {
			Student curr=stud.next();
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
	public ArrayList<Student> studentsWithoutElectives() {
		/* implemented in part (c) */
		ArrayList<Student> result=new ArrayList<Student>();
		Iterator<Student> iter=studentList.iterator();
		while (iter.hasNext()) {
			Student curr=iter.next();
			if (!curr.hasElective()) {
				result.add(curr);
			}
		}
		return result;
	}
	
}

class Student {
	private boolean assigned = false;
	private Elective[] choice = new Elective[3];
	public Student(Elective e1, Elective e2, Elective e3) {
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
	public void addStudent(Student s) {
		size++;
	}
}