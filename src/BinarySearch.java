public class BinarySearch {

    private boolean valueExists(int[] values, int l, int r, int value){
        if (r >= l) {
            int index = l + (r-1) / 2;
            if (values[index] == value) {
                return true;
            } else if (values[index] > value) {
                return valueExists(values, l, index - 1, value);
            } else {
                return valueExists(values, index + 1, r, value);
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        int[] values = new int[]{1,2,3,4,};
        System.out.println("Value exists? " +  search.valueExists(values, 0, values.length - 1, 10));
    }
}
