public class OrderedPair<T> implements Pairable<T> {
    
    private T first;
    private T second;

    public OrderedPair(){
        first = null;
        second = null;
    }
    public OrderedPair(T first, T second){
        this.first = first;
        this.second = second;
    }

    /**
     * A getter for the first item in the pair 
     * @return the first item in the pair
     */
    public T getFirst(){
        return first;
    }

    /**
     * A getter for the second item in the pair 
     * @return the second item in the pair
     */
    public T getSecond(){
        return second;
    }

    /**
     * Swaps the first and the second item
     */
    public void changeOrder(){

    }
    public String toString(){
        return "(" + first + ", " + second + ")";
    }

    public static void main(String[] args) {
        Pairable<String> strPair = new OrderedPair<>("Timur", "Garifullin");
        System.out.println(strPair.toString());

        Pairable<Integer> intPair = new OrderedPair<>(1, 2);
        System.out.println(intPair.toString());

    }
}
