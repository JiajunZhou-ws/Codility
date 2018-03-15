class Solution {
    public int primenum = 0;
    public void getPrimes(int[] num,int l)
    {
        
        for(int i = 1 ; i < l;i++)
        {
            if(l % i == 0)
            {
                num[primenum++] = i;           
            }
        }
    }
    public int solution(int[] A) {
        // write your code in Java SE 8
        int n = A.length;
        int[] peaks = new int[n];
        int[] next = new int[n];
        int[] primes = new int[n];
        int ans  = 0;
        if(n == 0 || n == 1)
            return 0;
        getPrimes(primes,n);
       
        for(int i = 0 ; i < n; i++)
        {
            if(i == 0 && i + 1 < n)
            {
                if(A[i] > A[i+1])
                    peaks[i] = 1;
                continue;
            }
            if(i == n - 1 && i - 1 >= 0)
            {
                if(A[i] > A[i-1])
                    peaks[i] = 1;
                continue;
            }
            if(A[i] > A[i-1] && A[i] > A[i+1])
                peaks[i] = 1;
        }
        next[n - 1] = Integer.MAX_VALUE;
        for(int i = n - 2; i >= 0; i--)
        {
            if(peaks[i] == 1)
                next[i] = i;
            else
                next[i] = next[i + 1];
        }
        for(int i = 0;i < primenum; i++)
        {
            //System.out.println(primes[i]);
            int k = n / primes[i];
            int flag = 0;
            int pos = 0;
            while(pos < n)
            {   
                if(next[pos] <= pos + k - 1)
                    pos += k;
                else
                {
                    flag = 1;
                    break;
                }
            }
            if(flag == 0)
                ans = Math.max(ans,primes[i]);
        }
        return ans;
    }
}