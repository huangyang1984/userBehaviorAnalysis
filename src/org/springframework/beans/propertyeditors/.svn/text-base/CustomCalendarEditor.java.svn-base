/**
 * 
 */
package org.springframework.beans.propertyeditors;

import java.beans.PropertyEditorSupport;
import java.util.Calendar;

import net.ufida.x27.util.text.DateTimeUtils;

/**
 * 
 * @author Steven.yang
 *
 */
public class CustomCalendarEditor extends PropertyEditorSupport {

    public CustomCalendarEditor() {

    }

    public void setAsText(String text) throws IllegalArgumentException {
        setValue(DateTimeUtils.strDateTime2Calendar(text));
    }

    public String getAsText() {
        Calendar value = (Calendar) getValue();
        return (value != null ? DateTimeUtils.calendar2StrDateTime(value) : "");
    }

}
