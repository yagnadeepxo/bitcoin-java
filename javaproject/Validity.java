public class Validity {
	public static Boolean isChainValid() {
		Block currentBlock; 
		Block previousBlock;
		
		for(int i=1; i < Chain.blockchain.size(); i++) {
			currentBlock = Chain.blockchain.get(i);
			previousBlock = Chain.blockchain.get(i-1);
			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
				System.out.println("Current Hashes not equal");			
				return false;
			}
			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
		}
		return true;
	}
}
