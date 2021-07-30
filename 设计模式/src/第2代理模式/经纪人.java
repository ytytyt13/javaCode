package 第2代理模式;

/**
 * @author yang
 * 2021年07月30日 17:10:00
 */
public class 经纪人 implements 演员接口 {

    private 演员 actor;
    private int money;

    经纪人(演员 actor){
        this.actor = actor;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public void act() {
        if (money < 1000) {
            System.out.println("钱太少,得加钱");
        }else{
            actor.act();
        }
    }
}
