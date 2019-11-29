import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class MovieGuess extends Movie {
    public static void main(String[] args) throws FileNotFoundException, IOException{

        System.out.println("Guess the movie");
        Scanner scanner=new Scanner(System.in);
        int noOfMovies;
        int randomValue;
        String[] movies;
        String[] wordsOfRandomMovie;
        File file=new File("C:\\Users\\Priyanka P\\Downloads\\ud282-master\\MovieGame\\src\\Resources\\ListOfMovies");
        boolean play=true;
        while (play==true) {
            String revealedMovie;
            String wronglyChosenWords="";
            int count=0;
            int check=0;
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] byteArray = new byte[(int) file.length()];
                fileInputStream.read(byteArray);
                String lines = new String(byteArray);
                movies = lines.split("\r\n");
                noOfMovies = movies.length;

                randomValue = (int) (Math.random() * noOfMovies);
                wordsOfRandomMovie = movies[randomValue].split(" ");
                String guessedLetters = "";
                System.out.print("You are guessing: ");
                while (count < 10) {
                    revealedMovie = "";
                    for (int i = 0; i < wordsOfRandomMovie.length; i++) {
                        for (int j = 0; j < wordsOfRandomMovie[i].length(); j++) {
                            if (guessedLetters.contains(wordsOfRandomMovie[i].substring(j,j+1))) {
                                revealedMovie = revealedMovie + wordsOfRandomMovie[i].substring(j, j + 1);
                            } else {
                                revealedMovie = revealedMovie + "*";
                            }
                        }
                        if (i != wordsOfRandomMovie.length - 1) {
                            revealedMovie = revealedMovie + " ";
                        }
                    }
                    if (revealedMovie.equals(movies[randomValue])) {
                        System.out.println("You won!\n You have guessed '" + revealedMovie + "' correctly.");
                        check = 1;
                        break;
                    }

                    System.out.println(revealedMovie);
                    System.out.println("You have guessed (" + count + ") wrong letters:" + wronglyChosenWords);
                    System.out.print("Guess a letter:");
                    String temp=scanner.next();
                    while(((int)temp.charAt(0)>=48 && (int)temp.charAt(0)<=57)||((int)temp.charAt(0)==32)){
                        System.out.println("You can only choose a letter!\nGuess a letter:");
                        temp=scanner.next();
                    }
                    while(temp.length()>1){
                        System.out.println("You can choose only one letter at a time!\nGuess a letter:");
                        temp=scanner.next();
                    }
                    while(guessedLetters.contains(temp)){
                        System.out.println("You have already chosen this letter!\nGuess a letter:");
                        temp=scanner.next();
                        while(((int)temp.charAt(0)>=48 && (int)temp.charAt(0)<=57)||((int)temp.charAt(0)==32)){
                            System.out.println("You can only choose a letter!\nGuess a letter:");
                            temp=scanner.next();
                        }
                        while(temp.length()>1){
                            System.out.println("You can choose only one letter at a time!\nGuess a letter:");
                            temp=scanner.next();
                        }
                    }
                    guessedLetters += temp;

                    if (!movies[randomValue].contains(guessedLetters.substring(guessedLetters.length() - 1))) {
                            count++;
                            wronglyChosenWords += " " + guessedLetters.substring(guessedLetters.length() - 1);
                    }

                }
                if (check == 0) {
                    System.out.println("You have guessed (10) wrong letters: " + wronglyChosenWords + "\nGame Over!\n The movie is "+movies[randomValue]);
                }
                System.out.println("Wanna play one more game? Enter y to play and n to not play");
                String tp=scanner.next();
                while(!(tp.equals("y")||tp.equals("n"))){
                System.out.println("Choose right option:");
                tp=scanner.next();
                }
                if (tp.equals("y")) {
                    play = true;
                } else {

                    play = false;
                    // wronglyChosenWords=
                }

            } catch (FileNotFoundException e) {
                System.out.println("Recheck the file location" + e);
            }
        }

    }
}
