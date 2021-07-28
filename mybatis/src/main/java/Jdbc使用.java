import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author yang
 * 2021年01月26日 16:40:00
 */
public class Jdbc使用 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //通过驱动管理类来获取数据库链接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_study?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT", "root", "root");
            //定义sql语句
            String sql = "select name,age,salary from tx_user";
            //获取预处理statement
            preparedStatement = connection.prepareStatement(sql);
            //执行sql，获取结果
            resultSet = preparedStatement.executeQuery();
            //遍历resultSet取出结果
            while(resultSet.next()) {
                System.out.println(
                        " name="+resultSet.getString("name")
                        +" salary="+resultSet.getLong("salary"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null ) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
