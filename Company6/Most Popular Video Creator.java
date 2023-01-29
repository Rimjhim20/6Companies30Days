class Solution {
    public List<List<String>> mostPopularCreator(String[] c, String[] ids, int[] v) { 
        long max=-1; Map<String,Integer> m = new HashMap(); int n=c.length; 
        long x [] = new long [n]; int y [] = new int [n];  
        String f [] = new String[n]; 
        for (int i=0,j=0; i<n; i++){ 
             Integer a = m.get(c[i]); 
             if(a==null){ a=j; j++;} x[a]+=v[i];  
             if(f[a]==null||y[a]<v[i]) f[a] = ids[i]; 
             else if(y[a]==v[i])f[a]=f[a].compareTo(ids[i])<0?f[a]:ids[i]; 
             y[a]=Math.max(y[a],v[i]); max=Math.max(max,x[a]); 
             m.put(c[i],a); 
        } 
        List<List<String>> l = new ArrayList(); 
        for (String r : m.keySet()){ 
            int index = m.get(r); 
             if(x[index]==max)
        l.add(Arrays.asList(new String[]{r, f[index]}));
        }
        return l ;

    }
}