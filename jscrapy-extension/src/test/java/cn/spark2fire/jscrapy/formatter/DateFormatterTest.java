package cn.spark2fire.jscrapy.formatter;

import cn.spark2fire.jscrapy.model.formatter.DateFormatter;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author code4crafter@gmail.com
 */
public class DateFormatterTest {

    @Test
    public void testDateFormatter() throws Exception {
        DateFormatter dateFormatter = new DateFormatter();
        String pattern = "yyyy-MM-dd HH:mm";
        Date date = DateUtils.parseDate("2013-09-10 22:11", new String[]{pattern});
        dateFormatter.initParam(new String[]{pattern});
        Date format = dateFormatter.format(DateFormatUtils.format(date, pattern));
        assertThat(format).isEqualTo(date);
    }
}
