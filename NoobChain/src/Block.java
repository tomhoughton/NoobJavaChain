import java.util.Date;

public class Block {

    public String hash; // ID of the Block.
    public String previousHash; // Previous  block ID.
    private String data; // Date at which the block was created.
    private long timeStamp; // Timestamp of when the block was created in milliseconds.

    // Block Constructor:
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash(); // Must be used after other values are set.
    }

    public String calculateHash() {

        // Hash Input String:
        String input = previousHash + Long.toString(timeStamp) + data;

        // Calculate the hash:
        String calculatedHash = BlockIDUtil.applySHA256(input);

        return calculatedHash;
    }



}
