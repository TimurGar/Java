/**
 * A class to create a 1st substitution algorithm which 
 * encrypts and decrypts data
 * Class implements the Crypto interface
 * @author Timur Garifullin
 */
public class Cipher1 implements Crypto{
    // letters that are going to be substituded to "new letter#" if found
    char substituteLetter1 = 'a'; // m
    char substituteLetter2 = 'w'; // g
    char substituteLetter3 = 'd'; // p
    char substituteLetter4 = 'u'; // w
    char substituteLetter5 = 'o'; // t

    // letters that "substitureLetter#" going to be changed to
    char newletter1 = 'm';
    char newletter2 = 'q';
    char newletter3 = 'p';
    char newletter4 = 'e';
    char newletter5 = 'u';

    /**
     * Method to encrypt 
     * Uses a set of if, else to find subtitute characters, if any
     * @param data is the message provided by the user that needs to be encrypted
     * @return encrypted message 
     */
    public String encrypt(String data){
        String encryptedMessage = "";

        /*  Go through each characted in the data entered to see if 
        there are any subtitute characters (assigned above)  */
        for(int i = 0; i < data.length(); i++){
            
            if(data.charAt(i) == substituteLetter1){
                encryptedMessage += newletter1;
            }
            else if(data.charAt(i) == substituteLetter2){
                encryptedMessage += newletter2;
            }
            else if(data.charAt(i) == substituteLetter3){
                encryptedMessage += newletter3;
            }
            else if(data.charAt(i) == substituteLetter4){
                encryptedMessage += newletter4;
            }
            else if(data.charAt(i) == substituteLetter5){
                encryptedMessage += newletter5;
            }
            else{
                encryptedMessage += data.charAt(i);
            }
        }
        return encryptedMessage;
    }

     /**
     * Method to decrypt 
     * @param data is the message provided by the user that needs to be decrypted
     * @return decrypted message 
     */
    public String decrypt(String data) {
        String decryptedMessage = "";

        // Perfoms the same steps as encrypt method but in reverse
        for(int i = 0; i < data.length(); i++){
            if(data.charAt(i) == newletter1){
                decryptedMessage += substituteLetter1;
            }
            else if(data.charAt(i) == newletter2){
                decryptedMessage += substituteLetter2;
            }
            else if(data.charAt(i) == newletter3){
                decryptedMessage += substituteLetter3;
            }
            else if(data.charAt(i) == newletter4){
                decryptedMessage += substituteLetter4;
            }
            else if(data.charAt(i) == newletter5){
                decryptedMessage += substituteLetter5;
            }
            else{
                decryptedMessage += data.charAt(i);
            }
        }
        return decryptedMessage;
    }
}
