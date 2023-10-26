package dao;

import beans.Fruit;

import java.util.List;

public interface FruitDao {
    //热卖水果id
    public List<Fruit> findHot();

    //根据id查询水果详情
    public Fruit findById(int fid);

    //根据关键字搜索
    public List<Fruit> findByStr(String keyword);

    //查询所有商品
    public List<Fruit> findAll();

    //新增商品
    public int add(Fruit fruit);

    //修改
    public int update(Fruit fruit);

    //删除
    public int del(int fid);



}
