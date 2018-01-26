package dao;

import models.Element;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

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
}
