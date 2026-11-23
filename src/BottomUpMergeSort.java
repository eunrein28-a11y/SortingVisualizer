public class BottomUpMergeSort implements SortAlgorithm{
    public String getName() { return "Bottom Up Merge Sort"; }
    public void sort(SortArray arr){
        for(int size = 1; size < arr.size(); size *= 2){
            for(int lo = 0; lo < arr.size(); lo += 2*size){
                int mid = lo + size - 1;
                int hi = Math.min(lo + 2 * size - 1, arr.size() - 1);
                merge(arr, new Item[arr.size()], lo, mid, hi);
            }
        }
    }
    private void merge(SortArray arr, Item[] aux, int lo, int mid, int hi){
        int i = lo;
        int j = mid + 1;
        int k = lo;
        for(int l = lo; l <= hi; l++){
            aux[l] = arr.get(l);
        }
        while(i <= mid && j <= hi){
            if(arr.less(aux[i], aux[j])){
                arr.set(k, aux[i]);
                i++;
            }
            else{
                arr.set(k, aux[j]);
                j++;
            }
            k++;
        }
        while(i <= mid && k < arr.size()){
            arr.set(k, aux[i]);
            i++;
            k++;
        }
        while(j <= hi){
            arr.set(k, aux[j]);
            j++;
            k++;
        }
        arr.mark("merge " + lo + " - " + hi);
    }
}
