import java.util.ArrayList;
import java.util.Arrays;

class Solution {

  int M = (int) 1e9 + 7;
  public int countOrders(int n) {
    return (int) (f(n) % M);
  }

  private long f(int n) {
    if (n == 1) return 1;
    long next = f(n-1);
    return ((((n % M) * ((2*n -1) % M)) % M) * (next % M)) % M;
  }
}
