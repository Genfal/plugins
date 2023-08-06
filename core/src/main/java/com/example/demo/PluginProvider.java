package com.example.demo;

import api.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PluginProvider {
    public static Map<String, Service> PLUGINS = new HashMap<>();

    public static Map<String, Service> getPLUGINS() {
        return PLUGINS;
    }

    public static void setPLUGINS(Map<String, Service> PLUGINS) {
        PluginProvider.PLUGINS = PLUGINS;
    }

    public static Service getService(String name) {
        return PLUGINS.get(name);
    }
}
