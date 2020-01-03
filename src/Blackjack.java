import java.util.Scanner;
class P1Random {
    private long next;
    public P1Random() {
        next = 0;
    }
    private short nextShort() {
        return nextShort(Short.MAX_VALUE);
    }
    private short nextShort(short limit) {
        next = next * 1103515245 + 12345;
        return (short) Math.abs(((next / 65536) % limit));
    }
    private int nextInt() {
        return nextInt(Integer.MAX_VALUE);
    }
    public int nextInt(int limit) {
        return ((((int) nextShort()) << 16) | ((int) nextShort())) % limit;
    }
    private double nextDouble() {
        return (double) nextInt() / (double) Integer.MAX_VALUE;
    }
}


public class Blackjack {

    public static void main(String[] args) {

        //the following is a list of variables used throughout the program
        boolean game;
        boolean turn;
        boolean menu;
        boolean statistics;
        double playerWins;
        double dealerWins;
        double totalGames;
        double tieGames;
        double gameNumber;
        double dealersHand;
        int menuSelection;
        int playerHand;
        int playerCard;

        Scanner scnr = new Scanner(System.in);                           //introduces scanner into the program for input
        P1Random rng = new P1Random();                                   //initiates the random number class

        game = true;
        gameNumber = 0;                                                   //starts with game number 0, immediately
        // increments when game starts
        playerWins = 0;                                                   //no games played yet, 0 wins
        dealerWins = 0;                                                   //no games played yet, 0 wins
        tieGames = 0;                                                     //no games played yet, 0 wins
        totalGames = gameNumber - 1;                                      //calculated after game starts, but before
        // first game has finished, so must be
        //gamenumber - 1

        menuSelection =0;                                                 //must initialize menuSelection
        while (game == true) {                                            //while loop starts the game
            ++gameNumber;                                                 //increments game number
            System.out.print("START GAME #");
            System.out.printf("%.0f", gameNumber);
            System.out.println("");
            System.out.println("");


            playerHand = 0;                                               //players hand always starts off at 0, as they
            turn = true;                                                  //have not yet been dealt a card
            while (turn == true) {

                playerCard = rng.nextInt(13) + 1;                   //randomly assigns a number to the player

                if (playerCard == 1) {                                    //converts the number 1 into an Ace
                    System.out.println("Your card is a ACE!");
                    playerHand += 1;                                      //adds value of 1 to player hand total
                }
                if (playerCard > 1 && playerCard < 11) {                  //gives player face value cards
                    System.out.println("Your card is a " + playerCard + "!");
                    playerHand = playerHand + playerCard;                //adds face value of card to player hand total
                }
                if (playerCard == 11) {                                   //converts 11 to a Jack
                    System.out.println("Your card is a JACK!");
                    playerHand += 10;                                    //adds value of 10 to player's hand total
                }
                if (playerCard == 12) {                                   //converts 12 to a Queen
                    System.out.println("Your card is a QUEEN!");
                    playerHand += 10;                                     //adds value of 10 to player's hand total
                }
                if (playerCard == 13) {                                   //converts 13 to a king
                    System.out.println("Your card is a KING!");
                    playerHand += 10;                                     //adds value of 10 to player's hand total
                }
                System.out.println("Your hand is: " + playerHand);        //prints out players hand total.



                if (playerHand == 21) {                                       //this if and then else if combo checks to
                    System.out.println("BLACKJACK! You win!");                //see if they player has hit BLACKJACK
                    System.out.println("");
                    turn = false;
                    ++playerWins;
                } else if (playerHand > 21) {                                 //or busted, every time they get a new
                    System.out.println("You exceeded 21! You lose.");         //card
                    System.out.println("");
                    turn = false;
                    ++dealerWins;
                }



                if (playerHand < 21) {
                    System.out.println("");                                    //this section prints the menu if the
                    System.out.println("1. Get another card");                 //players turn continues
                    System.out.println("2. Hold hand");
                    System.out.println("3. Print statistics");
                    System.out.println("4. Exit");
                    System.out.println("");
                    System.out.println("Choose an option: ");


                    //once the turn has begun, and player has menu options, this
                    menu = true;                       //while loop keeps the player from getting a new hand each turn
                    while (menu == true) {             //looping them into the menu selection until the turn is ended.


                        menuSelection = scnr.nextInt();


                        while (menuSelection < 1 || menuSelection > 4) {            //creates loop until valid selection
                            System.out.println("Invalid input!");                   //is made
                            System.out.println("Please enter an integer value between 1 and 4.");
                            System.out.println("");
                            System.out.println("1. Get another card");
                            System.out.println("2. Hold hand");
                            System.out.println("3. Print statistics");
                            System.out.println("4. Exit");
                            System.out.println("");
                            System.out.println("Choose an option: ");

                            menuSelection = scnr.nextInt();
                        }

                        statistics = true;
                        if (menuSelection == 3) {                                        //triggers the statistics
                            while (statistics == true) {
                                totalGames = gameNumber - 1;
                                double percentWin = (100 * (playerWins / totalGames));   //calculates win percentage
                                System.out.print("Number of Player wins: ");             //displays player wins
                                System.out.printf("%.0f", playerWins);
                                System.out.println("");
                                System.out.print("Number of Dealer wins: ");             //displays dealer wins
                                System.out.printf("%.0f", dealerWins);
                                System.out.println("");
                                System.out.print("Number of tie games: ");              //displays tie games
                                System.out.printf("%.0f", tieGames);
                                System.out.println("");
                                System.out.print("Total # of games played is: ");      //displays total games played
                                System.out.printf("%.0f", totalGames);
                                System.out.println("");
                                if ((totalGames) > 0) {
                                    System.out.print("Percentage of Player wins: ");   //prevents win percentage
                                    System.out.printf("%.1f", percentWin);             //from showing if no games
                                    System.out.println("%");                           //have been played
                                }
                                System.out.println("");                               //reprints the menu option for
                                System.out.println("1. Get another card");            //next selection
                                System.out.println("2. Hold hand");
                                System.out.println("3. Print statistics");
                                System.out.println("4. Exit");
                                System.out.println("");
                                System.out.println("Choose an option: ");

                                menuSelection = scnr.nextInt();

                                while (menuSelection < 1 || menuSelection > 4) {//creates loop until valid selection
                                    System.out.println("Invalid input!");       //is made
                                    System.out.println("Please enter an integer value between 1 and 4.");
                                    System.out.println("");
                                    System.out.println("1. Get another card");
                                    System.out.println("2. Hold hand");
                                    System.out.println("3. Print statistics");
                                    System.out.println("4. Exit");
                                    System.out.println("");
                                    System.out.println("Choose an option: ");

                                    menuSelection = scnr.nextInt();
                                }

                                if (menuSelection != 3) {                            //restarts the statistics menu
                                    statistics = false;
                                    break;
                                }
                            }
                        }

                        if (menuSelection == 1) {                                   //escapes the menu loop, giving
                            break;                                                  //player new card.
                        }


                        if (menuSelection == 2) {                                   //ends the players turn, moving
                            dealersHand = rng.nextInt(11) + 16;               //to dealer, assigns random hand
                            if (dealersHand < 22) {                         //if dealer does not bust loop
                                System.out.print("Dealer's hand: ");
                                System.out.printf("%.0f", dealersHand);
                                System.out.println("");
                                System.out.println("Your hand is: " + playerHand);
                                if (playerHand > dealersHand) {             //player hand greater, player wins
                                    System.out.println("You win!");
                                    ++playerWins;
                                }
                                if (dealersHand > playerHand) {             //dealer hand greater, dealer wins
                                    System.out.println("Dealer wins!");
                                    ++dealerWins;
                                }
                                if (playerHand == dealersHand) {            //both hands equal, tie game
                                    System.out.println("It's a tie! No one wins!");
                                    ++tieGames;
                                }
                                System.out.println("");
                            } else {                                        //if the dealer busts, automatic player
                                System.out.print("Dealer's hand: ");        //win
                                System.out.printf("%.0f", dealersHand);
                                System.out.println("");
                                System.out.println("Your hand is: " + playerHand);
                                System.out.println("");
                                System.out.println("You win!");
                                System.out.println("");
                                ++playerWins;
                            }
                            menu = false;
                            turn = false;
                        }

                        if (menuSelection == 4) {                       //exits the game
                            System.exit(0);
                        }

                    }

                }
            }
        }
    }
    }





