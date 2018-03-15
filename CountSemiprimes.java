// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.*;
class Solution {
    public int[] getprimes(int N)
    {
        int[] primes = new int[N + 1];
        for(int i = 2; i * i <= N; i++)
        {
            if(primes[i] == 0)
                for(int k = i * i; k<=N; k+=i)
                {
                    if(primes[k] == 0)
                        primes[k] = i;
                }
        }
        return primes;
    }
    public int[] getsimiprimes(int[] primes)
    {
        int[] semiprimes = new int[primes.length];
       // System.out.println(Arrays.toString(primes) + "\n");
        for(int i = 0; i < primes.length; i++)
        {
            if(primes[i] != 0 && primes[i/primes[i]] == 0)
                semiprimes[i] = 1;
        }
        return semiprimes;
    }
    public int[] solution(int N, int[] P, int[] Q) {
        // write your code in Java SE 8
        int[] primes = getprimes(N);
        int[] semiprimes = getsimiprimes(primes);
      //  System.out.println(Arrays.toString(semiprimes) + "\n");
        int[] presum = new int[N + 1];
        int[] ans = new int[P.length];
        for(int i = 0; i <= N; i++)
        {
            if(i == 0)
                presum[i] = 0;
            else
                presum[i] = presum[i - 1] + semiprimes[i];
        }
        //System.out.println(Arrays.toString(presum));
        for(int i = 0; i < P.length; i++)
        {   
            ans[i] = presum[Q[i]] - presum[P[i] - 1];
        }
        return ans;
        
    }
}