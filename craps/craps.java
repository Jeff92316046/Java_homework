import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;//

public class craps {
    public static void main(String[] args) {

        dice dice_1 = new dice();
        dice dice_2 = new dice();
        judge judger = new judge();
        io IO = new io();
        IO.init_output();
        IO.init_input();
        while (IO.code == 1) {
            IO.show_the_dice_num(dice_1.random(), dice_2.random());
            judger.first_run(judger.plus(dice_1.dice_num, dice_2.dice_num));
            if (judger.judge_code == 1) {
                IO.lose_the_game();
                IO.continue_the_game();
                IO.continue_input();
            } else if (judger.judge_code == 2) {
                IO.win_the_game();
                IO.continue_the_game();
                IO.continue_input();
            } else if (judger.judge_code == 3) {
                IO.into_second_run();
                IO.show_the_dice_num(dice_1.random(), dice_2.random());
                judger.second_run(dice_1.dice_num, dice_2.dice_num, judger.plus(dice_1.dice_num, dice_2.dice_num));
                if (judger.judge_code == 5) {
                    IO.lose_the_game();
                    IO.continue_the_game();
                    IO.continue_input();
                } else if (judger.judge_code == 4) {
                    IO.win_the_game();
                    IO.continue_the_game();
                    IO.continue_input();
                }
                while (judger.judge_code == 6) {
                    IO.tie();
                    IO.show_the_dice_num(dice_1.random(), dice_2.random());
                    judger.second_run(dice_1.dice_num, dice_2.dice_num,
                            judger.plus(dice_1.dice_num, dice_2.dice_num));
                    if (judger.judge_code == 5) {
                        IO.lose_the_game();
                        IO.continue_the_game();
                        IO.continue_input();
                    } else if (judger.judge_code == 4) {
                        IO.win_the_game();
                        IO.continue_the_game();
                        IO.continue_input();
                    } else
                        continue;
                }
            }
        }

    }
}

class dice {
    int dice_num;

    dice() {
    }

    int random() {
        int min_val = 1;
        int max_val = 6;
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        int randomNum = tlr.nextInt(min_val, max_val + 1);
        dice_num = randomNum;
        return randomNum;
    }

}

class judge {
    int judge_code;

    judge() {
    }

    int plus(int num_1, int num_2) {
        return num_1 + num_2;
    }

    void first_run(int sum) {
        if (sum == 2 || sum == 3 || sum == 12) {
            judge_code = 1;// lose
        } else if (sum == 7 || sum == 11) {
            judge_code = 2;// win
        } else {
            judge_code = 3;// continue second run
        }
    }

    void second_run(int num_1, int num_2, int sum) {
        if (num_1 == num_2) {
            judge_code = 4;// win
        } else if (sum == 7) {
            judge_code = 5;// lose
        } else {
            judge_code = 6;// continue
        }
    }

}

class io {
    int code;

    io() {
    }

    void init_input() {
        Scanner sc = new Scanner(System.in);
        int temp = sc.nextInt();
        code = temp;

    }

    void continue_input() {
        Scanner sc = new Scanner(System.in);
        int temp = sc.nextInt();
        code = temp;

    }

    void init_output() {
        System.out.println("If you want to start the game,press 1.");
        System.out.println("if you want to end the game,press 2.");
    }

    void show_the_dice_num(int num_1, int num_2) {
        System.out.println("your dice numbers are " + num_1 + " and " + num_2);
    }

    void win_the_game() {
        System.out.println("You win the game,congratulations.");
        System.out.println(" ");
    }

    void lose_the_game() {
        System.out.println("You lose the game,Don't mind.");
        System.out.println(" ");
    }

    void continue_the_game() {
        System.out.println("if you want to continue the game,press 1.");
        System.out.println("if you want to end the game,press 2.");
    }

    void into_second_run() {
        System.out.println("into next run");
        System.out.println(" ");
    }

    void tie() {
        System.out.println("The game was drawn.");
        System.out.println(" ");
    }
}
