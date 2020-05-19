import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadTextsFile {
    static Scanner scFile;

    static void scannerFile ( ) {
        System.out.println ( "Введите путь до файла" );
        scFile = new Scanner ( System.in );
        File file = new File ( scFile.nextLine ( ) );
        try {
            scFile = new Scanner ( file );
        } catch ( FileNotFoundException exception ) {
            System.out.println ( "Системе не удается найти указанный путь" );
            scannerFile ( );
        }
    }

    public static void main ( String[] args ) {
        scannerFile ( );
        Map < String, Integer > map = new TreeMap <> ( );
        for ( Scanner scannerText = scFile ; scannerText.hasNext ( ) ; ) {
            String text = scFile.next ( ).replaceAll ( "\\," , "" ).
                    replaceAll ( " " , "" ).
                    replaceAll ( "\\!" , "" ).
                    replaceAll ( "\\?" , "" ).
                    replaceAll ( "\n" , "" ).
                    replaceAll ( "\\-" , "" ).
                    replaceAll ( "\\." , "" );
            if ( ! text.isEmpty ( ) ) {
                Integer count = map.get ( text );
                if ( count == null ) {
                    count = 0;
                }
                map.put ( text , ++ count );
            }
        }
        for ( String word : map.keySet ( ) ) {
            System.out.println ( word + ": " + map.get ( word ) );

        }
        int maxWordInText = (Collections.max ( map.values ( ) ));
        for ( Map.Entry < String, Integer > entry : map.entrySet ( ) ) {
            if ( entry.getValue ( ) == maxWordInText ) {
                System.out.println ("--------------------------------------------------------");
                System.out.println ( "Слово, которое встречается чаще, чем остальные - " + entry.getKey ( ) + ", "
                        + " повторяется " + maxWordInText + " раз(а)");

            }
        }
    }
}