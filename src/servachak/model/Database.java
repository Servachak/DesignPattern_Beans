package servachak.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
/*Перший спосіб створити Singleton*/
    private static Database instance = new Database();
    private Connection conection;

    public Database() {
    }

    public static Database getInstance() {
        return instance;
    }

    /*Другий спосіб створити Singleton*/
    private static Database instanceNew;

/*Такий метод називається Lazy Initialization (лінива ініціалізація)
 *тому що створення нового обєкта названо визначенням яке не відбувається
  *  до того моменту до поки не викликається метод getInstanceNew()*/
    public static Database getInstanceNew() {

        if (instanceNew == null){
            instanceNew = new Database();
        }
        return instanceNew;
    }

    public void connect() throws Exception {
      if (conection == null){
          return;
      }
      try {
          Class.forName("com.mysql.jdbc.Driver");
      }catch (ClassNotFoundException e){
          throw new Exception("'Driver not found");

      }
        String url = String.format("jdbc:mysql://localhost:%d/patterns", 3306);
        conection = DriverManager.getConnection(url,"root","root");
    }
    public void disconnect(){
        if (conection == null){
            try {
                conection.close();
            }catch (SQLException e){
                System.out.println("Can't close connection");
            }
            conection = null;
        }
    }
}
