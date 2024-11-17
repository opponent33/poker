import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public  class Main{
    public static void main(String[] args){
        Deck d = new Deck();
        
        int x = 3;

        Card[] t = d.takeCards(x);

        for (int y = 0; y < x; y++) {
            System.out.println(t[y].num + t[y].suit);
        }
    }
}