package org.jberet.schedule._private;

import javax.ejb.ScheduleExpression;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class ScheduleExpressionAdapter extends XmlAdapter<Map<String, String>, ScheduleExpression> {
    private final static DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSSX");

    @Override
    public ScheduleExpression unmarshal(Map<String, String> map) throws Exception {
        if (map == null) {
            return null;
        }
        ScheduleExpression expression = new ScheduleExpression();

        Optional.ofNullable(map.get("dayOfMonth"))
                .map(String::valueOf)
                .ifPresent(expression::dayOfMonth);

        Optional.ofNullable(map.get("dayOfWeek"))
                .map(String::valueOf)
                .ifPresent(expression::dayOfWeek);

        Object endValue = map.get("end");
        if (endValue != null) {
            Date date = DATE_FORMAT.parse(endValue.toString());
            expression.end(date);
        }

        Optional.ofNullable(map.get("hour"))
                .map(String::valueOf)
                .ifPresent(expression::hour);

        Optional.ofNullable(map.get("minute"))
                .map(String::valueOf)
                .ifPresent(expression::minute);

        Optional.ofNullable(map.get("month"))
                .map(String::valueOf)
                .ifPresent(expression::month);

        Optional.ofNullable(map.get("second"))
                .map(String::valueOf)
                .ifPresent(expression::second);

        Object startValue = map.get("start");
        if (startValue != null) {
            Date date = DATE_FORMAT.parse(startValue.toString());
            expression.start(date);
        }

        Optional.ofNullable(map.get("timezone"))
                .map(String::valueOf)
                .ifPresent(expression::timezone);

        Optional.ofNullable(map.get("year"))
                .map(String::valueOf)
                .ifPresent(expression::year);
        return expression;
    }


    @Override
    public Map<String, String> marshal(ScheduleExpression scheduleExpression) throws Exception {
        Map<String, String> map = new LinkedHashMap<>();
        String dayOfMonth = scheduleExpression.getDayOfMonth();
        String dayOfWeek = scheduleExpression.getDayOfWeek();
        Date end = scheduleExpression.getEnd();
        String hour = scheduleExpression.getHour();
        String minute = scheduleExpression.getMinute();
        String month = scheduleExpression.getMonth();
        String second = scheduleExpression.getSecond();
        Date start = scheduleExpression.getStart();
        String timezone = scheduleExpression.getTimezone();
        String year = scheduleExpression.getYear();


        if (dayOfMonth != null) {
            map.put("dayOfMonth", dayOfMonth);
        }
        if (dayOfWeek != null) {
            map.put("dayOfWeek", dayOfWeek);
        }
        if (end != null) {
            String endString = DATE_FORMAT.format(end);
            map.put("end", endString);
        }
        if (hour != null) {
            map.put("hour", hour);
        }
        if (minute != null) {
            map.put("minute", minute);
        }
        if (month != null) {
            map.put("month", month);
        }
        if (second != null) {
            map.put("second", second);
        }
        if (start != null) {
            String startString = DATE_FORMAT.format(start);
            map.put("start", startString);
        }
        if (timezone != null) {
            map.put("timezone", timezone);
        }
        if (year != null) {
            map.put("year", year);
        }
        return map;
    }
}
