//https://ideone.com/WmWTM6
public class MatrixSort {

	public static void main(String[] args) {
		int n = 3 ;
		//int[][] arr = {{9,8,2},{4,5,1},{6,7,3}} ;
		int[][] arr = {{9,8,2},{4,5,1}} ;
		int rowLength = arr.length;
		int colLength = arr[0].length;
		int min,i,j,tmp,y,k,w,z=0,q=0;
	    for(i=0;i<rowLength;i++)
	        for(j=0;j<colLength;j++)
	        {
	            z = i;
	            q = j;
	            min=arr[i][j];
	            w=j;
	            for(k=i;k<rowLength;k++)
	            {
	                for(;w<colLength;w++) {
	                	 if(arr[k][w]<min)
	 	                {
	 	                    min=arr[k][w];
	 	                    z=k;
	 	                    q=w;
	 	                }
	                }
	               
	                w=0;
	            }
	            tmp=arr[i][j];
	            arr[i][j]=min;
	            arr[z][q]=tmp;
	        }
	 
	    for(i=0;i<rowLength;i++)
	    {
	        for(j=0;j<colLength;j++)
	        	 System.out.println(arr[i][j]);
	        System.out.println("\n");
	    }
	}
}
