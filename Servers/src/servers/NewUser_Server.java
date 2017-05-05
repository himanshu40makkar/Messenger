/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Himanshu Makkar
 */
public class NewUser_Server {
    
    public static void main(String ar[])
    {
        try
        {
            ServerSocket ss=new ServerSocket(8005);
            while(true)
            {
                Socket sc=ss.accept();
                DataInputStream dis=new DataInputStream(sc.getInputStream());
                String uname=dis.readUTF();
                String pws=dis.readUTF();
                String name=dis.readUTF();
                String sex=dis.readUTF();
                Object age=dis.readUTF();
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost;database=him", "sa", "abc");
                PreparedStatement pst=conn.prepareStatement("insert into usernm values(?,?,?,?,?)");
                pst.setString(1, uname);
                pst.setString(2, pws);
                pst.setString(3, name);
                pst.setString(4, sex);
                pst.setObject(5, age);
                int r=0;
                
                r=pst.executeUpdate();
                
                DataOutputStream dos=new DataOutputStream(sc.getOutputStream());
                
                if(r>0)
                {
                 dos.writeInt(1);
                }
              
            }
        }
        catch(Exception ex)
        {
            NewUser_Server.main(ar);
           
            System.out.println(ex);
        }
        }
    
}