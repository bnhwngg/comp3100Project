    import java.io.*;  
    import java.net.*;  
    public class MyClient {  
    public static void main(String[] args) {  
    try{      
    Socket s=new Socket("localhost",6666);  
    DataOutputStream send=new DataOutputStream(s.getOutputStream());
    BufferedReader receive=new BufferedReader(new InputStreamReader(s.getInputStream()));
    
    send.write(("HELO\n").getBytes());
    System.out.println("HELO");
    String str="";
    
    while(!str.equals("BYE")){
    str=receive.readLine();
    if(str.equals("G'DAY")){
    System.out.println("server says: G'DAY");
    send.write(("BYE\n").getBytes());
    System.out.println("BYE");
    }
    }

    System.out.println("server says:"+str);
    send.flush();  
    send.close();  
     
    }catch(Exception e){System.out.println(e);}  
    }  
    }  
