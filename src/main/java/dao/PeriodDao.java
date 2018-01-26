package dao;

import models.Period;

import java.util.List;

public interface PeriodDao {
    void add (Period period);
    List<Period> getAll();
}
