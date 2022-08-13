import java.util.Date;

public class Block {

    public String hash; // ID of the Block.
    public String previousHash; // Previous  block ID.
    public String data; // Date at which the block was created.
    public long timeStamp; // Timestamp of when the block was created in milliseconds.

    // Block Constructor:
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
    }





}
