package db;

import java.sql.Connection;

/**
 *
 * @author zk
 */
public class SeatDao {
<<<<<<< HEAD
       private final DB db;
        public SeatDao(){
        db = new DB();
        
        
        
        }
=======
     private final DB db;
    private final Connection conn;
    public SeatDao(){
        db = new DB();
        conn = db.getConnection();
    }
    public void select(int roomId)
    {
        
    }
>>>>>>> develop-zk
}
