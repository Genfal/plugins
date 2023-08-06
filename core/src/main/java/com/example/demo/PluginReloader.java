package com.example.demo;

import api.Plugin;
import api.Service;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

@Component
public class PluginReloader {

    private final String PATH = "C:\\Users\\Andrew\\Desktop\\plugins";

    public PluginReloader() {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            loadPlugins();
            System.out.println("Были прочитаны плагины");
        }, 5000, 10000, TimeUnit.MILLISECONDS);
    }

    @SneakyThrows
    private void loadPlugins() {
        Map<String, Service> plugins = new HashMap<>();
        File dir = new File(PATH);
        if (!dir.exists()) {
            Files.createDirectory(Path.of(PATH));
        }
        for (File file : dir.listFiles()) {
            try (JarFile jarFile = new JarFile(file)) {
                var e = jarFile.entries();
                var urls = new URL[]{new URL("jar:file:" + file.getPath() + "!/")};
                var cl = URLClassLoader.newInstance(urls);
                while (e.hasMoreElements()) {
                    JarEntry je = e.nextElement();
                    if (je.isDirectory() || !je.getName().endsWith(".class")) {
                        continue;
                    }
                    String className = je.getName().substring(0, je.getName().length() - 6);
                    className = className.replace('/', '.');
                    Class<?> c = cl.loadClass(className);
                    for (Class<?> clazz : c.getInterfaces()) {
                        if (clazz.equals(Service.class)) {
                            var constructors = c.getConstructors();
                            var Service = (Service) constructors[0].newInstance();
                            plugins.put(c.getAnnotation(Plugin.class).value(), Service);
                            break;
                        }
                    }
                }
            }
        }
        PluginProvider.setPLUGINS(plugins);
    }
}
