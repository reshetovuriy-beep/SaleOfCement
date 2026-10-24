package org.example.service;

    public class AdapterPipeLine implements Adapter {
        @Override
        public String[] adapt(String line) {
            if (line == null) return new String[0];
            return line.split("\\|");
        }
    }

