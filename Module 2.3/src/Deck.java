import java.util.*;

public class Deck
{

    public final LinkedList<Card> cards;


    public Deck()
    {

        LinkedList<Card> unshuffledCards = createDeck();
        cards = shuffle(unshuffledCards);
    }

    private LinkedList<Card> createDeck()
    {
        LinkedList<Card> unshuffledCards = new LinkedList<>();
        for (Suit suit : Suit.values())
        {

            for (int rank = 1; rank <= 10; rank++)
            {
                unshuffledCards.add(new Card(suit, String.valueOf(rank)));
            }

            unshuffledCards.add(new Card(suit, "KING"));
            unshuffledCards.add(new Card(suit, "QUEEN"));
            unshuffledCards.add(new Card(suit, "JACK"));
        }

        return unshuffledCards;
    }
    private LinkedList<Card> shuffle(LinkedList<Card> unshuffledCards)
    {

        Random random = new Random();
        LinkedList<Card> shuffledCards = new LinkedList<>();

        while (!unshuffledCards.isEmpty())
        {
            int randomIndex = random.nextInt(unshuffledCards.size());
            shuffledCards.push(unshuffledCards.remove(randomIndex));
        }
        return shuffledCards;
    }
    public LinkedList<Card> pollSeven()
    {

        LinkedList<Card> polledCards = new LinkedList<>();
        for (int i = 0; i < 7; i++)
        {
            polledCards.add(cards.poll());
        }
        return polledCards;
    }

    @Override
    public boolean equals(Object obj)
    {

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Deck deck = (Deck) obj;
        return Objects.equals(cards, deck.cards);
    }

    @Override
    public int hashCode()
    {
        return cards.hashCode();
    }

    @Override
    public String toString()
    {
        return "Deck{" +
                "cards = " + cards +
                '}';
    }
}
