public class oops{
    public static void swap(person p1 , person p2){
        person temp = p1;
        p1=p2;
        p2=temp;
    }
    public static void main(String[] args){
    person p1 = new person();
    person p2 = new person();
    p1.age = 2;
    p2.age =3;
    swap(p1, p2);
        System.out.println(p1.age);


}    
}