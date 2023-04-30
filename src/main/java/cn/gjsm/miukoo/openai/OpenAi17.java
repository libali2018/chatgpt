package cn.gjsm.miukoo.openai;

import cn.gjsm.miukoo.Constants;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

import java.util.Arrays;

public class OpenAi17 {
    public static void main(String[] args) {
        OpenAiService service = new OpenAiService(Constants.OPENAPI_TOKEN);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("抽取下面内容的关键字:\\n非结构化数据主要是指那些无法用固定结构来逻辑表达实现的数据,简单来说就是用户散落在论坛、微博、微信或其他渠道发表的关于产品的各种评价或吐槽。")
                .temperature(0.5D)
                .maxTokens(200)
                .topP(1D)
                .frequencyPenalty(0.8D)
                .presencePenalty(0D)
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
