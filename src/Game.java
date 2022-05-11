import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    static void Game(ArrayList<Questions> questions) throws FileNotFoundException {

        int Q1_p = 0, Q2_p = 0, Q3_p = 0, r= 1, QC = 0, money =0 ;
        while(true) {

            ArrayList<Integer> prev_no = new ArrayList<>();
            RandomGen ran = new RandomGen();
            ArrayList<Integer> question_i = RandomGen.Question_Gen(prev_no,r);
            for (int i = 0; i < question_i.size(); i++) {
                prev_no.add(question_i.get(i));
            }
            for (int j = 0; j < question_i.size(); j++) {
                if (r == 1) {

                    Q1_p = 100;
                    Q2_p = 500;
                    Q3_p = 1000;
                } else if (r == 2) {
                    Q1_p = 8000;
                    Q2_p = 16000;
                    Q3_p = 32000;
                } else if (r == 3) {
                    Q1_p = 125000;
                    Q2_p = 500000;
                    Q3_p = 1000000;

                }


                Scanner input = new Scanner(System.in);
                System.out.println(questions.get(question_i.get(j)).question + "\n" + questions.get(question_i.get(j)).op1 + "  " + questions.get(question_i.get(j)).op2 + "\n" + questions.get(question_i.get(j)).op3 + "  " + questions.get(question_i.get(j)).op4 + "\n");

                int in = -1;
                //QC = 0;
                while (in == -1) {

                    String response = input.nextLine();
                    if (response.equalsIgnoreCase(questions.get(question_i.get(j)).answer)) {
                        QC = QC + 1;

                        if (QC == 1) {
                            money = money + Q1_p;
                        } else if (QC == 2) {
                            money = money + Q2_p;
                        } else if (QC == 3) {
                            money = money + Q3_p;
                        }

                        in = 0;

                    } else if ((response.equalsIgnoreCase("A")) | (response.equalsIgnoreCase("B")) | (response.equalsIgnoreCase("C")) | (response.equalsIgnoreCase("D"))) {
                        System.out.println("Sorry!!!, Wrong answer.");
                        System.out.println("You cannot proceed further, you lost all the money you won, Thanks for playing, Good bye !!!");
                        System.exit(0);
                        QC = QC + 1;
                        in = 0;

                    } else {
                        System.out.println("Invalid input");
                    }
                }


                if (QC >= 3) {

                    if (r < 3) {
                        System.out.println("The total money you won is: " + money+".");
                        System.out.println(" \n Do you want to continue to Round " + (r+1) + " or walk away with " + money + " ? ");
                        System.out.println("\n Press C to continue and E to exit game.");

                        while (true) {

                            input = new Scanner(System.in);

                            String response = input.nextLine();

                            if (response.equalsIgnoreCase("C")) {
                                System.out.println("******Proceeding to round " + (r+1) +" ****** "+"\n");
                                r++;
                                QC = 0;
                                break;


                            } else if (response.equalsIgnoreCase("E")) {

                                System.out.println("Congrats!!! you have won CAD " + money +" in total.");
                                System.out.println("Thank you for playing, goodbye.");
                                System.exit(0);

                            } else {
                                System.out.println("Invalid input, try again.");
                            }
                        }
                    } else if( r == 3){
                        System.out.println("Congrats!!! you have won " + money + " in total."+" \n Thank you for playing, Goodbye.");
                        System.exit(0);

                    }
                }
            }
        }

    }



}
