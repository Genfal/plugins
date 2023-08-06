package com.example.demo;

import api.Service;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

@RestController
public class rest {

    @GetMapping
    public List<String> get() {
        return PluginProvider.getPLUGINS().stream().map(Service::get).toList();
    }
}
