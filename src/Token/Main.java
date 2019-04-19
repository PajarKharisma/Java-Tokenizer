package Token;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        PustakaFrasa pf = new PustakaFrasa();
        StringTokenizer firstSplit = new StringTokenizer("Buyung suka minum racun tikus -");
        int limit = firstSplit.countTokens();
        String[] listToken = new String[limit];
        int j = 0;
        
        while(firstSplit.hasMoreElements()){
            listToken[j] = firstSplit.nextToken();
            j++;
        }
        
        String temporaryToken = "";
        int x = 0;
        while(x<limit-1){
            String compareToken = listToken[x] + " " +listToken[x+1];
            pf.compareAction(compareToken);
            if(pf.indicator()){
                temporaryToken += compareToken + "|";
                x+=2;
            }  
            else{
                temporaryToken += listToken[x] + "|";
                x++;
            }
        }
        
        StringTokenizer secondSplit = new StringTokenizer(temporaryToken,"|");
        while(secondSplit.hasMoreElements()){
            System.out.println(secondSplit.nextToken());
        }
    }
}
