package org.example.horloge;

import java.time.LocalDateTime;

public class WrapperHorloge implements Horloge {


    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
