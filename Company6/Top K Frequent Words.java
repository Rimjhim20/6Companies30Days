class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hashMap=new HashMap<>();
        for (String word:words) {
            hashMap.put(word,hashMap.getOrDefault(word,0)+1);
        }
        //each key represents the strings, and each value a frequency
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int freqO1 = hashMap.get(o1);
                int fregO2 = hashMap.get(o2);

                if (freqO1 != fregO2) { //compare strings based on their frequency
                    return fregO2 - freqO1;
                }
                if (freqO1 == fregO2) { //if frequency is the same -> compare strings on their natural order
                    return o1.compareTo(o2);
                }
                return -1;
            }
        };
        return hashMap.keySet().stream().sorted(comparator).limit(k).collect(Collectors.toList());
    }
}