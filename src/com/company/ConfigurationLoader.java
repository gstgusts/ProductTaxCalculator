package com.company;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ConfigurationLoader {
    public Configuration load() {
        XmlMapper mapper = new XmlMapper();

        URL url = getClass().getResource("configuration.xml");
        File file = new File(url.getPath());

        try {
            return mapper.readValue(file, Configuration.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void save(Configuration conf) {
        var mapper = new XmlMapper();

        URL url = getClass().getResource("configuration.xml");
        File file = new File(url.getPath());

        try {
            mapper.writeValue(file, conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
