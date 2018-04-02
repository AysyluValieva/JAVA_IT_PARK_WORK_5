import java.sql.DriverManager;

public class Connection {
    public static void main(String[] args) {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:db.sqlite");
    }

    conn.close;
    Statement stmt = conn.createStatement();
    stmt.close();
    stmt.executeQuery ()

    }
}
