
package higherorlower;

import java.util.Random;
import java.util.Scanner;


public class HigherOrLower {
    

    public static int getRandom() {
        Random rdm = new Random();
        int x = rdm.nextInt((13 - 1) + 1) + 1;
        return x;
    }

    public static void mainMenu() {
        Scanner input = new Scanner(System.in);
        int lives = 3;
        boolean play = false;
        System.out.println("Do you want to play? type 'Y' OR 'N'");
        String choice = input.next();
        if (choice.equalsIgnoreCase("Y")) {
            play = true;
        }
        System.out.println("Welcome to the Higher or Lower game! ");
        while (play == true) {

            int points = 0;

            int[] Cards = new int[32];
            for (int i = 0; i < 32; i++) {
                Cards[i] = getRandom();
            }
            int firstCard = Cards[getRandom()];
            while (lives > 0) {
                
                System.out.println("Your card is: " + firstCard);
                try {
                    System.out.println("Do you think the next card will be 1)Higher or 2)Lower");
                } catch (Exception e) {
                    System.out.println("Error: " + e);

                }
                int HorL = input.nextInt();
                switch (HorL) {
                    case 1:
                        int nextCard = Cards[getRandom()];
                        if (firstCard > nextCard) {
                            System.out.println("The next card was " + nextCard);
                            points--;
                            lives--;
                            firstCard=nextCard;
                            System.out.println("You guessed incorrectly, lost a point and a life");

                        } else if (firstCard < nextCard) {
                            System.out.println("The next card was " + nextCard);
                            points++;
                            firstCard=nextCard;
                            System.out.println("You guessed correctly, you gained a point");
                        } else if (firstCard == nextCard) {
                            System.out.println("The next card was " + nextCard);
                            firstCard=nextCard;
                            System.out.println("The cards were the same you didnt gain or lose a point or a life");
                        }

                    case 2:
                        int nextCard2 = Cards[getRandom()];
                        if (firstCard > nextCard2) {
                            System.out.println("The next card was " + nextCard2);
                            points++;
                            firstCard=nextCard2;
                            System.out.println("You guessed correctly, you gained a point");

                        } else if (firstCard < nextCard2) {
                            System.out.println("The next card was " + nextCard2);
                            points--;
                            lives--;
                            firstCard=nextCard2;
                            System.out.println("You guessed incorrectly, you lost a point");
                        } else if (firstCard == nextCard2) {
                            System.out.println("The next card was " + nextCard2);
                            firstCard=nextCard2;
                            System.out.println("The cards were the same you didnt gain or lose a point or a life");
                        }
                }
            }

            System.out.println("You are out of lives, you got: " + points + "Points");
            System.out.println("Do you wish to keep playing 'Y' or 'N'");
            String playChoice= input.next();
            if (playChoice.equalsIgnoreCase("n")) {
                play = false;
            } else {
                play = true;
                lives=3;
            }

        }

    }

    
    public static void main(String[] args) {
        mainMenu();
        
    }
    
    }

