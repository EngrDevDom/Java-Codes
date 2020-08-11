//Write a program to split the contents of one input file to more than one output file
import java.io.*;
class File1
{
  public static void main(String args[])throws IOException 
  {
    long n,n1,n2,k,j;
    int ch,argc,i;
    RandomAccessFile fp1=new RandomAccessFile(args[0],"r");
    n=fp1.length();
    System.out.println("Size of file <"+args[0]+">="+n+" bytes");
    argc=args.length;
    n1=n/(argc-1);
    n2=n-(argc-2)*n1;
    for(i=1;i<argc;i++)
    {
      FileOutputStream fp2=new FileOutputStream(args[i]);
      if(i!=(argc-1))
      {
        k=n1;
        System.out.println("Size of file <"+args[i]+">="+k+" bytes");
      }
      else
      {
        k=n2;
        System.out.println("Size of file <"+args[i]+">="+k+" bytes");
      }
      for(j=0;j<k;j++)
      {
        ch=fp1.read();
        fp2.write(ch);
      }
      fp2.close();
    }
    fp1.close();
    System.out.println("Copying is over---->");
  }
}