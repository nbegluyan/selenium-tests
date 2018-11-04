import base.WaitHelper;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class WaitHomeworkTest  {

    @Test
    public void loading(){
        WaitHomework waitHomework = (WaitHomework) new  WaitHomework().get();
        WaitHomework homework = new WaitHomework();
        homework.clickStart();
        assertEquals("Hello World!", homework.getFinishText(), "Text was not correct!");


    }


}
