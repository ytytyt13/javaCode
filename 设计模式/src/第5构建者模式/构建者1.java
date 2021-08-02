package 第5构建者模式;

/**
 * @author yang
 * 2021年08月02日 16:16:00
 */
public class 构建者1 implements 抽象构建者类 {
    private 产品 product = new 产品();

    @Override
    public void BuilderPartA() {
        product.设置部件("构建者1组建A");
    }

    @Override
    public void BuilderPartB() {
        product.设置部件("构建者1组建B");
    }

    @Override
    public 产品 getResult() {
        return product;
    }
}
