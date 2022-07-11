import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    public static int setrandom() {
        Random rand = new Random();
        int n = rand.nextInt(10);
        return n;
    }
    public static ArrayList<String> getStringList() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("red");
        list.add("write");
        list.add("lap");
        list.add("large");
        list.add("blue");
        list.add("list");
        list.add("set");
        list.add("monkey");
        list.add("key");
        list.add("sky");
        return list;
    }
    public static String getrandom() {
        return getStringList().get(setrandom());
    }

    static String word = getrandom();

    public static ArrayList<Character> stringList(String input){
        int x = input.length();
        ArrayList<Character> stringList = new ArrayList<Character>();
        int counter3 = 0;
        while(x > 0) {
            stringList.add(input.charAt(counter3));
            x--;
            counter3++;
        }
        return stringList;
    }

    public static ArrayList<Character> stringCreate(String input){
        int x = input.length();
        char under = '_';
        ArrayList<Character> stringCreate = new ArrayList<Character>();
        while(x > 0) {
            stringCreate.add(under);
            x--;
        }
        return stringCreate;
    }

    static ArrayList<Character> a = new ArrayList<Character>(stringList(word));


    static ArrayList<Character> b = new ArrayList<Character>(stringCreate(word));


    static ArrayList<Character> c = new ArrayList<Character>(word.length());

    public static ArrayList<String> resultList(Character input) {
        int x = 0;
        ArrayList<String> resultList = new ArrayList<String>();
        while (x < a.size()) {
            if (a.get(x) == input) {
                resultList.add("true");
                resultList.add(String.valueOf(x));
                return resultList;
            }
            x++;
        }
        resultList.add("false");
        resultList.add("-1");
        return resultList;
    }

    public static Boolean checkiftrue(ArrayList<String> resultList) {
        if (resultList.get(0) == "true") {
            return true;
        }
        if (resultList.get(0) == "false") {
            return false;
        }
        else return false;
    }

    public static String index(ArrayList<String> resultList) {
        return resultList.get(1);
    }

    public static int checkIfComplete(ArrayList<Character> b2) {
        int x = 0;
        int complete = 0;
        while (x < b.size()){
            if (b.get(x) == '_') {
                complete = 1;
            }
            x++;
        }
        if (complete == 0) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int counter = 0;
        while (counter < 7) {
            if (counter == 0) {
                System.out.println("Missed letters"+ c);
                System.out.println("Guess a letter");
                System.out.println(b);
                Scanner newChar = new Scanner(System.in);
                String letterInput = newChar.nextLine();
                try {char charInput = letterInput.charAt(0);
                    counter++;
                    if (checkiftrue(resultList(charInput))) {
                        int index = Integer.parseInt(index(resultList(charInput)));
                        b.remove(index);
                        b.add(index, charInput);
                        counter--;
                    }
                    if ((checkiftrue(resultList(charInput))) == false){
                        c.add(charInput);
                    }
                }
                catch (StringIndexOutOfBoundsException ex){
                    System.out.println("You have to enter anything please");
                }
            }
            else {
                System.out.println("Missed letters" + c);
                System.out.println(b);
                System.out.println("Guess a letter");
                Scanner newChar = new Scanner(System.in);
                try {String letterInput = newChar.nextLine();
                    char charInput = letterInput.charAt(0);
                    counter++;
                    if (checkiftrue(resultList(charInput))) {
                        int index = Integer.parseInt(index(resultList(charInput)));
                        b.remove(index);
                        b.add(index, charInput);
                        counter--;
                    }
                    if ((checkiftrue(resultList(charInput))) == false){
                        c.add(charInput);
                    }
                }
                catch (StringIndexOutOfBoundsException ex) {
                    System.out.println("You have to enter anything please");
                }
                if (checkIfComplete(b) == 1) {
                    System.out.println("You Win");
                    System.out.println(b);
                    counter = 10;
                }
            }
            if (counter == 7) {
                System.out.println("You Lose");
                System.out.println(b);
            }
        }
    }
}
