package cn.gjsm.miukoo.demo;

import cn.gjsm.miukoo.Constants;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        OpenAiService service = new OpenAiService(Constants.OPENAPI_TOKEN,60000);
        CompletionRequest completionRequest = CompletionRequest.builder().model("text-davinci-003")
                .prompt("用阿里的sdk创建发送短信额java代码").temperature(0.3D)
                .maxTokens(1000).topP(1D).frequencyPenalty(0D).presencePenalty(0D).build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }


}
