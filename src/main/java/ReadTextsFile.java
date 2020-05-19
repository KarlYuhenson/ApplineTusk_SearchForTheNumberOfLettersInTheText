import java.io.*;
import java.util.*;
// input = scannerText
public class ReadTextsFile {
        private static Scanner scannerText;

        private static void readFile () {
            System.out.println ( "Введите путь до файла" );
            scannerText = new Scanner ( System.in );
            File file = new File ( scannerText.nextLine ( ).trim ( ) );
            try {
                scannerText = new Scanner ( file );
            } catch ( FileNotFoundException e ) {
                System.out.println ( "Путь указан не верно" );
                readFile ( );
            }
        }

        public static void main ( String[] args ) {
            readFile ( );
            Map<String, Integer> counterMap = new TreeMap <> ();

            for ( Scanner it = scannerText; it.hasNext ( ); ) {
                String word = scannerText.next ( ).replaceAll ( "\\p{Punct}" , "" );;
                if(!word.isEmpty()) {
                    Integer count = counterMap.get(word);
                    if(count == null) {
                        count = 0;
                    }
                    counterMap.put(word, ++count);
                }
            }

            for(String word : counterMap.keySet()) {
                System.out.println(word + ": " + counterMap.get(word));
            }
        }
}
