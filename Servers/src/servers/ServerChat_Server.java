/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servers;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


/**
 *
 * @author Himanshu Makkar
 */
public class ServerChat_Server {
    public static void main(String ar[])
    {
        try
        {
            ServerSocket ss=new ServerSocket(8003);
            while(true)
            {
                Socket sc=ss.accept();
                DataInputStream dis=new DataInputStream(sc.getInputStream());
               String uname= dis.readUTF();
               String host=dis.readUTF();
               Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost;database=him","sa","abc");
                PreparedStatement pst=conn.prepareStatement("update usernm set host=? where userid=?");
                pst.setString(1, host);
                pst.setString(2, uname);
                int r=pst.executeUpdate();
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
}
