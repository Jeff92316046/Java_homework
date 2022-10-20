import java.util.Scanner;

public class student_login_system {
    public static void main(String[] args) {
        student SD = new student();
        System.out.println("Welcome to student login system");
        for (;;) {
            System.out.println("");
            System.out.println("press 1 --> enter name ");
            System.out.println("press 2 --> enter born day");
            System.out.println("press 3 --> show your personal information");
            System.out.println("press 4 --> choose lesson");
            System.out.println("press 5 --> end up studen login system");
            Scanner sc = new Scanner(System.in);
            int temp = sc.nextInt();
            if (temp == 1) {
                SD.set_Name();
            } else if (temp == 2) {
                SD.set_Bron_day();
            } else if (temp == 3) {
                SD.show_student_data();
            } else if (temp == 4) {
                SD.lesson_table.choose_Lesson();
            } else if (temp == 5) {
                break;
            }

        }

    }
}

class student {
    String name = "unknown";
    String born_day = "unknown";
    String student_ID = "U11116087";
    String department = "Computer Science Department";
    choose_lesson lesson_table = new choose_lesson();

    student() {
    }

    // System.out.println();
    void set_Name() {
        System.out.println("");
        System.out.println("enter your name");
        Scanner sc = new Scanner(System.in);
        String temp = sc.next();
        name = temp;
    }

    void set_Bron_day() {
        System.out.println("");
        System.out.println("enter your born day");
        Scanner sc = new Scanner(System.in);
        String temp = sc.next();
        born_day = temp;
    }

    void show_student_data() {
        System.out.println(" ");
        System.out.println("Name:" + name);
        System.out.println("Born day:" + born_day);
        System.out.println("Student_ID:" + student_ID);
        System.out.println("Department:" + department);
        System.out.print("chosen lesson :");
        for (int i = 0; i < 4; i++) {
            if (lesson_table.subject_choose[i] == 1) {
                System.out.print(lesson_table.subject[i] + " ");
            } else {
                continue;
            }
        }
    }
}

class choose_lesson {
    String[] subject = { "chinese", "english", "java", "calculus" };
    int[] subject_choose = { 0, 0, 0, 0 };

    choose_lesson() {

    }

    void choose_Lesson() {
        for (;;) {
            System.out.println("");
            System.out.println("choose your lesson");
            System.out.println("press 1 --> " + subject[0]);
            System.out.println("press 2 --> " + subject[1]);
            System.out.println("press 3 --> " + subject[2]);
            System.out.println("press 4 --> " + subject[3]);
            System.out.println("if you want to cancel your choose ,you can press again. ");
            System.out.println("press 5 --> end up choose lesson");
            Scanner sc = new Scanner(System.in);
            int temp = sc.nextInt();
            if (temp == 5) {
                break;
            } else {
                if (subject_choose[temp - 1] == 0) {
                    subject_choose[temp - 1] = 1;
                } else {
                    subject_choose[temp - 1] = 0;
                }
            }
        }
    }
}
// System.out.println(" ");
