import api.ApiHelper;
import api.Client;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;




public class TaigaProjectTest extends BaseSelenium {
    private JsonObject project;
    private JsonObject issue;
    private JsonArray allProjects;

    @BeforeMethod
    public void setUpMethod() throws IOException {
        Client.getAccessToken("sat.mkrtchyan@gmail.com", "bulgakov12345");
        allProjects = ApiHelper.getAllProjects();
        project = ApiHelper.createProject();

    }

    @AfterMethod
    public void tearDownMethod() throws IOException {
        if (issue != null) {
            ApiHelper.deleteIssue(issue);
        }
        if (project != null) {
            ApiHelper.deleteProject(project);
        }

        if (allProjects.size() > 1) {
            for (int i = 0; i < allProjects.size(); i++) {
                ApiHelper.deleteProject((JsonObject) allProjects.get(i));
            }
        }
    }

    @Test
    public void projectPage(Method method) throws IOException {
        issue = ApiHelper.createIssue(project.get("id").getAsInt());
        new TaigaLoginPage();
        login("sat.mkrtchyan@gmail.com", "bulgakov12345");
        TaigaProjectPage projectPage = new TaigaProjectPage(project);
    }

}


