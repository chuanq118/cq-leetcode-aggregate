package interview.design;

public class 单例模式_静态内部类 {

    // 私有化构造方法
    private 单例模式_静态内部类(){}

    // 注意 static 类静态方法获取实例
    public static 单例模式_静态内部类 getInstance() {
        return 静态内部类.instance;
    }

    // 内部类保证懒加载
    private static class 静态内部类 {
        private final static 单例模式_静态内部类 instance = new 单例模式_静态内部类();
    }

    public void doSomethingByInstance(){
        System.out.println("Do Something By Instance.");
    }

}
