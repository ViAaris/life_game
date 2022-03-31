import com.company.Box;
import com.company.Window;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.awt.*;
import java.util.ArrayList;


public class WindowTest {

    @Test
    public void colorShouldBeBlack() {

        Window.createWindow();
        Window.initBoxes();
        Assertions.assertEquals(Color.BLACK, Window.boxes[10][10].cell.getColor());
    }

    @Test
    public void nearCellsShouldBeAdded(){
        Window window = new Window();
        Window.createWindow();
        Window.initBoxes();
        ArrayList<Box.Cell> list = Window.boxes[39][19].cell.getNearCells();
        Assertions.assertEquals(8, list.size());
        for(Box.Cell c: list){
            c.getCoord();
        }
    }
}
