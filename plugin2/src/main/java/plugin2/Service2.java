package plugin2;

import api.Service;

import java.security.Provider;

public class Service2 implements Service {

    @Override
    public String get() {
        return "Получилось";
    }
}
