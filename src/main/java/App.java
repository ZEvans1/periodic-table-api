import com.google.gson.Gson;
import dao.Sql2oElementDao;
import dao.Sql2oGroupDao;
import dao.Sql2oPeriodDao;
import models.Element;
import models.Group;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

public class App {

    public static void main(String[] args) {
        Sql2oElementDao elementDao;
        Sql2oGroupDao groupDao;
        Sql2oPeriodDao periodDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/periodic-table.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        elementDao = new Sql2oElementDao(sql2o);
        groupDao = new Sql2oGroupDao(sql2o);
        periodDao = new Sql2oPeriodDao(sql2o);
        conn = sql2o.open();

        //show groups
        get("/groups", "application/json", (req, res) -> {
            if (groupDao.getAll().size() > 0) {
                return gson.toJson(groupDao.getAll());
            } else {
                return "{\"message\":\"No groups in database.\"}";
            }
        });

        //add a group
        post("/groups/new", "application/json", (req, res) -> {
            Group group = gson.fromJson(req.body(), Group.class);
            groupDao.add(group);
            res.status(201);
            return "Added to API\n\r" + gson.toJson(group);
        });

        //show elements in a group
        get("/groups/:id/elements", "application/json", (req,res) -> {
            int groupId = Integer.parseInt(req.params("id"));
            Group groupToFind = groupDao.findById(groupId);
            List<Element> elements;
            elements = elementDao.getAllElementsByGroup(groupId);
                return gson.toJson(elements);
        });


    }

    //Filters
    after((req, res) -> {
        res.type("application/json");
    });
}
