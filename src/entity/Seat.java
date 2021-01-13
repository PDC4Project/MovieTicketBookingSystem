package entity;

/**
 *
 * @author zk
 */
public class Seat {
    int id;
    int roomId;
    boolean isBook;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public boolean isIsBook() {
        return isBook;
    }

    public void setIsBook(boolean isBook) {
        this.isBook = isBook;
    }
    
}
