# http-request-repeater

<p>
  <a target="_blank" rel="noopener noreferrer" href="https://github.com/maybetm/http-request-repeater/actions?query=workflow%3Aany-build">
    <img src="https://github.com/maybetm/http-request-repeater/workflows/any-build/badge.svg" alt="" style="max-width:100%;">
  </a>
</p>

Sync http request repeater

### Application Input Parameters:

```
parameter 1: repeat time in seconds example: 500;
parameter 2: url exmaple: "https://domain.com/endPoint";
parameter 3: request body; 

example request json body:
"{\"type\":\"message_new\",\"object\":{\"date\":date_long,
\"from_id\":from_id,\"id\":111,\"out\":0,\"peer_id\":peer_id,
\"text\":\"??\",\"conversation_message_id\":9999,\"fwd_messages\":[],
\"important\":false,\"random_id\":0,
\"attachments\":[],\"payload\":\"{\\"category\\":\\"first\\"}\",
\"is_hidden\":false},\"group_id\":group_id,
\"event_id\":\"event_id\",\"secret\":\"secred\"}"
```

### Run jar example: 

```
java 500 "https://domain.com/endPoint" "{\"type\":\"message_new\",
\"object\":{\"date\":date_long,\"from_id\":from_id,
\"id\":3333,\"out\":0,\"peer_id\":peer_id,\"text\":\"??\",
\"conversation_message_id\":9999,\"fwd_messages\":[],
\"important\":false,\"random_id\":0,\"attachments\":[],
\"payload\":\"{\\"category\\":\\"first\\"}\",
\"is_hidden\":false},\"group_id\":group_id,
\"event_id\":\"event_id\",\"secret\":\"secred\"}"
-jar http-request-repeater-1.0.jar
```
