/**
 * 
 * 假定根据学生的3门学位课程的分数决定其是否可以拿到学位，对于本科生，如果3门课程的平均分数超过60分即表示通过，而对于研究生，则需要平均超过80分才能够通过。根据上述要求，请完成以下Java类的设计：
 * （1）设计一个基类Student描述学生的共同特征。 （2）设计一个描述本科生的类Undergraduate，该类继承并扩展Student类。
 * （3）设计一个描述研究生的类Graduate，该类继承并扩展Student类。
 * （4）设计一个测试类StudentDemo，分别创建本科生和研究生这两个类的对象， 并输出相关信息。
 */

abstract class Student {
  protected String name;
  protected int id;

  abstract void info();
}

class Undergraduate extends Student {
  private String major;

  Undergraduate(String name, int id, String major) {
    this.name = name;
    this.id = id;
    this.major = major;
  }

  public void info() {
    System.out.println("student name:\t" + name + "\nstudent id:\t" + Integer.toString(id) + "\nmajor:\t\t" + major);
  }
}

class Graduate extends Student {
  private String major;
  private String advisor;

  Graduate(String name, int id, String major, String advisor) {
    this.name = name;
    this.id = id;
    this.major = major;
    this.advisor = advisor;
  }

  public void info() {
    System.out.println("student name:\t" + name + "\nstudent id:\t" + Integer.toString(id) + "\nmajor:\t\t" + major
        + "\nadvisor:\t" + advisor);
  }
}

public class StudentDemo {
  public static void main(String[] args) {
    Undergraduate a = new Undergraduate("h",95,"cs");
    a.info();
    System.out.println();

    Graduate b = new Graduate("nsf", 100, "cs", "Lei");
    b.info();
  }

}
