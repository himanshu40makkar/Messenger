/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Himanshu Makkar
 */
public class LogIn_Server {
    public static void main(String ar[])
    {
        try{
        ServerSocket ss=new ServerSocket(8000);
        while(true)
        {
           Socket sc= ss.accept();
            DataInputStream dis=new DataInputStream(sc.getInputStream());
            String uname=dis.readUTF();
            String pwd=dis.readUTF();
            String host=dis.readUTF();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost;database=him","sa","abc");
            PreparedStatement pst=conn.prepareStatement("select * from usernm where userid=? and pwd=?");
            pst.setString(1, uname);
            pst.setString(2,pwd);
            ResultSet rs=pst.executeQuery();
            DataOutputStream dos=new DataOutputStream(sc.getOutputStream());
            if(rs.next())
            {
                dos.writeInt(1);
            }
        else
        {
         dos.writeInt(0);
            
                }
            CallableStatement cst=conn.prepareCall("{call add_port(?,?)}");
            cst.setString(1, uname);
            cst.setString(2, host);
            int r=cst.executeUpdate();
             pst=conn.prepareStatement("update frienduser set status=1 where friends=?");
            pst.setString(1, uname);
            pst.executeUpdate();
        }}
        catch(Exception ex)
        {
            LogIn_Server.main(ar);
            System.out.println(ex);
        }
    }
    
}
