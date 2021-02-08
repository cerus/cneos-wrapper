package de.cerus.cneoswrapper.query;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QueryTimeTest {

    @Test
    @DisplayName("Ensure correct date & time to string conversion")
    public void testQueryTime() {
        QueryTime time = new QueryTime(new Date(0));
        Assertions.assertEquals("1970-01-01T01:00:00", time.toString());
        time = new QueryTime(new Date(TimeUnit.HOURS.toMillis(23)));
        Assertions.assertEquals("1970-01-02", time.toString());
        time = new QueryTime(new Date(1047855600000L));
        Assertions.assertEquals("2003-03-17", time.toString());
        time = new QueryTime(new Date(1586221200000L));
        Assertions.assertEquals("2020-04-07T03:00:00", time.toString());
    }

}
