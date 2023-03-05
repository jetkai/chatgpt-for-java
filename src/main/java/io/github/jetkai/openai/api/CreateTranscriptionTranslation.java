package io.github.jetkai.openai.api;

import io.github.jetkai.openai.api.data.audio.AudioData;
import io.github.jetkai.openai.net.OpenAIEndpoints;

/**
 * CreateTranscriptionTranslation
 *
 * @author <a href="https://github.com/jetkai">Kai</a>
 * @version 1.0.1
 * {@code - 05/03/2023}
 * @since 1.0.0
 * {@code - 02/03/2023}
 */
public class CreateTranscriptionTranslation extends CreateTranscription {

    /**
     * CreateTranslation
     * @param translation - The translation data specified
     */
    public CreateTranscriptionTranslation(AudioData translation) {
        super(translation, OpenAIEndpoints.CREATE_AUDIO_TRANSLATION);
    }

}
