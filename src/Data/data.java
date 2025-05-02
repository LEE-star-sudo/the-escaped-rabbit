package Data;

import Interface.gather;
import Display.display;

public class data
{
    private gather[][] allItems;
    private display display;

    public data(){
        allItems = new gather[50][50];
        display = new display();
    }

    public void storage(int x,int y,gather item){
        allItems[x][y] = item;
        display.setArray(x,y,item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                if (allItems[x][y] != null) {
                    sb.append("[").append(x).append(", ").append(y).append("]: ");
                    sb.append(allItems[x][y].toString()).append("\n");
                }
            }
        }
        return sb.toString();
    }

}
