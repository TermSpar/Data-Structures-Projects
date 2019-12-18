// Ben Bollinger, Task1.java, 9/12/2019 

/* DESCRIPTION:
 * This class first creates an array of 100 boolean values called lockerArray. Then I loop through the array and "open" every locker
 * (which just turns them from false to true), then, starting with the second locker, I loop through and close (set to false) every 
 * other locker, then, starting with the third locker, I loop through and change (if it's open, close it, if it's closed, open it)
 * every Nth locker. So if it's starting with the 4th locker, it will change every 4th locker, and so on until the loop is complete.
 * Then I simply display the end result. */

package p01;
public class Task1 {

	// lockers auto initialized to closed:
    static boolean[] lockerArray = new boolean[100];

    public static void main(String[] args) {
        // first iteration opens every locker:
        for(int i = 0; i < 100; i++){
            lockerArray[i] = true;
        }
        // second iteration closes every other locker, starting with 2:
        for(int i = 1; i < 100; i += 2){
            lockerArray[i] = false;
        }
        // starting with 3, change every Nth locker:
        // student loop:
        for(int i = 2; i < 100; i++){
            // locker loop:
            for(int j = i; j < 100; j += (i + 1)){
                // check if locker is open or closed:
                if(lockerArray[j]){
                    lockerArray[j] = false;
                }
                else{
                    lockerArray[j] = true;
                }
            }
        }

        // display results:
        for(int i = 0; i < 100; i++) {
            if(lockerArray[i]) {
                System.out.println("Locker #" + (i + 1) + " is open");
            }
        }
    }

}
