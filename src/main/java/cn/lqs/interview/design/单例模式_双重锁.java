package cn.lqs.interview.design;

public class 单例模式_双重锁 {

    private static volatile Object instance;

    private 单例模式_双重锁() {};

    private static Object getInstance(){
        if(instance == null){
            synchronized(单例模式_双重锁.class){
                if(instance == null){
                    instance = new Object();
                }
            }
        }
        return instance;
    }

}
