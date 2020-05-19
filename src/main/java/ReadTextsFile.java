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
            Map<String, Integer> map = new TreeMap <> ();

            for ( Scanner it = scannerText; it.hasNext ( ); ) {
                String text = scannerText.next ( ).replaceAll ( "\\p{Punct}" , "" );;
                if(! text.isEmpty()) {
                    Integer count = map.get( text );
                    if(count == null) {
                        count = 0;
                    }
                    map.put( text , ++count);
                }
            }

            for(String word : map.keySet()) {
                System.out.println(word + ": " + map.get(word));
            }
        }
}
