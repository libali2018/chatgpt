package cn.gjsm.miukoo.openai;

import cn.gjsm.miukoo.Constants;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

import java.util.Arrays;

public class OpenAi26 {
    public static void main(String[] args) {
        OpenAiService service = new OpenAiService(Constants.OPENAPI_TOKEN);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("列出10首周杰伦的歌曲:")
                .temperature(0.5D)
                .maxTokens(200)
                .topP(1D)
                .frequencyPenalty(0.52D)
                .presencePenalty(0.5D)
                .stop(Arrays.asList("11."))
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
