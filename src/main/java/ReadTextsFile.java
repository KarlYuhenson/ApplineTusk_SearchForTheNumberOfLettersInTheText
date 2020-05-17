


import java.io.*;
import java.util.*;


public class ReadTextsFile {

    public static void main ( String[] args ) throws IOException {

        String sort;
        ArrayList< String > al = new ArrayList< String > ( );
        ;
        FileReader fin = new FileReader ( "text.txt" );

        Scanner src = new Scanner ( fin );

        while ( src.hasNextLine ( ) ) {
            sort = src.nextLine ( );
            al.add ( sort );
            Collections.sort ( al );
        }
        for ( String word : al ) {
            System.out.println ( word + ": " + Collections.frequency ( al , word ) );
        }




            }

        }


