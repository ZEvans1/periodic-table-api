package dao;

import models.Element;
import models.Group;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oElementDao implements ElementDao {
    private final Sql2o sql2o;
    public Sql2oElementDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Element element) {
        String sql = "INSERT INTO elements (name, symbol, atomicNumber, atomicMass, groupNumber, periodNumber, groupId, periodId) VALUES (:name, :symbol, :atomicNumber, :atomicMass, :groupNumber, :periodNumber, :groupId, :periodId)";

        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(element)
                    .executeUpdate()
                    .getKey();
            element.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Element> getAll(){
        try (Connection con =sql2o.open()){
            return con.createQuery("SELECT * FROM elements")
                    .executeAndFetch(Element.class);
        }
    }

    @Override
    public Element findById(int id) {
        String sql = "SELECT * FROM elements WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Element.class);
        }
    }

//    @Override
//    public void addElementToGroup (Element element, Group group) {
//        String sql = "INSERT INTO groups_elements (groupid, elementid) VALUES (:groupid, :elementid)";
//        try (Connection con = sql2o.open()) {
//            con.createQuery(sql)
//                    .addParameter("groupid", group.getId())
//                    .addParameter("elementid", element.getId())
//                    .executeUpdate();
//        } catch (Sql2oException ex) {
//            System.out.println(ex);
//        }
//    }

    @Override
    public List<Element> getAllElementsByGroup(int groupId) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM elements WHERE groupId = :groupId")
                    .addParameter("groupId", groupId)
                    .executeAndFetch(Element.class);
        }
    }
}
