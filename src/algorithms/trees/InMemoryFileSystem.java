package algorithms.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class InMemoryFileSystem {

    class Dir {

        HashMap<String, Dir> directory = null;
        HashMap<String,String> files = null;

        public Dir(){
            directory = new HashMap<>();
            files = new HashMap<>();
        }
    }

    Dir root = null;

    public InMemoryFileSystem() {
        root = new Dir();
    }

    public List<String> ls(String path) {
        String[] directories = path.split("/");
        Dir tempRoot = root;
        int i=0;
        boolean directory =true;
        for(;i<directories.length;i++){
            if(directories[i].length()==0)
                continue;

            if(!tempRoot.directory.containsKey(directories[i])){
                directory=false;
                break;
            }
            tempRoot = tempRoot.directory.get(directories[i]);
        }

        List<String> listDir = new ArrayList<>();
        if(directory){
            listDir.addAll(tempRoot.directory.keySet());
            listDir.addAll(tempRoot.files.keySet());
        }else{
            listDir.add(directories[i]);
        }

        Collections.sort(listDir);

        return listDir;
    }

    public void mkdir(String path) {

        String[] directories = path.split("/");
        Dir tempRoot = root;
        for(int i=0;i<directories.length;i++){
            if(directories[i].length()==0)
                continue;
            if(!tempRoot.directory.containsKey(directories[i])){
                tempRoot.directory.put(directories[i], new Dir());
            }
            tempRoot = tempRoot.directory.get(directories[i]);
        }

    }

    public void addContentToFile(String filePath, String content) {
        String[] directories = filePath.split("/");

        if(directories.length ==0)
            return;

        Dir tempRoot = root;
        int i=0;
        for(;i<directories.length-1;i++){

            if(directories[i].length()==0)
                continue;

            if(!tempRoot.directory.containsKey(directories[i])){
                tempRoot.directory.put(directories[i], new Dir());
            }
            tempRoot = tempRoot.directory.get(directories[i]);
        }

        if(tempRoot.files.containsKey(directories[i])){
            tempRoot.files.put(directories[i],tempRoot.files.get(directories[i]).concat(content));
        }else{
            tempRoot.files.put(directories[i],content);
        }
    }

    public String readContentFromFile(String filePath) {

        String[] directories = filePath.split("/");

        if(directories.length ==0)
            return "";

        Dir tempRoot = root;
        int i=0;
        for(;i<directories.length-1;i++){
            if(directories[i].length()==0)
                continue;
            if(!tempRoot.directory.containsKey(directories[i])){
                tempRoot.directory.put(directories[i], new Dir());
            }
            tempRoot = tempRoot.directory.get(directories[i]);
        }

        return tempRoot.files.get(directories[i]);
    }

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 *
 * ["FileSystem","mkdir","ls","ls","mkdir","ls","ls","addContentToFile","ls","ls","ls"]
 * [[],["/goowmfn"],["/goowmfn"],["/"],["/z"],["/"],["/"],["/goowmfn/c","shetopcy"],["/z"],["/goowmfn/c"],["/goowmfn"]]
 *
 */

    public static void main(String[] args) {
        InMemoryFileSystem obj = new InMemoryFileSystem();
            obj.mkdir("/goowmfn");
            obj.mkdir("/z");
            obj.addContentToFile("/goowmfn/c","shetopcy");
            System.out.print(obj.ls("/z"));
            System.out.print(obj.ls("/goowmfn/c"));
        System.out.println(obj.readContentFromFile("/goowmfn/c"));
    }
}
