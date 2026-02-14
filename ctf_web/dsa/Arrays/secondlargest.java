import java.util.*;
class secondlargest{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for(int a:arr){
            if(a>largest){
                second =largest;
                largest =a;
            }else if(a>second && a!=largest){
                second =a;
            }
        }
        System.out.println(second);
        sc.close();
    }
}