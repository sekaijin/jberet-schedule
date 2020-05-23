package org.jberet.schedule._private;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.*;

public class JobParametersAdapter extends XmlAdapter<Map<String, String>, Properties> {
    @Override
    public Properties unmarshal(Map<String, String> map) throws Exception {
        Properties p = new Properties();
        if (map == null) {
            return p;
        }
        map.forEach((k, v) -> p.setProperty(String.valueOf(k), String.valueOf(v)));
        return p;
    }

    @Override
    public Map<String, String> marshal(Properties properties) throws Exception {
        Map<String, String> map = new LinkedHashMap<>();
        if (properties == null) {
            return map;
        }
        Set<String> propertyNames = properties.stringPropertyNames();
        propertyNames.forEach(name -> {
            String value = properties.getProperty(name);
            map.put(name, value);
        });
        return map;
    }
}
