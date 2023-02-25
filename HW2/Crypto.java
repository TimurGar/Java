/**
* A Crypto class that encrypts and decrypts data
*/
public interface Crypto{
    /**
    * encrypts data
    * @param data is the data (lowercase letters of the english
    alphabet) to be encrypted
    * @return the encrypted data
    */
    public String encrypt(String data);
    
    /**
    * decrypts data
    * @param data is the data (lowercase letters of the english
    alphabet) to be decrypted
    * @return the decrypted data
    */
    public String decrypt(String data);
}
    
