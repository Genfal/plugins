package plugin;

import api.Plugin;
import api.Service;

@Plugin("Hui")
public class Service1 implements Service {

    @Override
    public String get() {
        return "Хуй";
    }
}
