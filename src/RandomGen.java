import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class RandomGen {


    static ArrayList<Integer> Question_Gen(ArrayList<Integer> Total_prev_no, int r) throws FileNotFoundException {
        Random random_no = new Random();

        ArrayList<Integer> question_i = new ArrayList<>();
        ArrayList<Integer> Iterative_Prev_No = new ArrayList<>();
        int j =0 ;
        while(question_i.size() <= 2) {
            int int_random = random_no.nextInt(9);
            if(r == 2){
                int_random = int_random + 9;
            } else if ( r == 3 ){
                int_random = int_random + 18;
            }
            int flag = 0;
            int i;
            for (i = 0; i < Total_prev_no.size(); i++){

                if (Total_prev_no.get(i) == int_random) {
                    flag = -1;
                }
            }


            for (int m =0 ; m < Iterative_Prev_No.size(); m++){
                if (Iterative_Prev_No.get(m) == int_random) {
                    flag = -1;
                }}

            if(flag == 0 ) {
                question_i.add(int_random);
                Iterative_Prev_No.add(int_random);
                j++;
            }


        }

        return question_i;
    }





}
