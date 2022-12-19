import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class student_login_system {
    public static void main(String[] args) {
        student SD = new student();
        SD.init_lesson_info();
        System.out.println("Welcome to student login system");
        SD.set_Name();
        SD.set_Born_day();
        System.out.println("register successfully");
        System.out.println("Your student ID is " + SD.get_ID());
        for (;;) {
            System.out.println("");
            System.out.println("press 1 --> show your personal information");
            System.out.println("press 2 --> choose lesson");
            System.out.println("press 3 --> search lesson infomation");
            System.out.println("press 4 --> end up studen login system");
            Scanner sc = new Scanner(System.in);
            int temp = sc.nextInt();
            if (temp == 1) {
                SD.show_student_data();
            } else if (temp == 2) {
                SD.L_T.choose_Lesson();
            } else if (temp == 3) {
                SD.L_T.search_teacher();
            } else if (temp == 4) {
                break;
            } else {
                System.out.println("this is not command");
            }

        }

    }
    
}

class person {
    protected String name = "unknown";                  
    protected ArrayList<String> born_day =new ArrayList<>();
    protected String ID = "U12345678";

    public void set_Name(){                             //overloading
        System.out.println("");
        System.out.print("enter your name : ");
        Scanner sc = new Scanner(System.in);
        String temp = sc.next();
        name = temp;
    }

    public void set_Name(String Name){
        name = Name;
    }

    public String get_Name(){
        return name;
    }  


    public void set_Born_day(){
        System.out.println("");
        System.out.println("enter your born day");
        System.out.println("ex : 2000 01 01");
        System.out.print("year : ");
        Scanner sc = new Scanner(System.in);
        String temp = sc.next();
        born_day.add(temp);
        System.out.print("month : ");
        temp = sc.next();
        born_day.add(temp);
        System.out.print("day : ");
        temp = sc.next();
        born_day.add(temp);

    }

    public String get_Born_day(){
        return born_day.get(0)+"/"+born_day.get(1)+"/"+born_day.get(2);
    }  

    public void set_ID(){
        Scanner sc = new Scanner(System.in);
        String temp = sc.next();
        ID = temp;
    }
    
    public String get_ID(){
        return ID;
    }  
}
class student extends person {                  //inherent
    
    private String department = "computer science";     //encapsulation
    lesson_table L_T = new lesson_table();      //nested class

    student() {
    }

    public  void init_lesson_info(){
        L_T.lesson_name.add("chinese");
        L_T.lesson_name.add("english");
        L_T.lesson_name.add("calculus");
        L_T.lesson_name.add("java");
        L_T.new_subject();
        L_T.lesson_list.get(L_T.lesson_name.get(0)).TC.set_Name("Ms.Yang");
        L_T.lesson_list.get(L_T.lesson_name.get(1)).TC.set_Name("Ms.Lin");
        L_T.lesson_list.get(L_T.lesson_name.get(2)).TC.set_Name("Mr.Wu");
        L_T.lesson_list.get(L_T.lesson_name.get(3)).TC.set_Name("Mr.Lee");

    }
    // System.out.println();
    public void set_department(){
        Scanner sc = new Scanner(System.in);
        String temp = sc.next();
        department = temp;
    }
    public String get_department(){
        return department;
    }  
    public void show_student_data() {
        System.out.println(" ");
        System.out.println("Name:" + get_Name());
        System.out.println("Born day:" + get_Born_day());
        System.out.println("Student_ID:" + get_ID());
        System.out.println("Department:" + get_department());
        System.out.print("chosen lesson :");
        for (int i = 0; i < 4; i++) {
            if (L_T.lesson_list.get(L_T.lesson_name.get(i)).get_subject_chooser()) {
                System.out.print(L_T.lesson_name.get(i) + " ");
            } else {
                continue;
            }
        }
    }
}

class teacher extends person {

    private String subject = "";
    
    teacher(){

    }

    public void set_subject(String Subject){
        subject = Subject;
    }

    public String get_subject_str(){
        return subject;
    }

    public void show_teacher_data() {
        System.out.println(" ");
        System.out.println("Name:" + get_Name());
        System.out.println("Born day:" + get_Born_day());
        System.out.println("Student_ID:" + get_ID());
    }
}

class lesson_table {
    ArrayList<String> lesson_name = new ArrayList<>();             //array
    HashMap<String, lesson> lesson_list = new HashMap<>();         //map
    
    lesson_table() {

    }
    
    public void new_subject(){
        for(int i=0 ; i<lesson_name.size() ; i++){
            lesson_list.put(lesson_name.get(i), new lesson(lesson_name.get(i)));
        }
    }

    public void choose_Lesson() {
        for (;;) {
            System.out.println("");
            System.out.println("choose your lesson");
            for(int i=1;i<=lesson_name.size();i++){
                System.out.println("press "+ i + "-->" + lesson_name.get(i-1));
            }
            System.out.println("if you want to cancel your choose ,you can press again. ");
            System.out.println("press 5 --> end up choose lesson");
            Scanner sc = new Scanner(System.in);
            int temp = sc.nextInt();
            if (temp == 5) {
                break;
            } else if (temp <= 4 && temp >= 1) {
                lesson_list.get(lesson_name.get(temp-1)).lesson_choose();
            } else {
                System.out.println("this is not command");
            } 
        }
    }

    public void search_teacher(){
        for (;;) {
            System.out.println("");
            System.out.println("choose your lesson which you want to seacher");
            for(int i=1;i<=lesson_name.size();i++){
                System.out.println("press "+ i + "-->" + lesson_name.get(i-1));
            }
            System.out.println("press 5 --> end up search teacher");
            Scanner sc = new Scanner(System.in);
            int temp = sc.nextInt();
            if (temp == 5) {
                break;
            } else if (temp <= 4 && temp >= 1) {
                System.out.println("");
                System.out.println("Subject : " + lesson_name.get(temp-1));
                System.out.println("Teacher : " + lesson_list.get(lesson_name.get(temp-1)).TC.get_Name());
            } else {
                System.out.println("this is not command");
            } 
        }
    }
}

interface lesson_pattern{
    public void lesson_choose();
    public String get_subject_str();
    public boolean get_subject_chooser();
}

class lesson implements lesson_pattern {
    private String subject = "";
    private boolean subject_chooser = false;
    public teacher TC = new teacher();
    
    lesson(String Subject){
        subject = Subject;
        TC.set_subject(Subject);
    }

    
    public void lesson_choose(){
        if (subject_chooser) {
            subject_chooser = false;
        } else {
            subject_chooser = true;
        }
    }

    public String get_subject_str(){
        return subject;
    }

    public boolean get_subject_chooser(){
        return subject_chooser;
    }


/* 
    private ArrayList<Boolean> subject_chooser = new ArrayList<Boolean>();

    public enum subject_list {


    public void subject_chooser_init (){
        subject_chooser.add(false);
        subject_chooser.add(false);
        subject_chooser.add(false);
        subject_chooser.add(false);
    }

    public void lesson_choose(subject_list subject){
        switch(subject){
            case chinese:
                if (subject_chooser.get(0)) {
                    subject_chooser.set(0,false)  ;
                } else {
                    subject_chooser.set(0,true)  ;
                }
            case english:
                if (subject_chooser.get(1)) {
                    subject_chooser.set(1,false)  ;
                } else {
                    subject_chooser.set(1,true)  ;
                }
            case calculus:
                if (subject_chooser.get(2)) {
                    subject_chooser.set(2,false);
                } else {
                    subject_chooser.set(2,true);
                }
            case java:
                if (subject_chooser.get(3)) {
                    subject_chooser.set(3, false) ;
                } else {
                    subject_chooser.set(3, true);
                }
        }
    }
*/

}
// System.out.println(" ");
