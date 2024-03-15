package dsd.socket.test;

public class TesteSplit {
    
    public static void main(String[] args) {
        
        String message = "GET;11317376951;MATHEUS;04/07/2002";
        String message_split[] = message.split(";");
        
        for (String m : message_split) {
            System.out.println(m);
        }
    }
    
    
}
