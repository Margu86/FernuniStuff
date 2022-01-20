package sortingalgs;

/**
 *
 * @author Benjamin Zeussel (https://github.com/Margu86/)
 */
public class SortingAlgs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] folge = {6,35,12,22,2,13,9,28,17};
        int[] inkrement = {5,3,1};
        Shellsort shell = new Shellsort();
        shell.shellsort(inkrement, folge);
    }
    
}
