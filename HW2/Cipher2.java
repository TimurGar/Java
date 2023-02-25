/**
 * A class to create a 2nd substitution algorithm which 
 * encrypts and decrypts data
 * Class implements the Crypto interface
 * @author Timur Garifullin
 */
public class Cipher2 implements Crypto{
    // letters that are going to be substituded to "new letter#" if found
    char [] substituteLetters = {'a', 'w', 'd', 'u', 'o'};

    // letters that "substitureLetter#" going to be changed to
    char [] newLetters = {'m', 'q', 'p', 'e', 'u'};

    /**
     * Method to encrypt 
     * Uses 2 for loops to find subtitute characters, if any
     * @param data is the message provided by the user that needs to be encrypted
     * @return encrypted message 
     */
    public String encrypt(String data){
        String encryptedMessage = "";

        /*  changes the status to true if the substitute variable if found
        therefore, no need to place orignal character in substitute variable's place */
        boolean flag = false;

        /*  Go through each characted in the data entered to see if 
        there are any subtitute characters (assigned above)  */
        for(int i = 0; i < data.length(); i++){
            for(int y = 0; y < substituteLetters.length; y++){
                if(data.charAt(i) == substituteLetters[y]){
                    encryptedMessage += newLetters[y];
                    flag = true;
                    break;
                }
            }

            if(flag == false){
                encryptedMessage += data.charAt(i);
            }
            // resetting the flag to false after each loop iteration
            flag = false;
        }    
        return encryptedMessage;
    }
    /**
     * Method to decrypt 
     * @param data is the message provided by the user that needs to be decrypted
     * @return decrypted message 
     */
    public String decrypt(String data){
        String decryptedMessage = "";
        boolean flag = false;

        // Perfoms the same steps as encrypt method but in reverse
        for(int i = 0; i < data.length(); i++){
            for(int y = 0; y < newLetters.length; y++){
                if(data.charAt(i) == newLetters[y]){
                    decryptedMessage += substituteLetters[y];
                    flag = true;
                    break;
                }
            }

            if(flag == false){
                decryptedMessage += data.charAt(i);
            }
            flag = false;
        }    
        return decryptedMessage;
    }
}
