package algorithms.strings;

public class ValidIPAddress {

    public static String validIPAddress(String IP) {

        if(IP.startsWith(".") || IP.endsWith(".") || IP.endsWith(":") || IP.startsWith(":"))
            return "Neither";
        String[] ipv4Data = IP.split("\\.");
        String[] ipv6Data = IP.split(":");

        if(!(ipv4Data.length == 4 || ipv6Data.length == 8))
            return "Neither";


        if(ipv4Data.length == 4){
            return validIPV4(ipv4Data) ?"IPv4":"Neither";
        }

        return validIPV6(ipv6Data) ?"IPv6":"Neither";
    }

    public static boolean validIPV4(String[] data){

        for(String point:data){
            if(point.length()>3 || point.length() ==0){
                return false;
            } else if(point.length() >1 && point.startsWith("0")){
                return false;
            }else{
                try{
                    Integer value = Integer.valueOf(point);
                    if(value<0 || value>255)
                        return false;
                }catch(NumberFormatException e){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean validIPV6(String[] data){

        for(String point:data){
            if(point.length()>4 || point.length() ==0){
                return false;
            }

            for(int i=0;i<point.length();i++){
                char ch = point.charAt(i);

                if(!((ch>='a' && ch<='f') || (ch>='A' && ch<='F')|| (ch>='0' && ch<='9'))){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(validIPAddress("2001:0db8:85a3:0::8A2E:0370:7334"));
    }
}
