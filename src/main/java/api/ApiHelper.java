package api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;

import java.io.IOException;
import java.util.Date;

public class ApiHelper {
    public static JsonObject createProject(JsonObject project) throws IOException {
        Response response;
        response = Client.post("/projects", project);
        String jsonString = response.body().string();
        return new JsonParser().parse(jsonString).getAsJsonObject();

    }

    public static JsonObject createIssue(JsonObject issue) throws IOException {
        Response response;
        response = Client.post("/issues", issue);
        String jsonString = response.body().string();
        return new JsonParser().parse(jsonString).getAsJsonObject();
    }
    public static JsonObject createProject() throws IOException {
       JsonObject project = new JsonObject();
        project.addProperty("name", "test-project" + new Date().getTime());
        project.addProperty("is_private", false);
        project.addProperty("creation_template", 1);
        project.addProperty("description", "project");
        return createProject(project);


    }
    public static JsonObject createIssue(int projectID) throws IOException {

        JsonObject issue = new JsonObject();
        issue.addProperty("subject", "Test_issue");
        issue.addProperty("description", "test_description");
        issue.addProperty("project", projectID);
        return createIssue(issue);


    }


    public static void deleteIssue(JsonObject issue) throws IOException{
        Client.delete("/issues", issue);

    }
    public static void deleteProject(JsonObject project) throws IOException{
        Client.delete("/projects", project);

    }
    public static JsonArray getAllProjects() throws IOException {
        Response response = Client.get("/projects?member=" + getCurrentUser().get("id").getAsString());
        String jsonString = response.body().string();
        return new JsonParser().parse(jsonString).getAsJsonArray();
    }

    public static JsonObject getCurrentUser() throws IOException {
        Response response;
        response = Client.get("/users/me");
        String jsonString = response.body().string();
        return  new JsonParser().parse(jsonString).getAsJsonObject();
    }

    public JsonObject getProject(String projectId) throws IOException {
        Response response = Client.get("/projects/" + projectId);
        String jsonString = response.body().string();
        return  new JsonParser().parse(jsonString).getAsJsonObject();
    }




}
