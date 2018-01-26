package dao;

import models.Element;
import models.Group;
import models.Period;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Sql2oElementDaoTest {

    private Connection conn;
    private Sql2oElementDao elementDao;
    private Sql2oGroupDao groupDao;
    private Sql2oPeriodDao periodDao;


    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        elementDao = new Sql2oElementDao(sql2o);
        groupDao = new Sql2oGroupDao(sql2o);
        periodDao = new Sql2oPeriodDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingElementSetsId() throws Exception {
        Group testGroup = setupGroup();
        Period testPeriod = setupPeriod();
        groupDao.add(testGroup);
        periodDao.add(testPeriod);
        Element testElement = setupElement();
//        testElement.setGroupId(testGroup.getName());
//        testElement.setPeriodId(testPeriod.getName());
        elementDao.add(testElement);
        assertEquals(1, testElement.getId());
    }

    @Test
    public void allElementsAreReturned() throws Exception {
        Element testElement = setupElement();
        Element anotherElement = new Element("Hydrogen", "H", 1, 1.00, 1, 1, 0, 0 );
        elementDao.add(testElement);
        elementDao.add(anotherElement);
        assertEquals(2, elementDao.getAll().size());
    }

    @Test
    public void getAllElementsByGroup() throws Exception {
        Group testGroup = new Group(1);
        groupDao.add(testGroup);
        Group otherGroup = new Group(1);
        groupDao.add(otherGroup);

        Element testElement = new Element("Carbon", "C", 12, 12.01, 1, 1, testGroup.getId(), 0 );

        elementDao.add(testElement);
        Element anotherElement = new Element("Hydrogen", "H", 1, 1.00, 1, 1, testGroup.getId(), 0 );

        elementDao.add(anotherElement);

        assertEquals(2, elementDao.getAllElementsByGroup(testGroup.getId()).size());
    }

    @Test
    public void getAllElementsByPeriod() throws Exception {
        Period testPeriod = new Period(1);
        periodDao.add(testPeriod);
        Period otherPeriod = new Period(1);
        periodDao.add(otherPeriod);

        Element testElement = new Element("Carbon", "C", 12, 12.01, 1, 1, 0, testPeriod.getId() );

        elementDao.add(testElement);
        Element anotherElement = new Element("Hydrogen", "H", 1, 1.00, 1, 1, 0, testPeriod.getId() );

        elementDao.add(anotherElement);

        assertEquals(1, elementDao.getAllElementsByPeriod(testPeriod.getId()).size());
    }




    //setup

    public Element setupElement() {
        return new Element("Carbon", "C", 12, 12.01, 14, 2, 0, 0);
    }

    public Group setupGroup() {
        return new Group(1);
    }

    public Period setupPeriod() {
        return new Period(1);
    }
}