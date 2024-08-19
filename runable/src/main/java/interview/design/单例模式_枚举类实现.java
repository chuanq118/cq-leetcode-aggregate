package interview.design;

public enum 单例模式_枚举类实现 {

    INSTANCE;

    单例模式_枚举类实现(){
        System.out.println("初始化");
    }

    public static 单例模式_枚举类实现 getInstance() {
        return INSTANCE;
    }

    public void doSomething2() {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        单例模式_枚举类实现.getInstance().doSomething2();
    }
}
