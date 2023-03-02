import org.gpt.ChatGPT;
import org.gpt.api.data.image.ImageData;
import org.gpt.api.data.image.ImageResponseData;
import org.gpt.util.ApiKeyFileData;
import org.junit.jupiter.api.Test;

import static org.gpt.util.ReadApiKeyFromFile.getApiKeyFromFile;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateImageTest {

    @Test
    void createImageTest() {
        ApiKeyFileData keyData = getApiKeyFromFile();

        assertNotNull(keyData);

        ChatGPT gpt = new ChatGPT(keyData.getApiKey(), keyData.getOrganization());

        //Completion Data, ready to send to the ChatGPT Api
        ImageData image = new ImageData();
        image.setPrompt("A cute baby sea otter");
        image.setN(2);
        image.setSize("1024x1024");

        ImageResponseData data = gpt.createImageResponse(image);

        assertFalse(data.getData().isEmpty());
    }

}