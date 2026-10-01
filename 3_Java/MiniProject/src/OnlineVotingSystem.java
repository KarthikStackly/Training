import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

class User{
    String userID; //use this to check in some DS (preferably Map?) if it exists. only Then permit to vote?
    String nameOfUser;
//    String password;
    boolean hasVoted;

    User(String userID, String nameOfUser, boolean hasVoted) {
        this.userID = userID;
        this.nameOfUser = nameOfUser;
        this.hasVoted = hasVoted; //default I'm not putting false because this isn't Just to create new user
    }
} //This will contain users or more accurately Voters, to be renamed later

class Candidate {
    String candidateID;
    String nameOfCandidate;
    int numVotes;

    Candidate(String candidateID, String nameOfCandidate) {
        this.candidateID = candidateID;
        this.nameOfCandidate = nameOfCandidate;
        this.numVotes = 0;
    }

} //This will contain the Candidates contesting in the election. Main purpose is to identify them by candidateID and increase voterCount

//class Authenticate { } //Auth class, do I need separate class just for Authentication? Login? Do I use this to check if he has voted as well? If not, the only purpose will be to just login? Del later maybe...

class Election {

    Map<String, User> registeredVoters;
    Map<String, Candidate> candidates;

    void registerVoter(){}
    void displayCandidates(){}
    void castVote(){}
    void displayResults(){}

} //This could actually contain all the aspects of the voting system, checking hasVoted to be precise. Need to figure out access specifiers...

public class OnlineVotingSystem {
//Trying not to overload main with the logic dump. Best to divide and conquer.
    static void main() {
        Scanner scan = new Scanner(System.in);
        String fileName = "registered_voters.txt";
        File voters = new File(fileName);

        try {
            if(voters.createNewFile()) {
                System.out.println("Voters File created Successfully!");
                FileWriter writeVoters = new FileWriter(fileName);
                writeVoters.write(
                        "V001,Karthik,false\n" +
                            "V002,Rahul,false\n" +
                            "V003,Priya,false\n" +
                            "V004,Arjun,false\n" +
                            "V005,Ananya,false\n" +
                            "V006,Vikram,false\n" +
                            "V007,Meera,false\n" +
                            "V008,Naveen,false\n" +
                            "V009,Sneha,false\n" +
                            "V010,Aditya,false\n" +
                            "V011,Divya,false\n" +
                            "V012,Rohan,false\n" +
                            "V013,Kavya,false\n" +
                            "V014,Sanjay,false\n" +
                            "V015,Ishita,false\n"
                );
                System.out.println("Initial Data written successfully!");
                writeVoters.close();
            } else {
                System.out.println("File already exists...");
            }
        } catch (IOException e) {
            System.out.printf("Some error occurred : %s", e.getMessage());
        }


//        Now begins...
        int choice;
        do {
            System.out.println("\n*** Welcome to eVoting. What do you wanna do? ***");
            System.out.print("1. Register as voter\n2. Check Candidate List\n3. Vote for xCandidate\n4. Live Results!!!\n5. Exit\n===> : ");
            choice = scan.nextInt();

            switch (choice) {
                case 1 -> System.out.println("You are a registered voter woohoo!!");
                case 2 -> System.out.println("It's Gandhi vs Modi");
                case 3 -> System.out.println("Alright you're done voting. Make sure to submit the token at the exit.");
                case 4 -> System.out.println("Results are out on Tuesday!");
                case 5 -> System.out.println("Come back later for more info...");
                default -> System.out.println("Please enter a valid choice");
            }

        } while (choice != 5);
//        scan.next();
    }
}
