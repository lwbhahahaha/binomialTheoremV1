public class binomialTheoremDriver
{

   public static void main(String[] args)
   {
      binomialTheoremV1 test;
      for (int i=0;i<=10;i++)
      {
         test = new binomialTheoremV1(i);
         test.run();
      }
   }
   
}
