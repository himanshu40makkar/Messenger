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
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author Himanshu Makkar
 */
public class List_server {
    public static void main(String ar[])
    {
        try
        {
        ServerSocket ss=new ServerSocket(8004);
        while(true)
        {
            Socket sc=ss.accept();
            DataInputStream dis=new DataInputStream(sc.getInputStream());
            String uname=dis.readUTF();
            DataOutputStream dos=new DataOutputStream(sc.getOutputStream());
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost;database=him","sa","abc");
            PreparedStatement pst=conn.prepareStatement("select friends from frienduser where userid=? and status=1");
            pst.setString(1, uname);
            ResultSet rs=pst.executeQuery();
            int i=0;
            while(rs.next())
            {
                i++;
            }
            if(i==0)
            {
                i++;
                dos.writeInt(i);
                dos.writeUTF("No Freind online");
            
            }
            else
            {
            dos.writeInt(i);
             pst=conn.prepareStatement("select friends from frienduser where userid=? and status=1");
            pst.setString(1, uname);
            rs=pst.executeQuery();
            
            
            while(rs.next())
            {
                dos.writeUTF(rs.getString(1));
            }
            }
        }
        
        }
        catch(Exception ex)
        {
            List_server.main(ar);
            System.out.println(ex);
        }
    }
    
}
