import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your : ");
        String Name = input.nextLine();
        while(true){
        int money = 0;
        System.out.println("\n"+"Hi " + Name + "!!"+"\n"+" \n*****Welcome to Who wants to be a millionaire*****"+"\n" );
        System.out.println("Start the game ---> Press S" + "\n" + "View rules ---> Press V" + "\n" + "Exit Game ---> press E "+"\n");

        String userInput = input.nextLine();

        if (userInput.equalsIgnoreCase("S")) {

            ArrayList<Integer> prev_no = new ArrayList<>();
            ArrayList<Questions> questions = new ArrayList<>();

            Scanner FileContent = new Scanner(new File("src/question.txt"));
            System.out.println("Welcome to Round 1 of Who wants to be a millionaire, \nThe below is your first question: "+"\n");
            for (int i = 0; i < 27; i++) {

                questions.add(i,new Questions(FileContent.nextLine(), FileContent.nextLine(), FileContent.nextLine(), FileContent.nextLine(), FileContent.nextLine(), FileContent.nextLine()));

            }

            userInput = "C";
            int r = 0;
            while(userInput.equals("C")){
                RandomGen ran = new RandomGen();
                Game G = new Game();
                ran.Question_Gen(prev_no,r);
                G.Game(questions);


            }

        } else if (userInput.equalsIgnoreCase("V")) {

            System.out.println("Round 1\n" +
                    "Welcome to Who wants to be a millionaire!!!!\n " + "\n"+
                    "As a player you will face three rounds, with each round hosting 3 questions.\n" +"\n"+
                    "The questions will get challenging as the rounds progress.\n" +"\n" + "Each question will be tied with a cash prize which increases in value as the rounds progresses and will be added to your total tally.\n" +"\n"+
                    "Once you successfully answer all the questions in a round correctly, you will be given a choice to Walk away with the money you had won until that point.\n" +"\n"+
                    "Caution: If you answer any one of the questions wrong, you will automatically  lose the game and walk away with nothing.\n" +"\n"+
                    "You cannot walk away in the middle of a round , once you  successfully complete all the 3 rounds  you win the game and can walk walk away with full the cash price.\n" +
                    "\n");
            while(true) {
            System.out.println("Press S to return to  main menu");
            userInput = input.nextLine();

                if (userInput.equalsIgnoreCase("S")) {
                    break;
                } else {
                    System.out.println("Invalid input, try again.");
                    continue;
                }
            }



        } else if (userInput.equalsIgnoreCase("E")) {

            System.out.println("Thanks you for playing, Good bye.");
            System.exit(0);

        } else{
            System.out.println("Invalid input, try again");
        }
    }}





}









