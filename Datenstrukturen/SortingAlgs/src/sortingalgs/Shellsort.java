package sortingalgs;

/**
 *
 * @author Benjamin Zeussel (https://github.com/Margu86/)
 */
public class Shellsort {
    private int[] folge;
    public int[] shellsort(int[] inkrement, int[] f){
        folge = f;
        for(int i = 0; i < inkrement.length; i++){
            for(int j = inkrement[i];j<folge.length;j++){
                int x = j - inkrement[i];
                while(x >= 0){
                    if(folge[x+inkrement[i]]<folge[x]){
                        folge = swap(folge,x,x+inkrement[i]);
                        x=x-inkrement[i];
                    }else{
                        x = -1;
                    }
                }
            }
            System.out.println(inkrement[i]+"-sortierte Folge: ");
            printFolge(folge);
        }
        return folge;
    }
    private int[] swap(int[] folge, int a, int b){
        int zwischenspeicher;
        zwischenspeicher = folge[a];
        folge[a] = folge[b];
        folge[b] = zwischenspeicher;
        return folge;
    }
    private void printFolge(int[] f){
        for(int i = 0; i < f.length; i++){
            if(i != 0){
                System.out.print(", ");
            }
            System.out.print(f[i]);
            if(i+1 == f.length){
                System.out.println("");
            }
        }
    }
}
