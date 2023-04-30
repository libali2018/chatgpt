package cn.gjsm.miukoo.openai;

import cn.gjsm.miukoo.Constants;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

import java.util.Arrays;

public class OpenAi14 {
    public static void main(String[] args) {
        OpenAiService service = new OpenAiService(Constants.OPENAPI_TOKEN);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("code-davinci-002")
                .prompt("##### 把这段代码从Python翻译成Java\\n### Python\\n    \\n    def predict_proba(X: Iterable[str]):\\n        return np.array([predict_one_probas(tweet) for tweet in X])\\n    \\n### Java")
                .temperature(0D)
                .maxTokens(200)
                .topP(1D)
                .frequencyPenalty(0D)
                .presencePenalty(0D)
                .stop(Arrays.asList("###"))
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
