public class _Arrays {
    public void uniqueArray(int [] arr){
        int index = 0;
        int fastRunner = -1;
        for(int i = 0; i < arr.length; i++){
            if(fastRunner != arr[i]){
                fastRunner = arr[i];
                arr[index] = fastRunner;
                index++;
            }
        }
        // displaying
        for(int num: arr){
            System.out.println(num);
        }
        System.out.println();
    }

    public int removeVal(int [] arr, int val){
        int fastRunner = -1;
        int index = 0;
        int k = 0;
        for(int i = 0; i < arr.length; i++){
            fastRunner = arr[i];
            if(fastRunner != val){
                arr[index] = fastRunner;
                index++;
            }
        }
        k = index;
        for(int num : arr){
            System.out.println(num);
        }
        System.out.println(k);     
        return k;

              
    }
    public int maximumProfit(int [] prices){
        int buy = prices[0];
        int sell = 0; 
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] <= buy){
                buy = prices[i];
                sell = prices[i];
            }
            if(prices[i] >= sell){
                sell = prices[i];
            }
            
        }
        System.out.println("min: " + buy);
        System.out.println("max: " + sell);

        maxProfit = sell - buy;

        System.out.println(maxProfit);
        return maxProfit;        
    }

    public static void main(String[] args) {
        _Arrays test1 = new _Arrays();
        int[] array =  {7,1,5,3,6,4};
        int[] array2 =  {7,6,4,8,2};
        test1.maximumProfit(array);
        test1.maximumProfit(array2);
    }
}
