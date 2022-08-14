import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class NoobChain {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    public static void main(String[] args) {
        // Add out block to the blockchain Array List:
        blockchain.add(new Block("Hi, I'm the first block", "0"));
        blockchain.add(new Block("Yo I'm the seoncd block", blockchain.get(blockchain.size() - 1).hash));
        blockchain.add(new Block("Yo I'm the third block", blockchain.get(blockchain.size() - 1).hash));

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);
    }
    
    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        // Loop through blockchain to check hashes:
        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);

            // Compare the registered hash and calculated hash:
            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes are not equal");
                return false;
            }

            // Compare rpevious hash and registered previous hash:
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous Hashes are not equal");
                return false;
            }
        }
        return true;
    }
}
