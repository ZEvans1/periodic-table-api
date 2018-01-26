package dao;

import models.Period;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oPeriodDao implements PeriodDao {

    private final Sql2o sql2o;
    public Sql2oPeriodDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Period period) {
        String sql = "INSERT INTO periods (name) Values (:name)";

        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(period)
                    .executeUpdate()
                    .getKey();
            period.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Period> getAll(){
        try (Connection con =sql2o.open()){
            return con.createQuery("SELECT * FROM periods")
                    .executeAndFetch(Period.class);
        }
    }
}
