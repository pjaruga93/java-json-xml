package uam;

public class PeselValidatorClass {

    public static boolean isValidPesel(String pesel) {
        if (pesel == null || pesel.length() != 11) {
            return false;
        }
        if (pesel.chars().noneMatch(Character::isDigit)) {
            return false;
        }
        var peselInts = pesel.chars().map(Character::getNumericValue).toArray();
        var sum = 9 * peselInts[0] + 7 * peselInts[1] + 3 * peselInts[2] + peselInts[3] + 9 * peselInts[4]
            + 7 * peselInts[5] + 3 * peselInts[6] + peselInts[7] + 9 * peselInts[8] + 7 * peselInts[9];
        return sum % 10 == peselInts[10];
    }
}
