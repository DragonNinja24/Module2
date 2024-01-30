import java.util.HashMap;
import java.util.Map;

public class CaesarCipher
{

    public final Map<Character, Character> clarityMap = new HashMap<>();
    public final Map<Character, Character> secretMap = new HashMap<>();

    public CaesarCipher(int shift)
    {
        if (shift <= 0 || shift >= 25)
        {
            throw new IllegalArgumentException("Shift's gotta be between 1 & 25 loser");
        }

        for (int i = 0; i < 26; i++)
        {
            char baseChar = (char) ('a' + i);
            char secretChar = (char) ('a' + ((i + shift) % 26));
            secretMap.put(baseChar, secretChar);
            clarityMap.put(secretChar, baseChar);
        }

        public String secrefy(String message)
        {

            return understandMessage(message, secretMap);
        }
        public String clarify(String message)
        {

            return understandMessage(message, clarityMap);
        }

        private String understandMessage(String baseMessage, Map<Character, Character> understandMap)
        {

            StringBuilder understoodMessage = new StringBuilder();

            for (char c: baseMessage.toCharArray())
            {

                if (Character.isLetter(c))
                {
                    understoodMessage.append(understandMap.get(Character.toLowerCase(c)));
                } else
                {

                    understoodMessage.append(c);
                }
            }

            return understoodMessage.toString();
        }
    }
}
