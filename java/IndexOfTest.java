public class IndexOfTest{
    public static void main(String[] args){
        /*This is a test of the string method indexOf*/
        String string = "University";
        char character = 'n';
        String scan = "sity";
        System.out.println("The string is "+string);
        System.out.println(character+" is at index: "+string.indexOf(character));
        System.out.println(scan+" is at index: "+string.indexOf(scan));
    }
}
