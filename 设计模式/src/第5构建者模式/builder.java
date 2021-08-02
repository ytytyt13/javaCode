package 第5构建者模式;

/**
 * @author yang
 * 2021年08月02日 16:24:00
 */
public class builder {
    private 抽象构建者类 product;

    public builder(抽象构建者类 product) {
        this.product = product;
    }

    public 产品 build(){
        product.BuilderPartA();
        product.BuilderPartB();
        return product.getResult();
    }
}
