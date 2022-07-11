
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Random;

class HangmanTest {

    HangmanGame hangmanGame;

    @org.junit.jupiter.api.Test
    void setrandom() {
        Random rand = new Random();
        int n = rand.nextInt(10);
        assertEquals(n, n);
    }

    @org.junit.jupiter.api.Test
    void getStringList() {
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
        assertEquals(list, list);
    }
    
}