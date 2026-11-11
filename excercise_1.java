public class excercise_1 {

    public static char[] consonants = {'b' , 'c', 'd', 'f', 'g','h','j','k','l', 'm', 'n', 'p','q','r','s','t', 'v','w', 'x', 'y', 'z'};

    public static void main(String[] args) {
        System.out.println(printing("okinawa"));
        System.out.println(findUpper("helLo"));
        System.out.println(countConst("hello guys its me"));
        System.out.println(binary(13));
    }

    //Functions -----------------------------------------------------------------------------------

    //excercise 1 -------------------------------------
    public static String toBinary(int input){
        int div = input /2;
        int mod = input % 2;
        if(input <= 1){
            if(input == 1){
                return "1";
            }
            else{
                return "0";
            }
        }
        else{
            if(input % 2 == 0){
                 return toBinary(div) + "0";
            }
            else{
                return toBinary(div) + "1";
            }
        }
    }

    public static String binary(int input){
        int divide = input /2;
        int modulo = input % 2;
        String mod = String.valueOf(modulo);
        if(input <= 2){
            return mod;
        }
        else{
            return binary(divide) + mod;
        }
    }

    //exercise 2 ----------------------------------------------------------
    public static String photocopy(String input, int index, String remaining){
        char indexAlphabet = input.charAt(index);
        remaining = input.substring(index);
        
        /* 
        if(input == " " || input.equals("") || input.substring(index) == input.charAt(input.length() - 1)){
            return " ";
        }
        else{
            return indexAlphabet + photocopy(input.substring(index), index + 1);
        }
            */
            

        if(index == input.length() - 1 ){
            return indexAlphabet + "";
        }
        else{
            return indexAlphabet + photocopy(input, index + 1, remaining);
        }
    }

    public static String printing(String input){
        return photocopy(input, 0, "");
    }


    /* why this does not work 
    public static String toaster(String input, int index){
        char indexAlphabet = input.charAt(index);
        String remaining = input.substring(index);

        if(remaining == " " || index == input.length() - 1 ){
            return indexAlphabet + "";
        }
        else{
            return indexAlphabet + toaster(input, index + 1);
        }
    }
        */


    //excercise 3 --------------------------------------------
    public static char shouting(String input, int index){
        Character current = input.charAt(index);
        if(Character.isUpperCase(current) == true){
            return input.charAt(index);
        }
        else if(index == input.length() - 1){
            return ' ';
        }
        else{
            return shouting(input, index + 1);
        }
    }

    public static char findUpper(String input){
        return shouting(input, 0);
    }

    public static char upper(String input){
        Character current = input.charAt(0);
        if(Character.isUpperCase(current) == true){
            return input.charAt(0);
        }
        else{
            return upper(input.substring(1));
        }
    }

    //excercise 4 -----------------------------------------
    public static int consonant(String input, int index){
        
        if(input.length() -1 == index){
            return 0;
        }
        
        char current = Character.toLowerCase(input.charAt(index));
        String alpha = "bcdfghjklmnpqrstvwxyz";

        if(alpha.contains(String.valueOf(current))){
            return consonant(input, index + 1) + 1;
        }
        else{
            return consonant(input, index + 1);
        }
    
    }

    
    public static int countConst(String input){
        char current = input.charAt(0);
        String alpha = "bcdfghjklmnpqrstvwxyz";


        if(input.length() == 1){
            if(alpha.contains(String.valueOf(current))){
                return 1;
            }
            else{
                return 0;
            }
        }
        else{
            if(alpha.contains(String.valueOf(current))){
                return countConst(input.substring(1)) + 1;
            }
            else{
                return countConst(input.substring(1));
            }
        }
    }

    
}
