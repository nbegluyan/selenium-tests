import base.BasePage;
import com.google.gson.JsonObject;

public class TaigaProjectPage extends BasePage {
    private JsonObject project;
    public TaigaProjectPage(JsonObject project){
        super();
        this.project = project;
        driver.get(getUrl());
    }
    @Override
    public String getUrl() {
        return "https://tree.taiga.io/project/"
                + project.get("slug").getAsString() + "/issues";
    }
}
