import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BitcoinAddressValidator {

    // Base58 alphabet used in Bitcoin addresses
    private static final String BASE58_ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";

    public static void main(String[] args) {
        String address = "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa";
        
        if (isValidBitcoinAddress(address)) {
            System.out.println("The Bitcoin address is valid.");
        } else {
            System.out.println("The Bitcoin address is invalid.");
        }
    }

    public static boolean isValidBitcoinAddress(String address) {
        // Check if the length is 34 characters
        if (address.length() != 34) {
            return false;
        }

        // Check if the address starts with '1' or '3'
        if (!address.startsWith("1") && !address.startsWith("3")) {
            return false;
        }

        // Check if the address is Base58 encoded
        if (!isBase58(address)) {
            return false;
        }

        return true;
    }

    // Check if the address is Base58 encoded
    public static boolean isBase58(String address) {
        for (char c : address.toCharArray()) {
            if (BASE58_ALPHABET.indexOf(c) == -1) {
                return false;  // Character is not in the Base58 alphabet
            }
        }
        return true;
    }
}
