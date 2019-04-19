package Token;

public class PustakaFrasa {
    private String pustaka[] = {"rumah sakit", "sakit kepala", "banting tulang", "tangan kanan", "belahan jiwa", "kupu-kupu malam", "racun tikus"};
    private boolean ind;
    
    public void compareAction(String compareObject){
        for(int i=0; i<pustaka.length; i++){
            if(compareObject.equals(pustaka[i])){
                ind = true;
                break;
            }  
            else
                ind = false;
        }
    }
    
    public boolean indicator(){
        return ind;
    }
}
