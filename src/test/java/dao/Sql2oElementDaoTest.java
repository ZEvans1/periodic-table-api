package dao;

import models.Element;
import models.Group;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oElementDaoTest {

    private Connection conn;
    private Sql2oElementDao elementDao;
    private Sql2oGroupDao groupDao;


    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        elementDao = new Sql2oElementDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingReviewSetsId() throws Exception {
        Group testGroup = setupGroup();
        groupDao.add(testGroup);
        Review testReview = new Review("Captain Kirk", "food coma!", 3, testRestaurant.getId());
        reviewDao.add(testReview);
        assertEquals(1, testReview.getId());
    }

    public Element setupElement() {
        return new Element("Carbon", "C", 12, 12.01, 14, 2, 14, 2);
    }

    public Group setupGroup() {
        return new Group(1);
    }
}