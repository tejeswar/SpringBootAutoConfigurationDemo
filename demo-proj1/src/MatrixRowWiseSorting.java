
public class MatrixRowWiseSorting {

	public static void main(String args[])
    {
//        int rows;
//        int cols;
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter number of rows u want in matrix ");
//        rows=input.nextInt();
//        System.out.println("Enter number of columns u want in matrix ");
//        cols=input.nextInt();
//        int Numbers[][]=new int[rows][cols];
//        int temp;
//        //get input
//        System.out.println("Enter integer values ");
        
        int[][] Numbers = {{9,8,2},{4,5,1}} ;
		int rows = Numbers.length;
		int cols = Numbers[0].length;
       
    for(int i=1;i<rows;i++)
        {
            for(int a=1;a<cols;a++)
            {
                for(int j=1;j<cols-1;j++)
                if(Numbers[i][j]>Numbers[i][j+1])
                {
                   int temp =  Numbers[i][j+1];
                    Numbers[i][j+1] = Numbers[i][j];
                    Numbers[i][j] = temp;
                }
            }
        }
      
        System.out.println("sorted numbers in ascending order are : ");
        for (int i=0;i< rows;i++)
        {
            for (int j=0;j< cols;j++)
            {
               System.out.print(Numbers[i][j]+" ");
            }
        System.out.println();
}
    }
}
