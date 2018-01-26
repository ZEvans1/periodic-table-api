package dao;

import models.Group;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oGroupDao implements GroupDao {

        private final Sql2o sql2o;
        public Sql2oGroupDao(Sql2o sql2o) {
            this.sql2o = sql2o;
        }

        @Override
        public void add(Group group) {
            String sql = "INSERT INTO groups (name) Values (:name)";

            try (Connection con = sql2o.open()) {
                int id = (int) con.createQuery(sql)
                        .bind(group)
                        .executeUpdate()
                        .getKey();
                group.setId(id);
            } catch (Sql2oException ex) {
                System.out.println(ex);
            }
        }

    @Override
    public List<Group> getAll(){
        try (Connection con =sql2o.open()){
            return con.createQuery("SELECT * FROM groups")
                    .executeAndFetch(Group.class);
        }
    }
}
