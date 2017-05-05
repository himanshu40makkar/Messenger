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

/**
 *
 * @author Himanshu Makkar
 */
public class addfriend_server {
    public static void main(String ar[])
    {
        try
        {
            ServerSocket ss=new ServerSocket(8006);
            while(true)
            {
                Socket sc=ss.accept();
                DataInputStream dis=new DataInputStream(sc.getInputStream());
                String uname=dis.readUTF();
                String fname=dis.readUTF();
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost;database=him","sa","abc");
                PreparedStatement pst=conn.prepareStatement("select * from usernm where userid=?");
                pst.setString(1, fname);
                ResultSet rs=pst.executeQuery();
                int r=0;
                DataOutputStream  dos=new DataOutputStream(sc.getOutputStream());
        
                if(rs.next())
                {
                    pst=conn.prepareStatement("select * from port where userid=?");
                    pst.setString(1, fname);
                    rs=pst.executeQuery();
                    if(rs.next())
                pst=conn.prepareStatement("insert into frienduser values(?,?,1)");
                    else
                pst=conn.prepareStatement("insert into frienduser values(?,?,0)");
                        
                pst.setString(1, uname);
                pst.setString(2, fname);
               
                
                pst.executeUpdate();
               pst=conn.prepareStatement("select * from port where userid=?");
                    pst.setString(1, uname);
                    rs=pst.executeQuery();
                    if(rs.next())
                pst=conn.prepareStatement("insert into frienduser values(?,?,1)");
                else
                pst=conn.prepareStatement("insert into frienduser values(?,?,0)");
                       
                    pst.setString(1, fname);
                pst.setString(2, uname);
                
                pst.executeUpdate();
                dos.writeInt(1);
                
                         

                }
                else
                {
                    dos.writeInt(0);
                }
                }
                
                
            
        }
        catch(Exception ex)
        {
         System.out.println(ex);
          addfriend_server.main(ar);
        }
          
        }
        
    }

