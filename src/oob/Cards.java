package oob;

import java.util.Random;
import java.util.Stack;
import java.util.stream.IntStream;

public class Cards {

    public static void main(String[] args) {
        new Cards();
    }

    private final int[] cards;
    private final Stack<Integer> deck = new Stack<>();

    public Cards() {
        this.cards = IntStream.rangeClosed(0, 55).toArray();
    }

    public void shuffle() {
        Random rnd = new Random();
        for (int i = cards.length - 1; i >= 0; i--) {
            int index = rnd.nextInt(i + 1);
            deck.push(cards[index]);

            int tmp = cards[index];
            cards[index] = cards[i];
            cards[i] = tmp;
        }
    }

    public int draw() {
        if (!deck.isEmpty()) {
            return deck.pop();
        }
        return -1;
    }
}
