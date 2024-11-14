package exercises.algos.questions;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * Given a time in -hour AM/PM format, convert it to military (24-hour) time.
 *
 * Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
 * - 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
 */
public class TimeConversions {

    public static void main(String[] args) throws IOException, ParseException {
        String str = "07:05:45PM";
        DateFormat df = new SimpleDateFormat("hh:mm:ssaa");

        //Date/time pattern of desired output date (24 Hours format HH - Used for 24 hours)
        DateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = null;
        String output = null;

        //Returns Date object
        date = df.parse(str);

        //old date format to new date format
        output = outputFormat.format(date);
        System.out.println(output);
    }

}
