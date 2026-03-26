package horloge;

import java.time.LocalDateTime;

public class MockHorloge implements Horloge {
    private final LocalDateTime fakeDate ;

    public MockHorloge(LocalDateTime fakeDateTime) {
        this.fakeDate = fakeDateTime;
    }

    @Override
    public LocalDateTime now() {
        return fakeDate;
    }


}
