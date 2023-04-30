package cn.gjsm.miukoo.openai;

import cn.gjsm.miukoo.Constants;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

import java.util.Arrays;

public class OpenAi04 {
    public static void main(String[] args) {
        OpenAiService service = new OpenAiService(Constants.OPENAPI_TOKEN);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("code-davinci-002")
                .prompt("\\\"\\\"\\\"\\nUtil exposes the following:\\nutil.openai() -> authenticates & returns the openai module, which has the following functions:\\nopenai.Completion.create(\\n    prompt=\\\"<my prompt>\\\", # The prompt to start completing from\\n    max_tokens=123, # The max number of tokens to generate\\n    temperature=1.0 # A measure of randomness\\n    echo=True, # Whether to return the prompt in addition to the generated completion\\n)\\n\\\"\\\"\\\"\\nimport util\\n\\\"\\\"\\\"\\n创建一个OpenAI completion，提示是“你好”，最大令牌时5\\n\\\"\\\"\\\"\\n\\n")
                .temperature(0.7D)
                .maxTokens(1000)
                .topP(1D)
                .frequencyPenalty(0D)
                .presencePenalty(0D)
                .stop(Arrays.asList("\"\"\""))
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
