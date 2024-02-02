/**
 * Definition for an infinite stream.
 * class InfiniteStream {
 *     public InfiniteStream(int[] bits);
 *     public int next();
 * }
 */

class InfinitePatternStreamFinder {
    public int findPattern(InfiniteStream infiniteStream, int[] pattern) {
        
        List<int[]> currentList = new ArrayList<int[]>();
        int index=0;
        while(true){
            if(currentList.size()>0 && currentList.get(0)[1]== pattern.length){
                break;
            }

            int val = infiniteStream.next();
            List<int[]> tempList = new ArrayList<int[]>();
            for(int[] ele: currentList){
                if(ele[1]< pattern.length && pattern[ele[1]] == val){
                    tempList.add(new int[]{ele[0], ele[1]+1});
                }
            }

            if(val == pattern[0]){
                tempList.add(new int[]{index, 1});
            }
            currentList =tempList;
            index++;
        }
        return currentList.get(0)[0];
    }
}
