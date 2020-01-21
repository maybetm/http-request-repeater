# http-request-repeater

<p>
  <a target="_blank" rel="noopener noreferrer" href="https://github.com/maybetm/http-request-repeater/actions?query=workflow%3Aany-build">
    <img src="https://github.com/maybetm/http-request-repeater/workflows/any-build/badge.svg" alt="" style="max-width:100%;">
  </a>
</p>

Synchronous http requests repeater

Application Input Parameters:

parameter 1: repeat time in seconds example: 500;
parameter 2: url exmaple: "https://domain.com/endPoint";
parameter 3: request body; 
example:
"{\"type\":\"message_new\",\"object\":{\"date\":date_long,\"from_id\":from_id,\"id\":10217,\"out\":0,\"peer_id\":peer_id,\"text\":\"??\",\"conversation_message_id\":9140,\"fwd_messages\":[],\"important\":false,\"random_id\":0,\"attachments\":[],\"payload\":\"{\\"category\\":\\"first\\"}\",\"is_hidden\":false},\"group_id\":group_id,\"event_id\":\"event_id\",\"secret\":\"secred\"}"

run jar example: 

java 500 "http://91.240.84.114/vkProducer" "{\"type\":\"message_new\",\"object\":{\"date\":date_long,\"from_id\":from_id,\"id\":10217,\"out\":0,\"peer_id\":peer_id,\"text\":\"??\",\"conversation_message_id\":9140,\"fwd_messages\":[],\"important\":false,\"random_id\":0,\"attachments\":[],\"payload\":\"{\\"category\\":\\"first\\"}\",\"is_hidden\":false},\"group_id\":group_id,\"event_id\":\"event_id\",\"secret\":\"secred\"}" -jar http-request-repeater-1.0.jar
