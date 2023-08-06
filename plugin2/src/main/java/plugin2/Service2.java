package plugin2;

import api.Plugin;
import api.Service;

@Plugin("Correct")
public class Service2 implements Service {

    @Override
    public String get() {
        return "Получилось";
    }
}
