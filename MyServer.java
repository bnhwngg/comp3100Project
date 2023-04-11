import java.io.*;  
import java.net.*;  
public class MyServer {  
public static void main(String[] args){  
try{  
ServerSocket ss=new ServerSocket(6666);  
Socket s=ss.accept();//establishes connection   
DataInputStream receive=new DataInputStream(s.getInputStream());
DataOutputStream send=new DataOutputStream(s.getOutputStream());
String str="";

while(!str.equals("BYE")){
str=receive.readUTF();
if(str.equals("HELO")){
send.writeUTF("G'DAY");
System.out.println("client says:"+str);
System.out.println("G'DAY");
}
}

if(str.equals("BYE")){
System.out.println("client says:"+str);
send.writeUTF("BYE");
System.out.println("BYE");   
ss.close();
}


}catch(Exception e){System.out.println(e);}  
}  
}  
