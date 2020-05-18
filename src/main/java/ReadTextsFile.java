


import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class ReadTextsFile {

    private static int comCount;

    public static void main ( String[] args ) throws IOException {

        String readText;
        ArrayList< String > array = new ArrayList< String > ( );

        FileReader file = new FileReader ( "text.txt" );

        Scanner scanner = new Scanner ( file );

        while ( scanner.hasNextLine ( ) ) {
            readText = scanner.nextLine ( );
            array.add ( readText );
            Collections.sort ( array );
        }
        for ( String word : array ) {
            System.out.println ( word + ": " + Collections.frequency ( array , word ) );

        }
    }
}



