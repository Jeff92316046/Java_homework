import java.util.Scanner;
import java.util.ArrayList;

public class student_register_system {
    public static void main(String[] args) {
        System.out.println("Welcome to student login system");
        System.out.println("enter your name");
        Scanner sc1 = new Scanner(System.in);
        String temp1 = sc1.next();
        student SD = new student(temp1);
        SD.L_T.init_lesson_info();
        System.out.println("register successfully");
        System.out.println("Your student ID is " + SD.get_ID());
        for (;;) {
            System.out.println("");
            System.out.println("press 1 --> show your student infomation");
            System.out.println("press 2 --> choose lesson");
            System.out.println("press 3 --> show your transcript");
            System.out.println("press 4 --> show your choosen lesson table");
            System.out.println("press 5 --> show your choosen lesson tuition");
            System.out.println("press 6 --> end up studen login system");
            Scanner sc = new Scanner(System.in);
            int temp = sc.nextInt();
            if (temp == 1) {
                SD.show_student_data();
            } else if (temp == 2) {
                SD.choose_Lesson();
            } else if (temp == 3) {
                SD.show_transcript();
            } else if (temp == 4) {
                SD.show_lesson_table();
            } else if (temp == 5) {
                SD.show_tuition();
            } else if (temp == 6) {
                break;
            } else {
                System.out.println("this is not command");
            }

        }

    }
    
}


class student {                  
    
    private String department = "computer science";     
    lesson_table L_T = new lesson_table();      
    private int grade = 2;
    private String ID = "U11116100";
    private String name = "";

    student(String name) {
        this.name = name ;
    }

    
    // System.out.println();
    public String get_department(){
        return department;
    }  

    public int get_grade(){
        return grade;
    }  

    public String get_ID(){
        return ID;
    }  

    public String get_Name(){
        return name;
    }  

    public void choose_Lesson() {
        for (;;) {
            System.out.println("");
            System.out.println("choose your lesson");
            for(int i=1 ;i < L_T.Lesson_list.get(grade-1).size()+1; i++){
                System.out.println("press "+ i + " --> " + L_T.Lesson_list.get(i-1).get(grade-1).get_subject());
            }
            System.out.println("if you want to cancel your choose ,you can press again. ");
            System.out.println("press 5 --> end up choose lesson");
            Scanner sc = new Scanner(System.in);
            int temp = sc.nextInt();
            if (temp == 5) {
                break;
            } else if (temp <= 4 && temp >= 1) {
                if (L_T.Lesson_list.get(temp-1).get(grade-1).get_choosable()){
                    L_T.Lesson_list.get(temp-1).get(grade-1).lesson_choose();
                    System.out.println(" ");
                    System.out.println("choose sucessly");
                } else {
                    System.out.println(" ");
                    System.out.println("choose fail , check your " + L_T.Lesson_list.get(temp-1).get(grade-1).get_choosabler());
                }
            } else {
                System.out.println(" ");
                System.out.println("this is not command");
            } 
        }
    }


    public void show_student_data() {
        System.out.println(" ");
        System.out.println("Name:" + get_Name());
        System.out.println("Student_ID:" + get_ID());
        System.out.println("Department:" + get_department() + get_grade());
    }

    public void show_transcript(){
        System.out.println("");
        for (int i = 0 ; i < L_T.Lesson_list.size() ; i++ ){
            for (int j = 0 ; j < L_T.Lesson_list.get(i).size() ; j++){
                if (L_T.Lesson_list.get(i).get(j).get_grade() != -1 ){
                    System.out.print(L_T.Lesson_list.get(i).get(j).get_subject());
                    System.out.print(L_T.Lesson_list.get(i).get(j).get_grade());
                    System.out.println("");
                }
            }
        }
    }

    public void show_lesson_table(){
        System.out.println("");
        System.out.println("subject / credit ");
        for (int i = 0 ; i < L_T.Lesson_list.size() ; i++ ){
            for (int j = 0 ; j < L_T.Lesson_list.get(i).size() ; j++){
                if (L_T.Lesson_list.get(i).get(j).get_subject_chooser()){
                    System.out.println(L_T.Lesson_list.get(i).get(j).get_subject() + "/" + L_T.Lesson_list.get(i).get(j).get_credit());
                }
            }
        }
    }

    public void show_tuition(){
        System.out.println("");
        System.out.println("subject / tuition ");
        for (int i = 0 ; i < L_T.Lesson_list.size() ; i++ ){
            for (int j = 0 ; j < L_T.Lesson_list.get(i).size() ; j++){
                if (L_T.Lesson_list.get(i).get(j).get_subject_chooser()){
                    System.out.println(L_T.Lesson_list.get(i).get(j).get_subject() + "/" + L_T.Lesson_list.get(i).get(j).get_tuiion());
                }
            }
        }
    }


}

class lesson_table {

    

    String[][]subject = {
        {"english(1)"   ,"english(2)"   ,""         ,""},
        {"calculus(1)"  ,"calculus(2)"  ,""         ,""},
        {"java(1)"      ,"java(2)"      ,""         ,""},
        {""             ,"C(1)"         ,"C(2)"     ,""},
    };

    int[][] credit = {
        { 2 , 2 , 0 , 0 },
        { 3 , 3 , 0 , 0 },
        { 3 , 3 , 0 , 0 },
        { 0 , 3 , 3 , 0 }
    };

    int [][] grade = {
        { 70 , -1 , -1 , -1 },
        { 45 , -1 , -1 , -1 },
        { 60 , -1 , -1 , -1 },
        { -1 , -1 , -1 , -1 }
    };

    String[][] choosabler = {
        {""         ,"english(1)"   ,""         ,""},
        {""         ,"calculus(1)"  ,""         ,""},
        {""         ,"java(1)"      ,""         ,""},
        {""         ,"java(1)"      ,"C(1)"     ,""},
    };

    boolean[][] choosabler_B = {
        { false , true  , false , false },
        { false , false , false , false },
        { false , true  , false , false },
        { false , true  , false , false }
    };
    int [][] tuition = {
        { 499 , 400 , 0 , 0 },
        { 500 , 500 , 0 , 0 },
        { 500 , 500 , 0 , 0 },
        { 0 , 500 , 500 , 0 }
    };

    ArrayList<ArrayList<lesson>>  Lesson_list = new ArrayList<>();             
    
     
    lesson_table() {

    }
    
    public void init_lesson_info(){
        for (int i = 0 ; i < 4 ; i++ ){
            Lesson_list.add(new ArrayList<>());
            for (int j = 0 ; j < 4; j++){
                Lesson_list.get(i).add(new lesson(subject[i][j],credit[i][j],grade[i][j],choosabler[i][j],tuition[i][j]));
            }
        }
        for (int i = 0 ; i < Lesson_list.size() ; i++ ){
            for (int j = 0 ; j < Lesson_list.get(i).size() ; j++){
                Lesson_list.get(i).get(j).choosable_check(choosabler_B[i][j]);
            }
        }

    }
    


}


class lesson  {
    private String subject = "";                    //ok
    private boolean subject_chooser = false;        //ok
    //public teacher TC = new teacher();
    private int credit = 0;                         //ok
    private int grade = -1;                         //ok
    private boolean choosable = false;              //choosable_check
    private String choosabler = "";                 //ok
    private int tuition = 0;                        //ok


    lesson(String subject,int credit,int grade,String choosabler,int tuition){
        this.subject = subject;
        this.credit = credit;
        this.grade = grade;
        this.choosabler = choosabler;
        this.tuition = tuition;
    }
    
    public void choosable_check(boolean passer){
        choosable = passer;
    }

    public void lesson_choose(){
        if (subject_chooser) {
            subject_chooser = false;
        } else {
            subject_chooser = true;
        }
    }

    public String get_subject(){
        return subject;
    }

    public boolean get_subject_chooser(){
        return subject_chooser;
    }


    public int get_grade(){
        return grade;
    }

    public int get_credit(){
        return credit;
    }

    public boolean get_choosable(){
        return choosable;
    }

    public String get_choosabler(){
        return choosabler;
    }

    public int get_tuiion(){
        return tuition;
    }

    public void set_choosabler(String block_subject){
        choosabler = block_subject;
    }
/*
class teacher  {

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
*/

/*
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
*/
/*
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

*/



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
