class TimeMap {
    HashMap<String, List<Pair<Integer,String>>> map;

    public TimeMap() {
        map = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key,new ArrayList<>());
        map.get(key).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";

        List<Pair<Integer,String>> list = map.get(key);
         int low = 0;
        int high = list.size()-1;

        String res = "";

        while(low <= high){

            int mid = low + (high-low)/2;

            if(list.get(mid).getKey() <= timestamp){
                res = list.get(mid).getValue();
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return res;
    }
}
