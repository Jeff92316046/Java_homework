import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;//

public class testdice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("how much times you want to roll :");
        int times = sc.nextInt();
        dice test_dice = new dice();
        dice_counter test_counter = new dice_counter();
        for (var i = 1; i <= times; i++) {
            test_counter.counter(test_dice.random());
        }
        System.out.println("1:" + test_counter.dice_one);
        System.out.println("2:" + test_counter.dice_two);
        System.out.println("3:" + test_counter.dice_three);
        System.out.println("4:" + test_counter.dice_four);
        System.out.println("5:" + test_counter.dice_five);
        System.out.println("6:" + test_counter.dice_six);
    }
}

class dice {

    dice() {
    }

    int random() {
        int min_val = 1;
        int max_val = 6;
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        int randomNum = tlr.nextInt(min_val, max_val + 1);
        return randomNum;
    }
}

class dice_counter {
    int dice_one = 0;
    int dice_two = 0;
    int dice_three = 0;
    int dice_four = 0;
    int dice_five = 0;
    int dice_six = 0;
    int dice_num = 1;

    dice_counter() {
    }

    void counter(int dice_number) {
        if (dice_number == 1) {
            dice_one++;
        }
        if (dice_number == 2) {
            dice_two++;
        }
        if (dice_number == 3) {
            dice_three++;
        }
        if (dice_number == 4) {
            dice_four++;
        }
        if (dice_number == 5) {
            dice_five++;
        }
        if (dice_number == 6) {
            dice_six++;
        }
    }

    void get_dice_num(int new_num) {
        dice_num = new_num;
    }
}