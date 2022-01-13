import java.util.ArrayList;
import java.util.Date;

public class Block {
	public String hash;
	public String previousHash;
	private ArrayList<Transaction> data;
	private long timeStamp; 
	public int nonce;

	public Block(ArrayList<Transaction> data,String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash=calculateHash();
	}
	public String calculateHash() {
		String calculatedhash = StringUtil.applySha512( 
				previousHash +
				Long.toString(timeStamp) +
				data 
				);
		return calculatedhash;
	}
	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0'); 
		while(!hash.substring( 0, difficulty).equals(target)) {
			nonce ++;
			hash = calculateHash();
		}
		System.out.println("Block Mined!!! : " + hash);
    }

    public static void blocksummary(){
        System.out.println("miner:unknown");
        System.out.println("Blockheight: "+Chain.blockchain.size());
        System.out.println("Transactions processed: "+"true");
    }
    public static String get_merkle_root(ArrayList<Transaction> txn){
        return MerkleRoot.root(txn);
    }
}