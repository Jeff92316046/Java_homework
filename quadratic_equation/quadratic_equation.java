import java.util.Scanner;

public class quadratic_equation {
    public static void main(String[] args) {
        quadratic_equation_object Q_E_O = new quadratic_equation_object();
        Q_E_O.IO(0);
        Q_E_O.IO(1);
        if (Q_E_O.Discriminant() == 1) {
            Q_E_O.IO(2);
        } else if (Q_E_O.Discriminant() == 2) {
            Q_E_O.IO(3);
        } else if (Q_E_O.Discriminant() == 3) {
            Q_E_O.IO(4);
        }
    }
}

class quadratic_equation_object {

    quadratic_equation_object() {

    }

    double a;
    double b;
    double c;

    int Discriminant() {
        double temp = b * b - (4 * a * c);
        if (temp > 0) {
            return 1; // real_root
        } else if (temp < 0) {
            return 2; // imaginary_root
        } else {
            return 3; // double_root
        }
    }

    void IO(int judge) {
        if (judge == 0) {
            System.out.println("quadratic_equation : a*x^2 + b*x + c");
        }
        if (judge == 1) {
            System.out.print("a:");
            Scanner sc1 = new Scanner(System.in);
            double temp1 = sc1.nextDouble();
            System.out.print("b:");
            Scanner sc2 = new Scanner(System.in);
            double temp2 = sc2.nextDouble();
            System.out.print("c:");
            Scanner sc3 = new Scanner(System.in);
            double temp3 = sc3.nextDouble();
            a = temp1;
            b = temp2;
            c = temp3;
        }
        if (judge == 2) {
            double root1 = (-b + (Math.sqrt((double) (b * b - 4 * a * c))) / (2 * a));
            double root2 = (-b - (Math.sqrt((double) (b * b - 4 * a * c))) / (2 * a));
            System.out.println("two real roots : " + root1 + "   " + root2);
        }
        if (judge == 3) {
            double root_real_part = -b / (2 * a);
            double root_imaginary_part = Math.sqrt(-b * b + 4 * a * c) / (2 * a);
            System.out.println("two imaginary roots : " + root_real_part + " + " + root_imaginary_part + "i" + "   "
                    + root_real_part + " - " + root_imaginary_part + "i");
        }
        if (judge == 4) {
            double root = -b / (2 * a);
            System.out.println("double root : " + root);
        }
    }

    // System.out.println("");
}
