import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.*;

abstract class Voting_machine{
  abstract void vote();
}

class BJP extends Voting_machine{
   void vote(){
     try{
      FileWriter fw=new FileWriter("BJP.txt",true);
      fw.write("1");
      fw.write("\n");
      fw.close();
    }catch(Exception e){
        System.out.println("Exception is: "+ e);
    }

}
}

class INC extends Voting_machine{
   void vote(){
     try{
      FileWriter fw=new FileWriter("INC.txt",true);
      fw.write("1");
      fw.write("\n");
      fw.close();
    }catch(Exception e){
        System.out.println("Exception is: "+ e);
    }

}
}

class AAP extends Voting_machine{
   void vote(){
     try{
      FileWriter fw=new FileWriter("AAP.txt",true);
      fw.write("1");
      fw.write("\n");
      fw.close();
    }catch(Exception e){
        System.out.println("Exception is: "+ e);
    }

}
}

class BSP extends Voting_machine{
   void vote(){
     try{
      FileWriter fw=new FileWriter("BSP.txt",true);
      fw.write("1");
      fw.write("\n");
      fw.close();
    }catch(Exception e){
        System.out.println("Exception is: "+ e);
    }

}
}

class NCP extends Voting_machine{
   void vote(){
     try{
      FileWriter fw=new FileWriter("NCP.txt",true);
      fw.write("1");
      fw.write("\n");
      fw.close();
    }catch(Exception e){
        System.out.println("Exception is: "+ e);
    }

}
}

class CPI extends Voting_machine{
   void vote(){
     try{
      FileWriter fw=new FileWriter("CPI.txt",true);
      fw.write("1");
      fw.write("\n");
      fw.close();
    }catch(Exception e){
        System.out.println("Exception is: "+ e);
    }

}
}


//                         To check if person has voted earlier or not
class voter_check {
  String s="";
    int check (String s1, String s2)throws IOException
    {
      BufferedReader b=new BufferedReader(new FileReader("people_who_voted.txt"));

       while((s=b.readLine())!=null) {
         if (s.equals(s1))
         { s=b.readLine();
           if (s.equals(s2))
           {
           return 1;}
         }}

         return 0;
}}

////////                                ADMIN ID check
class admin{
  String s="";
    int admin_check (String s1, String s2)throws IOException
    {
      BufferedReader b=new BufferedReader(new FileReader("admin.txt"));

       while((s=b.readLine())!=null) {
         if (s.equals(s1))
         { s=b.readLine();
           if (s.equals(s2))
           {
           return 1;}
         }}

         return 0;
}
}

//                                      VOTER COUNT
 class voter_count {
  String s="";
    int count ()throws IOException
    {
      int counter=0;
      BufferedReader b=new BufferedReader(new FileReader("people_who_voted.txt"));

       while((s=b.readLine())!=null)
       {
          counter++;
       }
       counter = counter/2;
         return counter;
}}



class max
{
  public int max_method(int i1,int i2,int i3,int i4,int i5,int i6)
  {
    int max_result = Math.max(i1,Math.max(i2,Math.max(i3,Math.max(i4,Math.max(i5,i6)))));
    return max_result;
  }
}

class Test{
  public static void main(String args[]) throws IOException{
///             INITIALIZING ALL COUNTERS TO PREVIOUS VOTES

    int count1=0;
    int count2=0;
    int count3=0;
    int count4=0;
    int count5=0;
    int count6=0;

     String s="";
         int counter=0;
         BufferedReader b=new BufferedReader(new FileReader("previous_votes.txt"));

          while((s=b.readLine())!=null)
          {
             counter++;
             if(counter==1)
             {
               count1 = Integer.parseInt(s);
             }
             if(counter==2)
             {
               count2 = Integer.parseInt(s);
             }
             if(counter==3)
             {
               count3 = Integer.parseInt(s);
             }
             if(counter==4)
             {
               count4 = Integer.parseInt(s);
             }
             if(counter==5)
             {
               count5 = Integer.parseInt(s);
             }
             if(counter==6)
             {
               count6 = Integer.parseInt(s);
             }

          }



    String choice;
    do{
    String voter_name;
    String aadhar;
    String login_var;
    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome to Online Voting System!");
    System.out.println("Press 1 for admin login, 2 for voter login and Exit: ");
    login_var = sc.next();
    if(login_var.equals("1"))
    {
      choice = "0";
      String us,pass;
      int ad_chk_res;
      System.out.println("Enter your UserId :");
      us = sc.next();
      System.out.println("Enter your Password :");
      pass = sc.next();
      admin ad = new admin();
      ad_chk_res = ad.admin_check(us,pass);
      if(ad_chk_res==1)
      {
        String admin_log;
        System.out.println("Admin Verified!");
        System.out.println("\n");
        System.out.println("Enter 1 to check on who's winning and 2 to check number of voters: ");
        admin_log = sc.next();
        if(admin_log.equals("1"))
        {
        int most=0;
        max m = new max();
        most = m.max_method(count1,count2,count3,count4,count5,count6);
        ArrayList<String> ar = new ArrayList<String>();
        int size;
        if (most==count1)
        {
          ar.add("BJP");
        }
        if (most==count2)
        {
          ar.add("INC");
        }
        if (most==count3)
        {
          ar.add("AAP");
        }
        if (most==count4)
        {
          ar.add("BSP");
        }
        if (most==count5)
        {
          ar.add("NCP");
        }
        if(most==count6)
        {
          ar.add("CPI");
        }

        if((ar.size())==1)
        {
          System.out.println("Winning party is: " +ar.get(0));
        }
        if((ar.size())==2)
        {
          System.out.println("There is a draw between "+ar.get(0)+" and "+ar.get(1));
        }
        if((ar.size())==3)
        {
          System.out.println("There is a draw between "+ar.get(0)+" and "+ar.get(1)+" and "+ar.get(2));
        }
        if((ar.size())==4)
        {
          System.out.println("There is a draw between "+ar.get(0)+" and "+ar.get(1)+" and "+ar.get(2)+" and "+ar.get(3));
        }
        if((ar.size())==5)
        {
          System.out.println("There is a draw between "+ar.get(0)+" and "+ar.get(1)+" and "+ar.get(2)+" and "+ar.get(3)+" and "+ar.get(4));
        }
        if((ar.size())==6)
        {
          System.out.println("There is a draw between "+ar.get(0)+" and "+ar.get(1)+" and "+ar.get(2)+" and "+ar.get(3)+" and "+ar.get(4)+" and "+ar.get(5));
        }
        choice = "0";
      }
      if(admin_log.equals("2")){
          int voters;
          voter_count sp = new voter_count();
          voters = sp.count();
          System.out.println("Number of Voters are: "+voters);
        choice = "0";
      }
    }

      else{
        System.out.println("Enter valid UserId and Password!");
        System.out.println("\n");
        choice = "0";
      }
    }
    else{
    System.out.println("Enter your name: ");
    voter_name = sc.next();
    System.out.println("Enter your Voter Id number: ");
    aadhar = sc.next();
    //                    Calling check method to check on voter
    voter_check vc = new voter_check();
    int result = vc.check(voter_name,aadhar);
    if(result == 0)
    {
      System.out.println("Enter which party you want to vote for: ");
      System.out.println("1 for BJP");
      System.out.println("2 for INC");
      System.out.println("3 for AAP");
      System.out.println("4 for BSP");
      System.out.println("5 for NCP");
      System.out.println("6 for CPI");
      System.out.println("-1 to EXIT:");
      choice = sc.next();
      switch(choice)
      {
      case "1":
      {
      	BJP bjp=new BJP();
      	bjp.vote();
      	count1++;
        //          Writing voters name and aadhar to people_who_voted file
        try{
         FileWriter fw=new FileWriter("people_who_voted.txt",true);
         fw.write(voter_name);
         fw.write("\n");
         fw.write(aadhar);
         fw.write("\n");
         fw.close();
       }catch(Exception e){
           System.out.println("Exception is: "+ e);
       }//                   END OF APPENDING VOTER NAME
      	break;
      }
      case "2":
      {
        INC inc=new INC();
      	inc.vote();
      	count2++;
        //          Writing voters name and aadhar to people_who_voted file
        try{
         FileWriter fw=new FileWriter("people_who_voted.txt",true);
         fw.write(voter_name);
         fw.write("\n");
         fw.write(aadhar);
         fw.write("\n");
         fw.close();
       }catch(Exception e){
           System.out.println("Exception is: "+ e);
       }//                  END OF APPENDING VOTER NAME
      	break;
      }
      case "3":
      {
        AAP aap=new AAP();
      	aap.vote();
      	count3++;
        //        Writing voters name and aadhar to people_who_voted file
        try{
         FileWriter fw=new FileWriter("people_who_voted.txt",true);
         fw.write(voter_name);
         fw.write("\n");
         fw.write(aadhar);
         fw.write("\n");
         fw.close();
       }catch(Exception e){
           System.out.println("Exception is: "+ e);
       }//                 END OF APPENDING VOTER NAME
      	break;
      }
      case "4":
      {
        BSP bsp=new BSP();
        bsp.vote();
        count4++;
        //         Writing voters name and aadhar to people_who_voted file
        try{
         FileWriter fw=new FileWriter("people_who_voted.txt",true);
         fw.write(voter_name);
         fw.write("\n");
         fw.write(aadhar);
         fw.write("\n");
         fw.close();
       }catch(Exception e){
           System.out.println("Exception is: "+ e);
       }//               END OF APPENDING VOTER NAME
        break;
      }
      case "5":
      {
        NCP ncp=new NCP();
        ncp.vote();
        count5++;
        //        Writing voters name and aadhar to people_who_voted file
        try{
         FileWriter fw=new FileWriter("people_who_voted.txt",true);
         fw.write(voter_name);
         fw.write("\n");
         fw.write(aadhar);
         fw.write("\n");
         fw.close();
       }catch(Exception e){
           System.out.println("Exception is: "+ e);
       }//                 END OF APPENDING VOTER NAME
        break;
      }
      case "6":
      {
        CPI cpi=new CPI();
      	cpi.vote();
      	count6++;
        //         Writing voters name and aadhar to people_who_voted file
        try{
         FileWriter fw=new FileWriter("people_who_voted.txt",true);
         fw.write(voter_name);
         fw.write("\n");
         fw.write(aadhar);
         fw.write("\n");
         fw.close();
       }catch(Exception e){
           System.out.println("Exception is: "+ e);
       }//                 END OF APPENDING VOTER NAME
      	break;
      }

      }


    }
    else{
      choice = "0";
      System.out.println("You can't vote more than once!");
    }
  }
  }while(!(choice.equals("-1")));

    String sa = String.valueOf(count1);
    String sb = String.valueOf(count2);
    String sc = String.valueOf(count3);
    String sd = String.valueOf(count4);
    String se = String.valueOf(count5);
    String sf = String.valueOf(count6);
      FileWriter fw=new FileWriter("previous_votes.txt",false);
      fw.write(sa);
      fw.write("\n");
      fw.write(sb);
      fw.write("\n");
      fw.write(sc);
      fw.write("\n");
      fw.write(sd);
      fw.write("\n");
      fw.write(se);
      fw.write("\n");
      fw.write(sf);
      fw.close();




}
}
