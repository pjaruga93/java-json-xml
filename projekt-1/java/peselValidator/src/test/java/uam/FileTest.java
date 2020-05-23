package uam;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.mockito.internal.util.reflection.FieldSetter;

public class FileTest {

    private final FileUtil fileUtil = new FileUtil("fileName");

    @Test
    public void testFileLinesContainsPesel() throws NoSuchFieldException {
        var fileContent = new ArrayList<>();
        fileContent.add("Poznan,Jan,Nowak,82061784459");
        fileContent.add("Poznan,Andrzej,Kowalski,64010989269");
        fileContent.add("Poznan,Robert,Smith,54101456493");
        fileContent.add("Poznan,Szymon,Wolak,03280691524");
        FieldSetter.setField(fileUtil, fileUtil.getClass().getDeclaredField("fileContent"), fileContent);

        var pesel = fileUtil.containsPesel("03280691524");

        assertTrue(pesel.isPresent());
        assertEquals(3, (int) pesel.get());
    }

    @Test
    public void testFileNotContainsPesel() throws NoSuchFieldException {
        var fileContent = new ArrayList<>();
        fileContent.add("Poznan,Jan,Nowak,82061784459");
        fileContent.add("Poznan,Andrzej,Kowalski,64010989269");
        fileContent.add("Poznan,Robert,Smith,54101456493");
        fileContent.add("Poznan,Szymon,Wolak,03280691524");
        FieldSetter.setField(fileUtil, fileUtil.getClass().getDeclaredField("fileContent"), fileContent);

        var pesel = fileUtil.containsPesel("03280691523");

        assertTrue(pesel.isEmpty());
    }
}
