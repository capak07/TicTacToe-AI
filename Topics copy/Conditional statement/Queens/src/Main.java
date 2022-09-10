import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(x1);
        arrayList.add(x2);
        if (x1 == x2){
            System.out.println("YES");
        }
        else if (y1 == y2){
            System.out.println("YES");
        }
        else if (forwardUpwardDiagonal(x1,y1,x2,y2) || forwardDownwardDiagonal(x1,y1,x2,y2) || backWardUpwardDiagonal(x1,y1,x2,y2) || backWardDownwardDiagonal(x1,y1,x2,y2)){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
    public static boolean forwardUpwardDiagonal(int x,int y,int x2,int y2){
        boolean value = false;
        while (x<=8 && y<=8){
            if (x == x2 && y == y2){
                value = true;
                break;
            }
            else {
                x++;
                y++;
            }
        }
        return value;
    }
    public static boolean forwardDownwardDiagonal(int x,int y,int x2,int y2){
        boolean value = false;
        while (x<=8 && y>=1){
            if (x==x2 && y==y2){
                value = true;
                break;
            }
            else {
                x++;
                y--;
            }
        }
        return value;
    }
    public static boolean backWardUpwardDiagonal(int x,int y,int x2,int y2){
        boolean value = false;
        while (x>=1 && y>=1){
            if (x==x2 && y==y2){
                value=true;
                break;
            }
            else {
                x--;
                y++;
            }
        }
        return value;
    }
    public static boolean backWardDownwardDiagonal(int x,int y,int x2,int y2){
        boolean value = false;
        while (x>=1 && y>=1){
            if (x==x2 && y==y2){
                value = true;
                break;
            }
            else {
                x--;
                y--;
            }
        }
        return value;
    }
}