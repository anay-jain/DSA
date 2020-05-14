public class client{
    public static void main(String[] args){
        hashmapImplementation map = new hashmapImplementation();
        map.put(12,3);
        map.put(133,33);
        map.put(514,43);
        map.put(14,3);
        map.put(19,3);
        map.put(155,3);
        map.put(13,93);
        map.put(1,30);
        System.out.println(map);
        // as we have called out the object toh map ka toString call hoga jo hmne overide kar rkhe hai
        // nahi karte to sirf address dikhata
    }
}
