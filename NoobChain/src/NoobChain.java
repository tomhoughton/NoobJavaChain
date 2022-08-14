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
}
