
public class Transaction {
	
	public String transactionId=calulateHash(); 
	public String sender_address;
    public String reciever_address; 
	public float value;
	
	
	
	private static int sequence = 0; 
	
	
	public Transaction(String from, String to, float value) {
		this.sender_address = from;
		this.reciever_address = to;
		this.value = value;
	}
	

	private String calulateHash() {
		sequence++; //collision resisitor
		return StringUtil.applySha512(
				Float.toString(value) + sequence
				);
	}    
}
