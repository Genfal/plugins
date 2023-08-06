package com.example.demo;

import api.Service;

import java.util.ArrayList;
import java.util.List;

public class PluginProvider {
    public static List<Service> PLUGINS = new ArrayList<>();

    public static List<Service> getPLUGINS() {
        return PLUGINS;
    }

    public static void setPLUGINS(List<Service> PLUGINS) {
        PluginProvider.PLUGINS = PLUGINS;
    }
}
