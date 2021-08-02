package 第6观察者模式;

/**
 * @author yang
 * 2021年08月02日 17:29:00
 */
abstract class 观察者接口 {
    private String name;
    private 通知者接口 通知者;
    abstract void update();

    public 观察者接口(String name, 通知者接口 通知者) {
        this.name = name;
        this.通知者 = 通知者;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public 通知者接口 get通知者() {
        return 通知者;
    }

    public void set通知者(通知者接口 通知者) {
        this.通知者 = 通知者;
    }
}
