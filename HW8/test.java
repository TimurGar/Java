public class test {
    public static void main(String[] args) {
        int[] array = {9,1,6,9,1,4};
        int temp = 0;
    

        if(array[0] < array[1]){
            temp = array[0];
            array[0] = array[1];
            array[1] = temp;
        }
        if(array[1] < array[2]){
            temp = array[1];
            array[1] = array[2];
            array[2] = temp;
        }
        if(array[0] < array[1]){
            temp = array[0];
            array[0] = array[1];
            array[1] = temp;
        }

        for(int item : array){
            System.out.print(item + " ");
        }
    }
}

