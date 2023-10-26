package service;

import beans.Fruit;
import dao.FruitDao;
import dao.impl.FruitDaoImpl;

import java.util.List;

public class FruitServiceImpl implements FruitService {
    private FruitDao fruitDao = new FruitDaoImpl();

    public List<Fruit> findHot() {
        return fruitDao.findHot();
    }

    public Fruit findById(int fid) {
        return fruitDao.findById(fid);
    }

    public List<Fruit> findByStr(String keyword) {
        return fruitDao.findByStr(keyword);
    }

    public List<Fruit> findAll() {
        return fruitDao.findAll();
    }

    public boolean add(Fruit fruit) {
        int num = fruitDao.add(fruit);
        if (num == 1){
            return true;
        }else {
            return false;
        }
    }

    public boolean update(Fruit fruit) {
        int num = fruitDao.update(fruit);
        if (num == 1){
            return true;
        }else {
            return false;
        }
    }

    public boolean del(int fid) {
        int num = fruitDao.del(fid);
        if (num == 1){
            return true;
        }else {
            return false;
        }
    }


}
