import java.util.Date;

import javax.annotation.processing.SupportedAnnotationTypes;

/** Demonstrate deprecation warning */

public class Deprec {
    public static void main(String[] args ) {
        
        // Create a Date object for May 5, 1986
        @SuppressWarnings("deprecation")
        Date d = new Date(86, 04, 05);      // EXPECT DEPRECATION WARNINGS without @SuppressWarnings
        System.out.append("Date is " + d);
    
    }
}
