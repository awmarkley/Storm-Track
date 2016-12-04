package StormTrack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by awmarkley on 12/3/16.
 */
class DatePositionTest {
    LocalDateTime time1;
    LocalDateTime time2;

    DatePosition northEast;
    DatePosition southWest;

    @BeforeEach
    void setUp() {
        time1 = LocalDateTime.of(2001,1,1,0,0);
        time2 = LocalDateTime.of(2001,3,1,0,0);

        northEast = new DatePosition(time1, "250N", "100E");
        southWest = new DatePosition(time2, "150S", "200W");
    }

    @Test
    void getDate() {
        assert( northEast.getDate().equals(time1) );
        assert( southWest.getDate().equals(time2) );
    }

    @Test
    void isLatNorth() {
        assert( northEast.isLatNorth() );
        assertFalse( southWest.isLatNorth() );
    }

    @Test
    void isLongEast() {
        assert( northEast.isLongEast() );
        assertFalse( southWest.isLongEast() );
    }

    @Test
    void getLatitude() {
        assert( northEast.getLatitude() == 250 );
        assert( southWest.getLatitude() == 150 );
    }

    @Test
    void getLongitude() {
        assert( northEast.getLongitude() == 100 );
        assert( southWest.getLongitude() == 200 );
    }

    @Test
    void compareTo() {
        assert ( northEast.compareTo( southWest ) < 0 );
    }

}