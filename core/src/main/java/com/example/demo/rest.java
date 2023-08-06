package com.example.demo;

import api.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class rest {

    @GetMapping
    public List<String> get() {
        return PluginProvider.getPLUGINS().values().stream().map(Service::get).toList();
    }

    @GetMapping("/{plugin}")
    public String getPlugin(@PathVariable String plugin) {
        return PluginProvider.getService(plugin).get();
    }
}
