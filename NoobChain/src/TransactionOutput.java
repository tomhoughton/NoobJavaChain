import java.security.PublicKey;

public class TransactionOutput {
    public String id;
    public PublicKey reciepient; // Also known as the new owner of these coins.
    public float value; // the amount of coins they own.
    public String parentTransactionId; // The id of the transaction this output was created.

    // Constructor:
    public TransactionOutput(PublicKey reciepient, float value, String parentTransactionId) {
        this.reciepient = reciepient;
        this.value = value;
        this.parentTransactionId = parentTransactionId;
        this.id = BlockIDUtil.applySHA256(BlockIDUtil.getStringFromKey(reciepient) + Float.toString(value) + parentTransactionId);

    }

    public boolean isMine(PublicKey publicKey) {
        return (publicKey == reciepient);
    }
}
