import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrackerDeCaesarCipher
{

    public final List<String> words = new ArrayList<>();

    public CaesarCipherCracker(File wordsFile)
    {

        try
        {

            Scanner scanner = new Scanner(wordsFile);
            while (scanner.hasNext())
            {
                words.add(scanner.next().toLowerCase());
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public int findShift(String message)
    {
        int shift = 1;

        while (shift < 26)
        {

            String clarifiedMessage = new CaesarCipher(shift).clarify(message);
            boolean successful = true;

            for (String word : clarifiedMessage.split(" "))
            {
                if (!words.contains(word))
                {

                    successful = false;
                    break;
                }
            }

            if (successful)
            {
                break;
            }
            shift++;
        }
        return shift;
    }

    public String clarify(String message)
    {

        return new CaesarCipher(findShift(message).clarify(message));
    }
}
