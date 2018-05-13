package csaFreeResponse;

public class TClassroom {
	public static void main(String[] args) {
		Student s1=new Student("S1",1);
		Student s2=new Student("S2",2);
		Student s3=new Student("S3",3);
		Classroom c1=new Classroom("T1",new Student[]{s1,s2,s3});
		School ts=new School(new Classroom[]{c1});
		System.out.println(ts.findStudent("T1", 2));
	}
}

class School {
	public Classroom[] classrooms;
	public School(Classroom[] classrooms) {
		this.classrooms=classrooms;
	}
	public String findStudent(String teacher,int id) {
		for (int i=0;i<classrooms.length;i++) {
			if (classrooms[i].teacherName.equals(teacher)) {
				String result=classrooms[i].findStudent(id);
				if (!result.equals("")) {
					return result;
				}
			}
		}
		return "Student Not Found";
	}
}

class Classroom {
	public String teacherName;
	public Student[] students;
	public Classroom(String teacher,Student[] stu) {
		teacherName=teacher;
		students=stu;
	}
	public String findStudent(int id) {
		int l=0;
		int r=students.length-1;
		while (l<=r) {
			int m=(l+r)/2;
			if (students[m].studentID==id) {
				return students[m].studentName;
			}
		}
		return "";
	}
}

class Student {
	public String studentName;
	public int studentID;
	public Student(String name, int studentID) {
		studentName=name;
		this.studentID=studentID;
	}
}