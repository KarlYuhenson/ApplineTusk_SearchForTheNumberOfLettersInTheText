


import java.io.*;
import java.util.*;


public class ReadTextsFile {

    public static void main ( String[] args ) throws IOException {

        String sort;
        TreeSet < String > tSet = new TreeSet< String > ( );
        FileReader fin = new FileReader ( "text.txt" );

        Scanner src = new Scanner ( fin );
        while ( src.hasNextLine ( ) ) {
            sort = src.nextLine ( );
            tSet.add ( sort );
        }
        System.out.println ( tSet );

        for (String word : tSet) {
            System.out.println(word + ": " + Collections.frequency(tSet, word));
        }
    }
    }

