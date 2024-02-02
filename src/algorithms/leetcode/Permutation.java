/**
LC-60

Interesting math problem

defined base case, reduced the size of the problem 1 in each iteration.

case 1: if k>=(n-1)!  & k%(n-1)==0 , then we can elminate all the nodes where k doesn't fall under, hence reducing the value of k = k- (del_nodes)*fact[n-1]
case 2: if k>=(n-1)! & k%(n-1)!=0, then we can eleminate all the nodes, reduce k = k- (del_nodes-1)*fact[n-1]
case 3 if k<(n-1)! then remove index 0, because k is definately in the same node. And we don't reduce the size of k because k is currently less than fact[n-1]
*/
class Permutation {
    public String getPermutation(int n, int k) {

        List<Integer> data_set = new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
            data_set.add(i);
        }

        int[] fact = {1,1,2,6,24,120,720,5040,40320,362880};
        return getPermutation(data_set, fact, k, n);
    }

    public String getPermutation(List<Integer> data_set,int[] fact, int k, int n){
        if(data_set.size() ==1 || n==1){
            return String.valueOf(data_set.get(0));
        }

        if(k>=fact[n-1] && k%fact[n-1]!=0){
            int del_node = k/fact[n-1];
            return String.valueOf(data_set.remove(del_node)) + getPermutation(data_set, fact, k-(del_node*fact[n-1]), n-1);
        }else if(k>=fact[n-1] && k%fact[n-1]==0){
            int del_node = k/fact[n-1];
            return String.valueOf(data_set.remove(del_node-1)) + getPermutation(data_set, fact, k-((del_node-1)*fact[n-1]), n-1);
        }
        return String.valueOf(data_set.remove(0))+getPermutation(data_set, fact, k, n-1);
    }
}
