public class WallJumpTest {
  
  public static int calculateStep(int wallSize, int jumpSize, int slipSize) {
    int noOfSteps = 1;
    while(wallSize >= jumpSize) {
      if(wallSize > jumpSize) {
        wallSize -= (jumpSize - slipSize);
        noOfSteps++;
      } else {
        wallSize -= jumpSize;
      }
    }
    return noOfSteps;
  }
  
  public static void main(String[] args) {
    System.out.println(calculateStep(12, 4, 1));
    System.out.println(calculateStep(12, 3, 0));
  }
}
