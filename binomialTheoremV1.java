public class binomialTheoremV1
{
   public int[][] para; //int[a][b]: coff of poly that is (x^a)(y^b)
   public int times;
   public int timesLeft;
   
   public binomialTheoremV1(int n)
   {
      times=n;
      timesLeft=n;
      para=new int[2][2];
      para[1][0]=1;
      para[0][1]=1;
   }
   
   public void run()
   {
      if (timesLeft==0)
      {
         System.out.println("(x+y)^0 = 1");
         return;
      }
      if (timesLeft==1)
      {
         print();
         return;
      }
      int[][] rslt=new int[para.length+1][para.length+1];
      for (int i=0;i<para.length;i++)
      {
         rslt[i+1][para.length-1-i]+=para[i][para.length-1-i];
         rslt[i][para.length-i]+=para[i][para.length-1-i];
      }
      para=rslt;
      timesLeft--;
      run();
   }
   
   public void print()
   {
      String rslt="(x+y)^"+times+" = ";
      for (int j=0;j<para.length;j++)
      {
         for (int i=0;i<para[j].length;i++)
         {
            if (para[i][j]!=0)
            {
               if (para[i][j]!=1)
               {
                  rslt+=para[i][j];
               }
               switch(i)
               {
                  case 0:
                     break;
                  case 1:
                     rslt+="x";
                     break;
                  default:
                     rslt+="x^"+i+((j==0)?"":" * ");
               }
               switch(j)
               {
                  case 0:
                     break;
                  case 1:
                     rslt+="y";
                     break;
                  default:
                     rslt+="y^"+j;
               }
               rslt+=" + ";
            }
         }
      }
      System.out.println(rslt.substring(0,rslt.length()-3));
   }
   
}
