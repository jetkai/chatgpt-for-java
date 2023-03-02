import org.gpt.ChatGPT;
import org.gpt.api.data.image.ImageData;
import org.gpt.util.ApiKeyFileData;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.gpt.util.ReadApiKeyFromFile.getApiKeyFromFile;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateImageAwtTest {

    @Test
    void createImageAwtTest() {
        ApiKeyFileData keyData = getApiKeyFromFile();

        assertNotNull(keyData);

        ChatGPT gpt = new ChatGPT(keyData.getApiKey(), keyData.getOrganization());

        //Completion Data, ready to send to the ChatGPT Api
        ImageData image = new ImageData();
        image.setPrompt("A cute baby sea otter");
        image.setN(2);
        image.setSize("1024x1024");

        Image[] images = gpt.createImage(image);
        assertNotNull(images);
        assertNotEquals(0, images.length);
    }

}