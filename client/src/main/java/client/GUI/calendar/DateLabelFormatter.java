package client.GUI.calendar;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Class of DateFormater for {@link client.GUI.calendar.Calendar}
 */
public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

    private final String datePattern = "yyyy-MM-dd";
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    @Override
    public String valueToString(Object value) {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }

        return "";
    }

}