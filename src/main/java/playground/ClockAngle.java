package playground;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

// 시간이 주어질 떄, 시계의 시침과 분침 사이의 각도를 구해라.
public class ClockAngle {

    public static Double angle(String time) {


        String[] hourMinute = time.split(":");
        int hour = Integer.parseInt(hourMinute[0]);
        int min = Integer.parseInt(hourMinute[1]);
        double hourAngle = hour * 30 + min * 0.5;
        double minAngle = min * 6;

        double angle = Math.abs(hourAngle - minAngle);
        return Math.min(angle, 360 - angle);
    }

}

class ClockAngleTest {

    @Test
    public void BasicTests() {
        System.out.println("****** Basic Tests ******");
        assertEquals(90.0, ClockAngle.angle("3:30"), 0.001);
        assertEquals(0.0, ClockAngle.angle("12:00"), 0.001);
        assertEquals(120.0, ClockAngle.angle("12:20"), 0.001);
        assertEquals(97.5, ClockAngle.angle("12:15"), 0.001);
        assertEquals(0.0, ClockAngle.angle("12:00"), 0.001);
    }
}

