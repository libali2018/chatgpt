package cn.gjsm.miukoo.openai;

import cn.gjsm.miukoo.Constants;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

import java.util.Arrays;

public class OpenAi28 {
    public static void main(String[] args) {
        OpenAiService service = new OpenAiService(Constants.OPENAPI_TOKEN);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("抽取下面文本中的航空代码：\\n文本：\\\"我下午从重庆飞北京\\\"\\n航空代码：")
                .temperature(0D)
                .maxTokens(200)
                .topP(1D)
                .frequencyPenalty(0.0D)
                .presencePenalty(0D)
                .stop(Arrays.asList("\n"))
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
