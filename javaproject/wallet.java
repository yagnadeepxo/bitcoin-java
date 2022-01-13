import java.sql.Timestamp;
import java.util.Date;

class wallet{
    String address = generate();

    static String generate(){
        Date date= new Date();
	    long time = date.getTime(); 
	    Timestamp ts = new Timestamp(time);
        String in = ts.toString();
        return StringUtil.applySha512(in);
    }

}

