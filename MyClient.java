    import java.io.*;  
    import java.net.*;  
    public class MyClient {  
    public static void main(String[] args) {  
    try{      
    Socket s=new Socket("localhost",6666);  
    DataOutputStream send=new DataOutputStream(s.getOutputStream());
    DataInputStream receive=new DataInputStream(s.getInputStream());
    
    send.writeUTF("HELO");
    System.out.println("HELO");
    String str="";
    
    while(!str.equals("BYE")){
    str=receive.readUTF();
    if(str.equals("G'DAY")){
    System.out.println("server says: G'DAY");
    send.writeUTF("BYE");
    System.out.println("BYE");
    }
    }

    System.out.println("server says:"+str);
    send.flush();  
    send.close();  
     
    }catch(Exception e){System.out.println(e);}  
    }  
    }  
