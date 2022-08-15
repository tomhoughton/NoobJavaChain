// Transaction class:
// Each transaction must carry a certain amount of data:
// The public Key of the sender.
// The private key of the sender.
// The value/amount of funds to be transferred.
// Input which are references to previous transactions that prove the sender has funds to send.
// OUtput, which shows the amount relevant addresses received in the transaction.
// A cryptographic signature, which proves the owner of the address is the one sending this transaction.

import java.security.PrivateKey;
import java.security.PublicKey;

public class Transaction {

    public String transactionId; // This is also the hash of the transaction.
    public PublicKey sender; // Senders address/public key.
    public PublicKey reciepient; // Recipients address/public key.
    public float value;
    public byte[] signature; // This is to prevent anybody else from spending funds.

    private static int sequence = 0; // A rough count of how many transaction have been generated.

    // Transaction input and outputs:
    //public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
    //public ArrayList<TransactionOutput> outputs = new ArrayList<TransactionOutput>();

    public Transaction (PublicKey from, PublicKey to, float value) {
        this.sender = from;
        this.reciepient = to;
        this.value = value;
        //this.inputs = inputs;
    }

    public void generateSignature(PrivateKey privateKey) {
        String data = BlockIDUtil.getStringFromKey(sender) +
                      BlockIDUtil.getStringFromKey(reciepient) +
                      Float.toString(value);

        signature = BlockIDUtil.applyECDSASig(privateKey, data);
    }

    public boolean verifySignature() {
        String data = BlockIDUtil.getStringFromKey(sender) +
                      BlockIDUtil.getStringFromKey(reciepient) +
                      Float.toString(value);

        return BlockIDUtil.verifyECDSASig(sender, data, signature);
    }

    // This Calculates the transaction hash (which will be used as its Id).
    private String calculateHash() {
        sequence++; // Increase the sequence to avoid 2 identical transactions having the same hash.
        return BlockIDUtil.applySHA256(
                BlockIDUtil.getStringFromKey(sender) +
                BlockIDUtil.getStringFromKey(reciepient) +
                Float.toString(value) + sequence
        );
    }
}
