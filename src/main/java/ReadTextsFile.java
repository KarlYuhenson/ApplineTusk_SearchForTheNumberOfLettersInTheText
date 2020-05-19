import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ReadTextsFile {
    static Scanner scFile;

    static void scannerFile () {
        System.out.println ( "Введите путь до файла" );
        scFile = new Scanner ( System.in );
        File file = new File ( scFile.nextLine ( ));
        try {
            scFile = new Scanner ( file );
        } catch (FileNotFoundException ex) {
            System.out.println ( "Системе не удается найти указанный путь" );
            scannerFile ( );
        }
    }

    public static void main ( String[] args ) {
        scannerFile ( );
        Map<String, Integer> map = new TreeMap <> ();
        for ( Scanner scannerText = scFile; scannerText.hasNext ( ); ) {
            String text = scFile.next ( ).replaceAll ( "\\," , "" ).
                    replaceAll(" ", "").
                    replaceAll("\\!", "").
                    replaceAll( "\\?", "").
                    replaceAll("\n", "").
                    replaceAll("\\-", "").
                    replaceAll("\\.", "");
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
        Integer max = map.entrySet()
                .stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                .get()
                .getValue();

        List listOfMax = map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == max)
                .map(Map.Entry::getKey)
                .collect( Collectors.toList());

        System.out.println ("------------------------------------------------------------------------------" );

        System.out.println("Слово, которое встречается чаще чем остальные - " + listOfMax);


    }
}