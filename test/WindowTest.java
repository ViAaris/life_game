import com.company.Window;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.awt.*;


public class WindowTest {

    @Test
    public void colorShouldBeBlack() {
        Window window = new Window();
        window.createWindow();
        window.initBoxes();
        Assertions.assertEquals(Color.BLACK, window.boxes[10][10].cell.getColor());
    }
}
