import com.google.crypto.tink.config.TinkConfig;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadKeyTemplates;

public class SingletonEncryption {
	
	private static SingletonEncryption single_instance = null;
	private static byte[] aad = null;
	private KeysetHandle keysetHandle = null;
	private Aead aead = null;
	
	private SingletonEncryption(){
		try {
			TinkConfig.register();
			aad = "random string".getBytes();
			keysetHandle = KeysetHandle.generateNew(AeadKeyTemplates.AES128_GCM);
			aead = keysetHandle.getPrimitive(Aead.class);
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SingletonEncryption getInstance(){
		if (single_instance == null){
			single_instance = new SingletonEncryption();
		}
		
		return single_instance;
	}
	
	public String encryptString(String unencryptedString){
		
		if(!(unencryptedString instanceof String)){
			System.out.println("Why would you do this?");
			return unencryptedString;
		}
		
		try {
			return aead.encrypt(unencryptedString.getBytes(),aad).toString();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public String decryptString(String encryptedString){
		
		if(!(encryptedString instanceof String)){
			System.out.println("Not a string, returning original passed in object");
			return encryptedString;
		}
		
		try {
			return aead.decrypt(encryptedString.getBytes(), aad).toString();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return encryptedString;
		}
	}
	    
	    

}
