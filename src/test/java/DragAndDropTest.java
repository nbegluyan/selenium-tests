import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DragAndDropTest  extends BaseSelenium{
    @Test
    public void dragAndDropAction(){
        DragAndDropPage dragAndDropPage = new DragAndDropPage();

        assertEquals("Drag me to my target", dragAndDropPage.getColum1Text(), "not correct");
        assertEquals("Drop here", dragAndDropPage.getColum2Text(), "not correct");

        dragAndDropPage.dragAndDrop();
        assertEquals("Drop here", dragAndDropPage.getColum1Text(), "not correct");
        assertEquals("Drag me to my target", dragAndDropPage.getColum2Text(), "not correct");
    }
}
