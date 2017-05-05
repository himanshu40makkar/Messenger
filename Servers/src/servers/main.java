/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servers;

/**
 *
 * @author Himanshu Makkar
 */
class fun  implements Runnable
{

    Thread t;
    public fun()
    {
        t=new Thread(this);
        t.start();

    }
    @Override
    public void run() {
        try
        {
          String ar[]=null;
 List_server.main( ar);
     }
    catch(Exception ex)
    {
        System.out.println(ex);
    }}

    
    
}
class fun2  implements Runnable
{

    Thread t;
    public fun2()
    {
        t=new Thread(this);
        t.start();

    }
    @Override
    public void run() {
        try
        {
            String ar[]=null;
 LogIn_Server.main( ar);
        }
    catch(Exception ex)
    {
        System.out.println(ex);
    }}
}
class fun3  implements Runnable
{

    Thread t;
    public fun3()
    {
        t=new Thread(this);
        t.start();

    }
    @Override
    public void run() {
        try
        {
            String ar[]=null;
 NewChat_Server.main( ar);
        }
    catch(Exception ex)
    {
        System.out.println(ex);
    }}

    
    
}
class fun4  implements Runnable
{

    Thread t;
    public fun4()
    {
        t=new Thread(this);
        t.start();

    }
    @Override
    public void run() {
        try
        {
            String ar[]=null;
 NewUser_Server.main( ar);
        }
    catch(Exception ex)
    {
        System.out.println(ex);
    }}
}
class fun5  implements Runnable
{

    Thread t;
    public fun5()
    {
        t=new Thread(this);
        t.start();

    }
    @Override
    public void run() {
        try
        {
            String ar[]=null;
 addfriend_server.main(ar);
        }
    catch(Exception ex)
    {
        System.out.println(ex);
    }}
}
class fun6  implements Runnable
{

    Thread t;
    public fun6()
    {
        t=new Thread(this);
        t.start();

    }
    @Override
    public void run() {
        try
        {
            String ar[]=null;
 chat_server.main( ar);
        }
    catch(Exception ex)
    {
        System.out.println(ex);
    }}
}
class fun7  implements Runnable
{

    Thread t;
    public fun7()
    {
        t=new Thread(this);
        t.start();
       
    }
    @Override
    public void run() {
        try
        {
            String ar[]=null;
 logut_server.main( ar);
        }
    catch(Exception ex)
    {
        System.out.println(ex);
    }}
}

public class main  {
    
    public static void main(String ar[])
    {
        
        fun a=new fun();
        fun2 s1=new fun2();
        fun3 s2=new fun3();
        fun4 s3=new fun4();
        fun5 s4=new fun5();
        fun6 s5=new fun6();
        fun7 s6=new fun7();
        try
        {
     }
    catch(Exception ex)
    {
        System.out.println(ex);
    }}
    
}
