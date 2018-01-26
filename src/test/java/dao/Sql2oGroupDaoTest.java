package dao;

import models.Element;
import models.Group;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oGroupDaoTest {

    private Connection conn;
    private Sql2oGroupDao groupDao;
    private Sql2oElementDao elementDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        groupDao = new Sql2oGroupDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void allGroupsAreReturned() throws Exception {
        Group testGroup = setupGroup();
        Group anotherGroup = new Group(2);
        groupDao.add(testGroup);
        groupDao.add(anotherGroup);
        assertEquals(2, groupDao.getAll().size());
    }



    public Group setupGroup() {
        return new Group(1);
    }

    public Element setupElement() {
        return new Element("Carbon", "C", 12, 12.01, 14, 2, 0, 0);
    }


}