import java.util.ArrayList;

public class MerkleRoot{
	
	public static String root(ArrayList<Transaction> txnlist) {
		
		String leaf1 = StringUtil.applySha512(txnlist.get(0).transactionId+txnlist.get(1).transactionId);
		String d_leaf1 = StringUtil.applySha512(leaf1);
		String leaf2 = StringUtil.applySha512(txnlist.get(0).transactionId+txnlist.get(1).transactionId);
		String d_leaf2 = StringUtil.applySha512(leaf2);
		String merkle_root = StringUtil.applySha512(d_leaf1+d_leaf2);
		return merkle_root;	
	}
}
