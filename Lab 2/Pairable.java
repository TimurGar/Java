public interface Pairable<T> {
    /**
     * A getter for the first item in the pair 
     * @return the first item in the pair
     */
    public T getFirst();

    /**
     * A getter for the second item in the pair 
     * @return the second item in the pair
     */
    public T getSecond();

    /**
     * Swaps the first and the second item
     */
    public void changeOrder();

}
