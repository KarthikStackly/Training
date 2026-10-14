import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
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
        this.numVotes = 0; //default 0 totalVotes for all canidates
    }

} //This will contain the Candidates contesting in the election. Main purpose is to identify them by candidateID and increase voterCount

//class Authenticate { } //Auth class, do I need separate class just for Authentication? Login? Do I use this to check if he has voted as well? If not, the only purpose will be to just login? Del later maybe...

class Election {

    Map<String, User> registeredVoters = new HashMap<>();
    Map<String, Candidate> candidates = new HashMap<>();

    Election(){
        candidates.put("C1", new Candidate("C1", "Trump"));
        candidates.put("C2", new Candidate("C2", "Obama"));
    }

    void loadVotersFromFile(String filename){
        try {
//            Scan each line and split into words by delimiter comma, then put each word into its variable and finally bundle it into a User
            Scanner fileScanner = new Scanner(new File(filename));
            while(fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine().trim();
             if(!line.isEmpty()) {
                 String[] words = line.split(",");
                 if(words.length == 3) {
                     String id = words[0].trim();
                     String name = words[1].trim();
                     boolean hasVoted = Boolean.parseBoolean(words[2].trim());
                     registeredVoters.put(id, new User(id, name, hasVoted));
                 }
             }
            }
        } catch (FileNotFoundException f) {
            System.out.println("Error loading Voters from File : " + f.getMessage());
        }
    }

    void registerVoter(Scanner scan, String fileName){
//        Generate number for ID based on size of the map...
        int nextNum = registeredVoters.size() + 1;
        String newVoterID = String.format("V%03d", nextNum);

        scan.nextLine();
        System.out.printf ("Enter Name to Register : ");
        String registerName = scan.nextLine();

        User newUser = new User(newVoterID, registerName, false);
        registeredVoters.put(newVoterID, newUser);
        File openRegFile = new File(fileName);
        try {
            FileWriter addVoter = new FileWriter(openRegFile, true);
            String addVoterToFile = newVoterID + "," + registerName + ",false\n";
            addVoter.write(addVoterToFile);
            addVoter.close();
        } catch (IOException e) {
            System.out.println("Error : Could not add voter : " + e.getMessage());
        }

        System.out.printf("%nVoter %s registered successfully with ID %s!",registerName, newVoterID);
    }

    void displayCandidates(){
        System.out.println("\n *** Candidates Contesting ***");
        for(Candidate c : candidates.values()) {
            System.out.println("ID: " + c.candidateID + " | Name: " + c.nameOfCandidate);
        }
    }

    void castVote(Scanner scan){
        System.out.print("Enter your voter ID: ");
        String voterID = scan.next();
//        First check if voter registered

        if(!registeredVoters.containsKey(voterID)) {
            System.out.println("!!! Error: Voter not registered. !!!");
            return;
        }

//        Next Check if voter voted
        User voter = registeredVoters.get(voterID);
        if(voter.hasVoted) {
            System.out.println("!!! Error: " + voter.nameOfUser + " has already voted !!!");
            return;
        }


        displayCandidates();
        System.out.print("Enter the ID you want to vote for : ");
        String inputCandID = scan.next();

//        Check if input candidate exists
        if(!candidates.containsKey(inputCandID)) {
            System.out.println("!!! Error: Invalid ID !!!");
            return;
        }
//Get them
        Candidate candi = candidates.get(inputCandID);
//        Increase voteCount
        candi.numVotes++;
//        Note user as voted
        voter.hasVoted = true;
        System.out.printf("%s's vote to %s has been cast successfully :D%n", voter.nameOfUser, candi.nameOfCandidate);
    }

    void showLiveResults(){
        int totalVotesCast = 0;
        Candidate leading = null;
        Candidate secondPlace = null;
        int maxVotes = -1;
        int secondMaxVotes = -1;

        for (Candidate c : candidates.values()) {
            totalVotesCast += c.numVotes;
            System.out.println(c.nameOfCandidate + " : " + c.numVotes + " votes");

            if(c.numVotes > maxVotes) {
                secondMaxVotes = maxVotes;
                secondPlace = leading;
                maxVotes = c.numVotes;
                leading = c;
            } else if(c.numVotes >secondMaxVotes) {
                secondMaxVotes = c.numVotes;
                secondPlace = c;
            }
        }

        System.out.println("-----------------------------");
        System.out.println("Total Votes Cast: " + totalVotesCast);

        if (totalVotesCast == 0) {
            System.out.println("Status: Voting in progress (No votes cast yet)");
        } else if (leading != null && secondPlace != null && maxVotes == secondMaxVotes) {
            System.out.println("Status: Tied at " + maxVotes + " votes each!");
        } else if (leading != null) {

            if (secondPlace != null && secondMaxVotes > 0) {
                System.out.println("Status: " + leading.nameOfCandidate + " leading by " + (maxVotes - secondMaxVotes) +
                        " vote(s) with " + secondPlace.nameOfCandidate + " right behind (" + secondMaxVotes + " votes)");
            } else {
                System.out.println("Status: " + leading.nameOfCandidate + " leading by " + (maxVotes - secondMaxVotes) + " vote(s)");
            }
        }
    }


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
                writeVoters.write( //dummy starter data
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

        Election elect = new Election();
        elect.loadVotersFromFile(fileName);

//        Now begins...
        int choice;
        do {
            System.out.println("\n*** Welcome to eVoting. What do you wanna do? ***");
            System.out.print("1. Register as voter\n2. Check Candidate List\n3. Vote for Candidate\n4. Live Results!!!\n5. Exit\n===> : ");
            choice = scan.nextInt();

            switch (choice) {
//                case 1 -> System.out.println("You are a registered voter woohoo!!");
//                case 2 -> System.out.println("It's Gandhi vs Modi");
//                case 3 -> System.out.println("Alright you're done voting. Make sure to submit the token at the exit.");
//                case 4 -> System.out.println("Results are out on Tuesday!");

                case 1 -> elect.registerVoter(scan, fileName);
                case 2 -> elect.displayCandidates();
                case 3 -> elect.castVote(scan);
                case 4 -> elect.showLiveResults();
                case 5 -> System.out.println("Come back later for more info...");
                default -> System.out.println("Please enter a valid choice");
            }

        } while (choice != 5);

        scan.close();
//        scan.next();
    }
}
