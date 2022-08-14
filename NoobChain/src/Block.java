import java.util.Date;

public class Block {

    public String hash; // ID of the Block.
    public String previousHash; // Previous  block ID.
    private String data; // Date at which the block was created.
    private long timeStamp; // Timestamp of when the block was created in milliseconds.
    private int nonce;

    // Block Constructor:
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash(); // Must be used after other values are set.
    }

    public String calculateHash() {

        // Hash Input String:
        String input = previousHash + Long.toString(timeStamp) + data + Integer.toString(nonce);

        // Calculate the hash:
        String calculatedHash = BlockIDUtil.applySHA256(input);

        return calculatedHash;
    }

    public void mineBlock(int difficulty) {
        // Create a string with difficulty * "0"
        String target = new String(new char[difficulty]).replace('\0', '0');

        while (!hash.substring(0, difficulty).equals(target)) {
            nonce ++;
            hash = calculateHash();
        }
        System.out.println("Block mined !!!: " + hash);
    }
}
