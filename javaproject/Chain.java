import java.util.ArrayList;
import com.google.gson.GsonBuilder;
public class Chain {
	
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static int difficulty = 0;

	public static void main(String[] args) {
		wallet g_Wallet1 = new wallet();
        wallet g_wWallet2 = new wallet();
		wallet wallet1 = new wallet();
		wallet wallet2 = new wallet();
		wallet wallet3 = new wallet(); 


        Transaction g_txn1 = new Transaction(g_Wallet1.address, g_wWallet2.address,3);
		
		Transaction txn1 = new Transaction(wallet1.address,wallet2.address,5);
		Transaction txn2 = new Transaction(wallet2.address,wallet1.address,4);
		Transaction txn3 = new Transaction(wallet3.address,wallet1.address,6);
		Transaction txn4 = new Transaction(wallet2.address,wallet1.address,2);
		
		ArrayList<Transaction> G_txns = new ArrayList<>();
        G_txns.add(g_txn1);

	    ArrayList<Transaction> txnlist = new ArrayList<>();
		txnlist.add(txn1);
		txnlist.add(txn2);
		txnlist.add(txn3);
		txnlist.add(txn4);

		
		// creating a block
		blockchain.add(new Block(G_txns, "0"));
		System.out.println("Mining genesis block");
		blockchain.get(0).mineBlock(difficulty);
        Block.blocksummary();
		
		blockchain.add(new Block(txnlist,blockchain.get(blockchain.size()-1).hash));
		System.out.println("Mining block 1");
		blockchain.get(1).mineBlock(difficulty);
        Block.blocksummary();
        System.out.println("Merkle root: "+Block.get_merkle_root(txnlist));
		
		
		System.out.println("\nBlockchain is Valid: " + Validity.isChainValid());
		
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println("\nThe block chain: ");
		System.out.println(blockchainJson);	
	}

}
