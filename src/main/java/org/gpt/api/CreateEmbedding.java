package org.gpt.api;

import org.gpt.ChatGPT;
import org.gpt.api.data.embedding.EmbeddingData;
import org.gpt.net.ChatGPTEndpoints;
import org.gpt.net.RequestBuilder;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.atomic.AtomicReference;

public class CreateEmbedding {

    private final AtomicReference<HttpResponse<String>> response = new AtomicReference<>();
    private final ChatGPT gpt;

    private final EmbeddingData embedding;

    public CreateEmbedding(ChatGPT gpt, EmbeddingData embedding) {
        this.gpt = gpt;
        this.embedding = embedding;
        this.initialize();
    }

    public void initialize() {
        gpt.getHttpClientInstance().getResponse(embedding, new RequestBuilder() {
                    @Override
                    public HttpRequest request(Object data) {
                        if(data instanceof EmbeddingData) {
                            return post(ChatGPTEndpoints.CREATE_EMBEDDING.uri(),
                                    ((EmbeddingData) data).toJson(),
                                    gpt.getApiKey(),
                                    gpt.getOrganization()
                            );
                        }
                        return null;
                    }
                })
                .thenAccept(this.response::set)
                .join();
    }

    public AtomicReference<HttpResponse<String>> getResponse() {
        return response;
    }

    public String getBody() {
        return String.valueOf(response.get().body());
    }

}
