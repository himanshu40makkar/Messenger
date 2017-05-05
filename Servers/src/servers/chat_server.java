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
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Himanshu Makkar
 */
public class chat_server {
    public static void main(String ar[])
    {
        try
        {
            ServerSocket ss=new ServerSocket(8001);
            while(true)
            {
                Socket sc=ss.accept();
            DataInputStream dis=new DataInputStream(sc.getInputStream());
            String uname=dis.readUTF();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost;database=him","sa","abc");
                PreparedStatement pst=conn.prepareStatement("select port,host from port where userid=? and status=0");
                pst.setString(1, uname);
                ResultSet rs=pst.executeQuery();
                DataOutputStream dos=new DataOutputStream(sc.getOutputStream());
                String host="";
                if(rs.next())
                {
                    dos.writeInt(rs.getInt(1));
                    host=rs.getString(2);
                    dos.writeUTF(host);
                    
                }
                
                pst=conn.prepareStatement("update port set status=1 where userid=? and status=0");
                pst.setString(1, uname);
                int r=pst.executeUpdate();
                CallableStatement cst=conn.prepareCall("{call add_port(?,?)}");
                cst.setString(1, uname);
                cst.setString(2, host);
                r=cst.executeUpdate();
        }}
        catch(Exception ex)
        {
            chat_server.main(ar);
            System.out.println(ex);
        }
    }
    
}
