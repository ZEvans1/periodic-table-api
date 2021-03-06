package dao;

import models.Period;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oPeriodDaoTest {

    private Connection conn;
    private Sql2oPeriodDao periodDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        periodDao = new Sql2oPeriodDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void allGroupsAreReturned() throws Exception {
        Period testPeriod = setupPeriod();
        Period anotherPeriod = new Period(2);
        periodDao.add(testPeriod);
        periodDao.add(anotherPeriod);
        assertEquals(2, periodDao.getAll().size());
    }

    public Period setupPeriod() {
        return new Period(1);
    }
}