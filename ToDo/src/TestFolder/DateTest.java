
package TestFolder;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Nemanja
 */
public class DateTest {

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date;
    try {
        date = dateFormat.parse("2018-04-15");
        System.out.println(date.toString()); // Wed Dec 04 00:00:00 CST 2013

        String output = dateFormat.format(date); 
        System.out.println(output); // 2013-12-04
    } catch (ParseException e) {
        //e.printStackTrace();
    }
    
}
}